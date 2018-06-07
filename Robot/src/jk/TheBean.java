package jk;

import robocode.*;
import robocode.util.Utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*; // for Point2D's
import java.lang.*; // for Double and Integer objects
import java.util.ArrayList; // for collection of waves

public class TheBean extends AdvancedRobot {
	public static int BINS = 47;
	public static double _surfStats[] = new double[BINS];
	public Point2D.Double _myLocation; 
	public Point2D.Double _enemyLocation; 

	public ArrayList<EnemyWave> _enemyWaves;
	public ArrayList<Integer> _surfDirections;
	public ArrayList<Double> _surfAbsBearings;

	// gun variables
	static double enemyVelocities[][] = new double[400][4];
	static int currentEnemyVelocity;
	static int aimingEnemyVelocity;
	double velocityToAimAt;
	boolean fired;
	double oldTime;
	int count;
	int averageCount;
	double bulletPower;

	double oldEnemyHeading;

	int lossCount = 0;
	double previousEnergy = 100;
	int movementDirection = 1;

	public static double _oppEnergy = 100.0;

	public static Rectangle2D.Double _fieldRect = new java.awt.geom.Rectangle2D.Double(18, 18, 764, 564);
	public static double WALL_STICK = 160;

	public void run() {
		// setBodyColor(Color.magenta);
		// setGunColor(Color.lightGray);
		setRadarColor(Color.magenta);
		setScanColor(Color.white);
		_enemyWaves = new ArrayList<EnemyWave>();
		_surfDirections = new ArrayList<Integer>();
		_surfAbsBearings = new ArrayList<Double>();

		setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(true);

		do {

			turnRadarRightRadians(Double.POSITIVE_INFINITY);
		} while (true);
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		double absBearing = e.getBearingRadians() + getHeadingRadians();

		_myLocation = new Point2D.Double(getX(), getY());

		double lateralVelocity = getVelocity() * Math.sin(e.getBearingRadians());

		setTurnRadarRightRadians(Utils.normalRelativeAngle(absBearing - getRadarHeadingRadians()) * 2);

		_surfDirections.add(0, new Integer((lateralVelocity >= 0) ? 1 : -1));
		_surfAbsBearings.add(0, new Double(absBearing + Math.PI));

		double bulletPower = _oppEnergy - e.getEnergy();
		if (bulletPower < 3.01 && bulletPower > 0.09 && _surfDirections.size() > 2) {
			EnemyWave ew = new EnemyWave();
			ew.fireTime = getTime() - 1;
			ew.bulletVelocity = bulletVelocity(bulletPower);
			ew.distanceTraveled = bulletVelocity(bulletPower);
			ew.direction = ((Integer) _surfDirections.get(2)).intValue();
			ew.directAngle = ((Double) _surfAbsBearings.get(2)).doubleValue();
			ew.fireLocation = (Point2D.Double) _enemyLocation.clone();

			_enemyWaves.add(ew);
		}

		_oppEnergy = e.getEnergy();

		_enemyLocation = project(_myLocation, absBearing, e.getDistance());

		updateWaves();
		doSurfing();

		Graphics2D g = getGraphics();
		if (e.getVelocity() < -2) {
			currentEnemyVelocity = 0;
		} else if (e.getVelocity() > 2) {
			currentEnemyVelocity = 1;
		} else if (e.getVelocity() <= 2 && e.getVelocity() >= -2) {
			if (currentEnemyVelocity == 0) {
				currentEnemyVelocity = 2;
			} else if (currentEnemyVelocity == 1) {
				currentEnemyVelocity = 3;
			}
		}

		if (getTime() - oldTime > e.getDistance() / 12.8 && fired == true) {
			aimingEnemyVelocity = currentEnemyVelocity;
		} else {
			fired = false;
		}

		enemyVelocities[count][aimingEnemyVelocity] = e.getVelocity();
		count++;
		if (count == 400) {
			count = 0;
		}

		averageCount = 0;
		velocityToAimAt = 0;
		while (averageCount < 400) {
			velocityToAimAt += enemyVelocities[averageCount][currentEnemyVelocity];
			averageCount++;
		}
		velocityToAimAt /= 400;

		bulletPower = Math.min(2.4, Math.min(e.getEnergy() / 4, getEnergy() / 10));
		double myX = getX();
		double myY = getY();
		double enemyX = getX() + e.getDistance() * Math.sin(absBearing);
		double enemyY = getY() + e.getDistance() * Math.cos(absBearing);
		double enemyHeading = e.getHeadingRadians();
		double enemyHeadingChange = enemyHeading - oldEnemyHeading;
		oldEnemyHeading = enemyHeading;
		double deltaTime = 0;
		double battleFieldHeight = getBattleFieldHeight(), battleFieldWidth = getBattleFieldWidth();
		double predictedX = enemyX, predictedY = enemyY;
		while ((++deltaTime) * (20.0 - 3.0 * bulletPower) < Point2D.Double.distance(myX, myY, predictedX, predictedY)) {
			predictedX += Math.sin(enemyHeading) * velocityToAimAt;
			predictedY += Math.cos(enemyHeading) * velocityToAimAt;
			enemyHeading += enemyHeadingChange;
			g.setColor(Color.red);
			g.fillOval((int) predictedX - 2, (int) predictedY - 2, 4, 4);
			if (predictedX < 18.0 || predictedY < 18.0 || predictedX > battleFieldWidth - 18.0
					|| predictedY > battleFieldHeight - 18.0) {

				predictedX = Math.min(Math.max(18.0, predictedX), battleFieldWidth - 18.0);
				predictedY = Math.min(Math.max(18.0, predictedY), battleFieldHeight - 18.0);
				break;
			}
		}
		double theta = Utils.normalAbsoluteAngle(Math.atan2(predictedX - getX(), predictedY - getY()));

		setTurnRadarRightRadians(Utils.normalRelativeAngle(absBearing - getRadarHeadingRadians()) * 2);
		setTurnGunRightRadians(Utils.normalRelativeAngle(theta - getGunHeadingRadians()));
		if (getGunHeat() == 0) {
			if (getEnergy() - bulletPower > .1) {
				fire(bulletPower);
				fired = true;
			}
		}
	}

