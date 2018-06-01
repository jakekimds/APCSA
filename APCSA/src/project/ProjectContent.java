package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ProjectContent extends Canvas implements KeyListener, Runnable
{
	private MainCharacter ship;
	private Background ground;
	private Random r;
	private int stage;
	private int score;
	private int lives;
	
	private Heart lifeUp;
	private Theme theme;
	/*private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	private ArrayList<Ammo> shots2;

	
	private Aliens squad;*/
	
	private int timer;
	private int timer2;

	private ArrayList<BadSquare> squares;
	private ArrayList<GoodSquare> squares2;
	private boolean[] keys;
	private BufferedImage back;
	private int[] possX;
	public ProjectContent()
	{
		setBackground(Color.black);
		score=0;
		stage=0;
		lives=10;
		keys = new boolean[5];
		r=new Random();
		//instantiate other stuff
		ship=new MainCharacter(300,400,3);
		ground=new Background(0,475);
		theme=new Theme(0,0);
		squares=new ArrayList<BadSquare>();
		squares2=new ArrayList<GoodSquare>();
		lifeUp=new Heart(360,0,1);
		timer=0;
		timer2=0;
		possX=new int[9];
		for(int x=0;x<possX.length;x++){
			possX[x]=x*90;
		}
		/*aliens=new ArrayList<Alien>();
		shots=new ArrayList<Ammo>();
		shots2=new ArrayList<Ammo>();

		aliens.add(new Alien(100,100,3));
		aliens.add(new Alien(200,100,3));
		squad=new Aliens();*/
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;
		 
		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		
		graphToBack.setColor(Color.white);
		graphToBack.fillRect(0,0,800,600);
		
		if(stage==0){
			lives=10;
			score=0;
			graphToBack.setColor(Color.blue);
			graphToBack.drawString("Johnny Ren- Period 4 APCSA (SHOUTOUT TO ALL THE PEARS!)", 300,50);

			graphToBack.drawString("Welcome to Falling Squares", 300,100);
			graphToBack.drawString("Collect Green Squares to earn points", 300,150);
			graphToBack.drawString("Collect 6 points to beat level 1", 300,200);
			graphToBack.drawString("Collect 8 points to beat level 2", 300,250);
			graphToBack.drawString("Collect 10 points to beat level 3", 300,300);

			graphToBack.drawString("Avoid red squares; they cause you to lose lives", 300,350);
			graphToBack.drawString("Press Space to Begin", 300,400);
			
			if(keys[4] == true)
			{
				stage=1;
			}
			
		}
		
		if(stage==1){
		theme.draw(graphToBack, 1);
		ship.draw(graphToBack);
		ground.draw(graphToBack);
		
		timer++;
		timer2++;
		if(timer%100==0){
			timer=0;
			squares.add(new BadSquare(possX[r.nextInt(possX.length)],0,2));
		}
		if(timer2%250==0){
			timer2=0;
			squares2.add(new GoodSquare(possX[r.nextInt(possX.length)],0,3));
		}

		for(Square s: squares){
			s.draw(graphToBack);
		}
		for(Square s: squares2){
			s.draw(graphToBack);
		}
		
		
		if(ship.getX()>0){
		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		}
		if(ship.getX()<700){
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		}
		
		for(Square s: squares){
			if(s.getY()+80>=ship.getY() && s.getY()<=ship.getY()+80){
				if(s.getX()+80>=ship.getX() && ship.getX()+80>s.getX()){
					s.setPos(-100, -100);
					
					lives--;
				}
			}
		}
		for(Square s: squares2){
			if(s.getY()+80>=ship.getY() && s.getY()<=ship.getY()+80){
				if(s.getX()+80>=ship.getX() && ship.getX()+80>s.getX()){
					s.setPos(-100, -100);
					
					score++;
				}
			}
		}
		graphToBack.drawString("Points: "+score, 300, 500);
		graphToBack.drawString("Lives: "+lives, 300, 550);
		if(lives<=0){
			stage=-1;
		}
		if(score>=6){
			stage=2;
			score=0;

		}
		}
		
		if(stage==2){
			theme.draw(graphToBack, 4);

			graphToBack.setColor(Color.blue);

			graphToBack.drawString("You beat level 1. Collect the heart for a life restore.", 100, 100);

			squares.clear();
			squares2.clear();
			ship.draw(graphToBack);
			ground.draw(graphToBack);
			lifeUp.draw(graphToBack);

			if(ship.getX()>0){
			if(keys[0] == true)
			{
				ship.move("LEFT");
			}
			}
			if(ship.getX()<700){
			if(keys[1] == true)
			{
				ship.move("RIGHT");
			}
			}
			
			if(lifeUp.getY()+80>=ship.getY() && lifeUp.getY()<=ship.getY()+80){
				if(lifeUp.getX()+80>=ship.getX() && ship.getX()+80>lifeUp.getX()){
					lifeUp.setPos(-100, 1000);
					
					lives=10;
				}
			}
			if(lifeUp.getY()>999){
				stage=3;
				lifeUp.setPos(360, 0);
			}

			
			timer=0;
			timer2=0;
			graphToBack.setColor(Color.white);

			graphToBack.drawString("Points: "+score, 300, 500);
			graphToBack.drawString("Lives: "+lives, 300, 550);
			squares.clear();
		}
		if(stage==3){
			theme.draw(graphToBack, 2);

			ship.draw(graphToBack);
			ground.draw(graphToBack);
			
			timer++;
			timer2++;
			if(timer%75==0){
				timer=0;
				squares.add(new BadSquare(possX[r.nextInt(possX.length)],0,2));
			}
			if(timer2%250==0){
				timer2=0;
				squares2.add(new GoodSquare(possX[r.nextInt(possX.length)],0,3));
			}

			for(Square s: squares){
				s.draw(graphToBack);
			}
			for(Square s: squares2){
				s.draw(graphToBack);
			}
			
			
			if(ship.getX()>0){
			if(keys[0] == true)
			{
				ship.move("LEFT");
			}
			}
			if(ship.getX()<700){
			if(keys[1] == true)
			{
				ship.move("RIGHT");
			}
			}
			
			for(Square s: squares){
				if(s.getY()+80>=ship.getY() && s.getY()<=ship.getY()+80){
					if(s.getX()+80>=ship.getX() && ship.getX()+80>s.getX()){
						s.setPos(-100, -100);
						
						lives--;
					}
				}
			}
			for(Square s: squares2){
				if(s.getY()+80>=ship.getY() && s.getY()<=ship.getY()+80){
					if(s.getX()+80>=ship.getX() && ship.getX()+80>s.getX()){
						s.setPos(-100, -100);
						
						score++;
					}
				}
			}
			graphToBack.drawString("Points: "+score, 300, 500);
			graphToBack.drawString("Lives: "+lives, 300, 550);
			if(lives<=0){
				stage=-1;
			}
			if(score>=8){
				stage=4;
				score=0;

			}
		}
		if(stage==4){
			theme.draw(graphToBack, 4);

			graphToBack.setColor(Color.blue);

			graphToBack.drawString("You beat level 2. Collect the heart for a life restore.", 100, 100);

			squares.clear();
			squares2.clear();
			ship.draw(graphToBack);
			ground.draw(graphToBack);
			lifeUp.draw(graphToBack);

			if(ship.getX()>0){
			if(keys[0] == true)
			{
				ship.move("LEFT");
			}
			}
			if(ship.getX()<700){
			if(keys[1] == true)
			{
				ship.move("RIGHT");
			}
			}
			
			if(lifeUp.getY()+80>=ship.getY() && lifeUp.getY()<=ship.getY()+80){
				if(lifeUp.getX()+80>=ship.getX() && ship.getX()+80>lifeUp.getX()){
					lifeUp.setPos(-100, 1000);
					
					lives=10;
				}
			}
			if(lifeUp.getY()>999){
				stage=5;
			}

			
			timer=0;
			timer2=0;
			graphToBack.setColor(Color.white);

			graphToBack.drawString("Points: "+score, 300, 500);
			graphToBack.drawString("Lives: "+lives, 300, 550);
			squares.clear();
		}
		if(stage==5){
			theme.draw(graphToBack, 3);

			ship.draw(graphToBack);
			ground.draw(graphToBack);
			
			timer++;
			timer2++;
			if(timer%50==0){
				timer=0;
				squares.add(new BadSquare(possX[r.nextInt(possX.length)],0,2));
			}
			if(timer2%200==0){
				timer2=0;
				squares2.add(new GoodSquare(possX[r.nextInt(possX.length)],0,3));
			}

			for(Square s: squares){
				s.draw(graphToBack);
			}
			for(Square s: squares2){
				s.draw(graphToBack);
			}
			
			
			if(ship.getX()>0){
			if(keys[0] == true)
			{
				ship.move("LEFT");
			}
			}
			if(ship.getX()<700){
			if(keys[1] == true)
			{
				ship.move("RIGHT");
			}
			}
			
			for(Square s: squares){
				if(s.getY()+80>=ship.getY() && s.getY()<=ship.getY()+80){
					if(s.getX()+80>=ship.getX() && ship.getX()+80>s.getX()){
						s.setPos(-100, -100);
						
						lives--;
					}
				}
			}
			for(Square s: squares2){
				if(s.getY()+80>=ship.getY() && s.getY()<=ship.getY()+80){
					if(s.getX()+80>=ship.getX() && ship.getX()+80>s.getX()){
						s.setPos(-100, -100);
						
						score++;
					}
				}
			}
			graphToBack.drawString("Points: "+score, 300, 500);
			graphToBack.drawString("Lives: "+lives, 300, 550);
			if(lives<=0){
				stage=-1;
			}
			if(score>=10){
				stage=6;
				score=0;
			}
		}
		if(stage==6){
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("You have won! Rejoice!", 300, 300);
			graphToBack.drawString("To play again press space.", 300, 350);
			squares.clear();
			squares2.clear();
			if(keys[4] == true)
			{
				keys[4]=false;
				stage=0;
				lifeUp.setPos(360, 0);

			}
		}
		if(stage==-1){
			graphToBack.setColor(Color.blue);
			graphToBack.drawString("To play again press space.", 300, 350);

			graphToBack.drawString("The kingdom has fallen. The squares have taken over. All is lost.", 300, 550);
			if(keys[4] == true)
			{
				keys[4]=false;
				stage=0;
				lifeUp.setPos(360, 0);

			}
		}
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}