package Battleships.Graphics;
/* File: AircraftCarrierH.java	
Instructions to draw a AircraftCarrier horizontally on the screen.
*/
	
import java.awt.*;

public class AircraftCarrierH 
{
	/**
		Constructs a AircraftCarrier horzintally with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	/*
	private int xLeft;
	private int yTop;
	
	public AircraftCarrierH(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	*/
	public static void paint(Graphics g, int xLeft, int yTop)
		{
			Color navyGrey = new Color( 180, 180, 180);			
			
			
			//draw main body of ship
			g.setColor(navyGrey);
			g.fillRect(xLeft, yTop, 100, 20);
			
			//draw detail
			g.setColor(Color.black);	
			
			g.drawRect(xLeft, yTop, 100, 20); //outline
			//g.setColor(navyGrey);
				
				
						
			//Mid deck tower
			g.drawRect(xLeft+40,yTop+15,20,5);
			g.drawRect(xLeft+45,yTop+17,10,3);
			
			//Draw Runway
			
			g.setColor(Color.white);
			g.fillRect(xLeft+3,yTop+10,10,1);
			g.fillRect(xLeft+15,yTop+10,10,1);
			g.fillRect(xLeft+28,yTop+10,10,1);
			g.fillRect(xLeft+40,yTop+10,10,1);
			g.fillRect(xLeft+53,yTop+10,10,1);
			g.fillRect(xLeft+65,yTop+10,10,1);
			g.fillRect(xLeft+78,yTop+10,10,1);
			g.fillRect(xLeft+90,yTop+10,10,1);
			
			

		}
		
}		
	
/* Original code unscaled
/* File: AircraftCarrierH.java	
Instructions to draw a AircraftCarrier horizontally on the screen.

	
import java.awt.*;

public class AircraftCarrierH 
{
	/**
		Constructs a AircraftCarrier horzintally with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*
	
	private int xLeft;
	private int yTop;
	
	public AircraftCarrierH(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void paint(Graphics g)
		{
			Color navyGrey = new Color( 180, 180, 180);			
			
			
			//draw main body of ship
			g.setColor(navyGrey);
			g.fillRect(xLeft, yTop, 200, 40);
			
			//draw detail
			g.setColor(Color.black);	
			
			g.drawRect(xLeft, yTop, 200, 40); //outline
			//g.setColor(navyGrey);
				
				
						
			//Mid deck tower
			g.drawRect(xLeft+80,yTop+30,40,10);
			g.drawRect(xLeft+90,yTop+35,20,5);
			
			//Draw Runway
			
			g.setColor(Color.white);
			g.fillRect(xLeft+5,yTop+20,20,2);
			g.fillRect(xLeft+30,yTop+20,20,2);
			g.fillRect(xLeft+55,yTop+20,20,2);
			g.fillRect(xLeft+80,yTop+20,20,2);
			g.fillRect(xLeft+105,yTop+20,20,2);
			g.fillRect(xLeft+130,yTop+20,20,2);
			g.fillRect(xLeft+155,yTop+20,20,2);
			g.fillRect(xLeft+180,yTop+20,20,2);
			
			

		}
		
}
*/			