	public void updateWaves() {
		for (int x = 0; x < _enemyWaves.size(); x++) {
			EnemyWave ew = (EnemyWave) _enemyWaves.get(x);

			ew.distanceTraveled = (getTime() - ew.fireTime) * ew.bulletVelocity;
			if (ew.distanceTraveled > _myLocation.distance(ew.fireLocation) + 50) {
				_enemyWaves.remove(x);
				x--;
			}
		}
	}

	public EnemyWave getClosestSurfableWave() {
		double closestDistance = 50000;
		EnemyWave surfWave = null;

		for (int x = 0; x < _enemyWaves.size(); x++) {
			EnemyWave ew = (EnemyWave) _enemyWaves.get(x);
			double distance = _myLocation.distance(ew.fireLocation) - ew.distanceTraveled;

			if (distance > ew.bulletVelocity && distance < closestDistance) {
				surfWave = ew;
				closestDistance = distance;
			}
		}

		return surfWave;
	}

	public static int getFactorIndex(EnemyWave ew, Point2D.Double targetLocation) {
		double offsetAngle = (absoluteBearing(ew.fireLocation, targetLocation) - ew.directAngle);
		double factor = Utils.normalRelativeAngle(offsetAngle) / maxEscapeAngle(ew.bulletVelocity) * ew.direction;

		return (int) limit(0, (factor * ((BINS - 1) / 2)) + ((BINS - 1) / 2), BINS - 1);
	}

	public void logHit(EnemyWave ew, Point2D.Double targetLocation) {
		int index = getFactorIndex(ew, targetLocation);

		for (int x = 0; x < BINS; x++) {

			_surfStats[x] += 1.0 / (Math.pow(index - x, 2) + 1);
		}
	}

	public void onHitByBullet(HitByBulletEvent e) {

		if (!_enemyWaves.isEmpty()) {
			Point2D.Double hitBulletLocation = new Point2D.Double(e.getBullet().getX(), e.getBullet().getY());
			EnemyWave hitWave = null;

			for (int x = 0; x < _enemyWaves.size(); x++) {
				EnemyWave ew = (EnemyWave) _enemyWaves.get(x);

				if (Math.abs(ew.distanceTraveled - _myLocation.distance(ew.fireLocation)) < 50
						&& Math.abs(bulletVelocity(e.getBullet().getPower()) - ew.bulletVelocity) < 0.001) {
					hitWave = ew;
					break;
				}
			}

			if (hitWave != null) {
				logHit(hitWave, hitBulletLocation);

				_enemyWaves.remove(_enemyWaves.lastIndexOf(hitWave));
			}
		}
	}

