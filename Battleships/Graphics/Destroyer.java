package Battleships.Graphics;
/* File: Destroyer.java	
Instructions to draw a Destroyer on the screen.
*/
	
import java.awt.*;

public class Destroyer 
{
	/**
		Constructs a Destroyer with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	/*
	private int xLeft;
	private int yTop;
	
	public Destroyer(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	*/
	public static void paint(Graphics g, int xLeft, int yTop)
		{
			//Ellipse2D.Double(xLeft,yTop,80,40,);
			
			Color navyGrey = new Color( 180, 180, 180);			
			
			
			//draw main body of ship
			g.setColor(navyGrey);
			g.fillOval(xLeft, yTop, 20, 60);
			//draw detail
			g.setColor(Color.black);	
			
			g.drawOval(xLeft, yTop, 20, 60); //outline
			g.setColor(navyGrey);
			g.fillRect(xLeft,yTop+20,20,40);
			
			g.setColor(Color.black);
			
						
			//Mid deck tower
			g.drawRect(xLeft+5,yTop+40,10,15);
			g.drawLine(xLeft+5,yTop+40,xLeft+10,yTop+20);
			g.drawLine(xLeft+10,yTop+20,xLeft+15,yTop+40);
			g.drawRect(xLeft+7,yTop+45,5,5);
			
			//Gun Barrel
			g.drawOval(xLeft+5, yTop +5, 10, 10);
			g.drawLine(xLeft+10,yTop,xLeft+10,yTop+10);
			
			//Outline of the stern of the ship
			g.drawLine(xLeft,yTop+20,xLeft,yTop+60);
			g.drawLine(xLeft,yTop+60,xLeft+20,yTop+60);
			g.drawLine(xLeft+20,yTop+60,xLeft+20,yTop+20);
			
			
		}
		
}			

/*original code unscaled
/* File: Destroyer.java	
Instructions to draw a Destroyer on the screen.
*
	
import java.awt.*;

public class Destroyer 
{
	/**
		Constructs a Destroyer with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	/
	
	private int xLeft;
	private int yTop;
	
	public Destroyer(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void paint(Graphics g)
		{
			//Ellipse2D.Double(xLeft,yTop,80,40,);
			
			Color navyGrey = new Color( 180, 180, 180);			
			
			
			//draw main body of ship
			g.setColor(navyGrey);
			g.fillOval(xLeft, yTop, 40, 120);
			//draw detail
			g.setColor(Color.black);	
			
			g.drawOval(xLeft, yTop, 40, 120); //outline
			g.setColor(navyGrey);
			g.fillRect(xLeft,yTop+40,40,80);
			
			g.setColor(Color.black);
			
						
			//Mid deck tower
			g.drawRect(xLeft+10,yTop+80,20,30);
			g.drawLine(xLeft+10,yTop+80,xLeft+20,yTop+40);
			g.drawLine(xLeft+20,yTop+40,xLeft+30,yTop+80);
			g.drawRect(xLeft+15,yTop+90,10,10);
			
			//Gun Barrel
			g.drawOval(xLeft+10, yTop +10, 20, 20);
			g.drawLine(xLeft+20,yTop,xLeft+20,yTop+20);
			
			//Outline of the stern of the ship
			g.drawLine(xLeft,yTop+40,xLeft,yTop+120);
			g.drawLine(xLeft,yTop+120,xLeft+40,yTop+120);
			g.drawLine(xLeft+40,yTop+120,xLeft+40,yTop+40);
			
			


		
		}
		
}			

*/