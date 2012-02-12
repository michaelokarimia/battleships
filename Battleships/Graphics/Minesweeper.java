package Battleships.Graphics;
/* File: Minesweeper.java	
Instructions to draw a Minesweeper on the screen.
*/
	
import java.awt.*;

public class Minesweeper 
{
	/**
		Constructs a Minesweeper with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	/*
	private int xLeft;
	private int yTop;
	
	public Minesweeper(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	*/
	public static void  paint(Graphics g, int xLeft, int yTop)
		{
			
			//Color of the ship
			Color navyGrey = new Color( 180, 180, 180);			
			g.setColor(navyGrey);
			//Draw Main Body of ship
			g.fillOval(xLeft, yTop, 20, 40);
			//Draw detail on ship
			g.setColor(Color.black);	
			g.drawOval(xLeft, yTop, 20, 40);
			g.setColor(navyGrey);
			g.fillRect(xLeft,yTop+20,20,20);
			g.setColor(Color.black);
			g.drawOval(xLeft+5, yTop +5, 10, 10);
						
				
			g.drawRect(xLeft+5,yTop+20,10,15);
			
			g.drawRect(xLeft+7,yTop+25,5,5);
			
			g.drawLine(xLeft+10,yTop,xLeft+10,yTop+10);
			
			g.setColor(Color.black);
			g.drawLine(xLeft,yTop+20,xLeft,yTop+40);
			
			g.drawLine(xLeft,yTop+40,xLeft+20,yTop+40);
			
			g.drawLine(xLeft+20,yTop+40,xLeft+20,yTop+20);


		
		}
		
}			


/* original code unscaled


/* File: Minesweeper.java	
Instructions to draw a Minesweeper on the screen.
*
	
import java.awt.*;

public class Minesweeper 
{
	/**
		Constructs a Minesweeper with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	/
	
	private int xLeft;
	private int yTop;
	
	public Minesweeper(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void paint(Graphics g)
		{
			
			//Color of the ship
			Color navyGrey = new Color( 180, 180, 180);			
			g.setColor(navyGrey);
			//Draw Main Body of ship
			g.fillOval(xLeft, yTop, 40, 80);
			//Draw detail on ship
			g.setColor(Color.black);	
			g.drawOval(xLeft, yTop, 40, 80);
			g.setColor(navyGrey);
			g.fillRect(xLeft,yTop+40,40,40);
			g.setColor(Color.black);
			g.drawOval(xLeft+10, yTop +10, 20, 20);
						
				
			g.drawRect(xLeft+10,yTop+40,20,30);
			
			g.drawRect(xLeft+15,yTop+50,10,10);
			
			g.drawLine(xLeft+20,yTop,xLeft+20,yTop+20);
			
			g.setColor(Color.black);
			g.drawLine(xLeft,yTop+40,xLeft,yTop+80);
			
			g.drawLine(xLeft,yTop+80,xLeft+40,yTop+80);
			
			g.drawLine(xLeft+40,yTop+80,xLeft+40,yTop+40);


		
		}
		
}			
*/