	public Point2D.Double predictPosition(EnemyWave surfWave, int direction) {
		Point2D.Double predictedPosition = (Point2D.Double) _myLocation.clone();
		double predictedVelocity = getVelocity();
		double predictedHeading = getHeadingRadians();
		double maxTurning, moveAngle, moveDir;

		int counter = 0;
		boolean intercepted = false;

		do {
			moveAngle = wallSmoothing(predictedPosition,
					absoluteBearing(surfWave.fireLocation, predictedPosition) + (direction * (Math.PI / 2)), direction)
					- predictedHeading;
			moveDir = 1;

			if (Math.cos(moveAngle) < 0) {
				moveAngle += Math.PI;
				moveDir = -1;
			}

			moveAngle = Utils.normalRelativeAngle(moveAngle);

			maxTurning = Math.PI / 720d * (40d - 3d * Math.abs(predictedVelocity));
			predictedHeading = Utils.normalRelativeAngle(predictedHeading + limit(-maxTurning, moveAngle, maxTurning));

			predictedVelocity += (predictedVelocity * moveDir < 0 ? 2 * moveDir : moveDir);
			predictedVelocity = limit(-8, predictedVelocity, 8);

			predictedPosition = project(predictedPosition, predictedHeading, predictedVelocity);

			counter++;

			if (predictedPosition.distance(surfWave.fireLocation) < surfWave.distanceTraveled
					+ (counter * surfWave.bulletVelocity) + surfWave.bulletVelocity) {
				intercepted = true;
			}
		} while (!intercepted && counter < 500);

		return predictedPosition;
	}

	public double checkDanger(EnemyWave surfWave, int direction) {
		int index = getFactorIndex(surfWave, predictPosition(surfWave, direction));

		return _surfStats[index];
	}

	public void doSurfing() {
		EnemyWave surfWave = getClosestSurfableWave();

		if (surfWave == null) {
			return;
		}

		double dangerLeft = checkDanger(surfWave, -1);
		double dangerRight = checkDanger(surfWave, 1);

		double goAngle = absoluteBearing(surfWave.fireLocation, _myLocation);
		if (dangerLeft < dangerRight) {
			goAngle = wallSmoothing(_myLocation, goAngle - (Math.PI / 2), -1);
		} else {
			goAngle = wallSmoothing(_myLocation, goAngle + (Math.PI / 2), 1);
		}

		setBackAsFront(this, goAngle);
	}

	class EnemyWave {
		Point2D.Double fireLocation;
		long fireTime;
		double bulletVelocity, directAngle, distanceTraveled;
		int direction;

		public EnemyWave() {
		}
	}

	public double wallSmoothing(Point2D.Double botLocation, double angle, int orientation) {
		while (!_fieldRect.contains(project(botLocation, angle, 160))) {
			angle += orientation * 0.05;
		}
		return angle;
	}

	public static Point2D.Double project(Point2D.Double sourceLocation, double angle, double length) {
		return new Point2D.Double(sourceLocation.x + Math.sin(angle) * length,
				sourceLocation.y + Math.cos(angle) * length);
	}

	public static double absoluteBearing(Point2D.Double source, Point2D.Double target) {
		return Math.atan2(target.x - source.x, target.y - source.y);
	}

	public static double limit(double min, double value, double max) {
		return Math.max(min, Math.min(value, max));
	}

	public static double bulletVelocity(double power) {
		return (20D - (3D * power));
	}

	public static double maxEscapeAngle(double velocity) {
		return Math.asin(8.0 / velocity);
	}

	public static void setBackAsFront(AdvancedRobot robot, double goAngle) {
		double angle = Utils.normalRelativeAngle(goAngle - robot.getHeadingRadians());
		if (Math.abs(angle) > (Math.PI / 2)) {
			if (angle < 0) {
				robot.setTurnRightRadians(Math.PI + angle);
			} else {
				robot.setTurnLeftRadians(Math.PI - angle);
			}
			robot.setBack(100);
		} else {
			if (angle < 0) {
				robot.setTurnLeftRadians(-1 * angle);
			} else {
				robot.setTurnRightRadians(angle);
			}
			robot.setAhead(100);
		}
	}

	public void onPaint(java.awt.Graphics2D g) {
		g.setColor(java.awt.Color.red);
		for (int i = 0; i < _enemyWaves.size(); i++) {
			EnemyWave w = (EnemyWave) (_enemyWaves.get(i));
			Point2D.Double center = w.fireLocation;

			int radius = (int) w.distanceTraveled;
			if (radius - 40 < center.distance(_myLocation))
				g.drawOval((int) (center.x - radius), (int) (center.y - radius), radius * 2, radius * 2);
		}
	}

	public void onLoss() {
		lossCount++;
	}
}