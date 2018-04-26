package journals;

public class Journal031218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time test = new Time(555550000l);
		System.out.println(test);
	}

}

class Time {
	private int hour, minute, second;

	public Time() {
		long cum_ms = System.currentTimeMillis();
		setTime(cum_ms);
	}

	public Time(long elapsed) {
		setTime(elapsed);
	}

	public Time(int hour, int minute, int second) {
		setTime(hour, minute, second);
	}

	public void setTime(int _hour, int _minute, int _second) {
		hour = _hour;
		minute = _minute;
		second = _second;
	}

	public void setTime(long elapseTime) {
		long cum_ms = elapseTime;
		long cum_s = cum_ms / 1000;
		long s = cum_s % 60;
		long cum_min = cum_s / 60;
		long min = cum_min % 60;
		long cum_hour = cum_min / 60;
		long hour = cum_hour % 24;
		setTime((int) hour, (int) min, (int) s);
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	public String toString() {
		return "" + hour + ":" + minute + ":" + second;
	}

}