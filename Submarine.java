/* File: Submarine.java	
Instructions to draw a Submarine on the screen.
*/
	
import java.awt.*;

public class Submarine 
{
	/**
		Constructs a submarine with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	/*
	private int xLeft;
	private int yTop;
	
	public Submarine(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	*/
	public static void paint(Graphics g, int xLeft, int yTop)
		{
					
			Color navyGrey = new Color( 180, 180, 180);			
			g.setColor(navyGrey);
			//Shape of Submarine
			g.fillOval(xLeft, yTop, 20, 60);
			
			//Detail of the Sub
			g.setColor(Color.black);
			g.drawOval(xLeft, yTop, 20, 60); //Outline of the submarine
			g.drawOval(xLeft+5, yTop +5, 10, 10);
			g.setColor(navyGrey);
			g.fillRect(xLeft+5,yTop+10,10,6);
			g.setColor(Color.black);
			
			//Torpedo Tubes
			g.fillOval(xLeft+7, yTop +10, 2, 2);
			g.fillOval(xLeft+11, yTop +10, 2, 2);
			
			//Tail Fins
			g.drawLine(xLeft+5,yTop+10,xLeft+5,yTop+50);
			g.drawLine(xLeft+15,yTop+10,xLeft+15,yTop+50);
			g.drawLine(xLeft+10,yTop+15,xLeft+10,yTop+45);
			g.drawLine(xLeft+5,yTop+50,xLeft+10,yTop+55);
			g.drawLine(xLeft+15,yTop+50,xLeft+10,yTop+55);
			
			g.drawLine(xLeft+5,yTop+60,xLeft+15,yTop+60);



		
		}
		
}			

/* Original unscaled code

/* File: Submarine.java	
Instructions to draw a Submarine on the screen.

	
import java.awt.*;

public class Submarine 
{
	/**
		Constructs a submarine with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	
	
	private int xLeft;
	private int yTop;
	
	public Submarine(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void paint(Graphics g)
		{
					
			Color navyGrey = new Color( 180, 180, 180);			
			g.setColor(navyGrey);
			//Shape of Submarine
			g.fillOval(xLeft, yTop, 40, 120);
			
			//Detail of the Sub
			g.setColor(Color.black);
			g.drawOval(xLeft, yTop, 40, 120); //Outline of the submarine
			g.drawOval(xLeft+10, yTop +10, 20, 20);
			g.setColor(navyGrey);
			g.fillRect(xLeft+10,yTop+20,20,11);
			g.setColor(Color.black);
			
			//Torpedo Tubes
			g.fillOval(xLeft+15, yTop +20, 3, 3);
			g.fillOval(xLeft+23, yTop +20, 3, 3);
			
			//Tail Fins
			g.drawLine(xLeft+10,yTop+20,xLeft+10,yTop+100);
			g.drawLine(xLeft+30,yTop+20,xLeft+30,yTop+100);
			g.drawLine(xLeft+20,yTop+30,xLeft+20,yTop+90);
			g.drawLine(xLeft+10,yTop+100,xLeft+20,yTop+110);
			g.drawLine(xLeft+30,yTop+100,xLeft+20,yTop+110);
			
			g.drawLine(xLeft+10,yTop+120,xLeft+30,yTop+120);



		
		}
		
}			
*/