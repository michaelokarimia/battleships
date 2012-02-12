package Battleships.Graphics;
/* File: AircraftCarrier.java	
Instructions to draw a AircraftCarrier on the screen.
*/
	
import java.awt.*;

public class AircraftCarrier 
{
	/**
		Constructs a AircraftCarrier with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	/*
	private int xLeft;
	private int yTop;
	
	public AircraftCarrier(int x, int y)
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
			g.fillRect(xLeft, yTop, 20, 100);
			
			//draw detail
			g.setColor(Color.black);	
			
			g.drawRect(xLeft, yTop, 20, 100); //outline
			//g.setColor(navyGrey);
				
			//Mid deck tower
			g.drawRect(xLeft+15,yTop+40,5,20);
			g.drawRect(xLeft+17,yTop+45,3,10);
			
			//Draw Runway
			
			g.setColor(Color.white);
			g.fillRect(xLeft+10,yTop+3,1,10);
			g.fillRect(xLeft+10,yTop+15,1,10);
			g.fillRect(xLeft+10,yTop+27,1,10);
			g.fillRect(xLeft+10,yTop+40,1,10);
			g.fillRect(xLeft+10,yTop+53,1,10);
			g.fillRect(xLeft+10,yTop+65,1,10);
			g.fillRect(xLeft+10,yTop+76,1,10);
			g.fillRect(xLeft+10,yTop+90,1,7);
			/*--
			Color fire1 = new Color( 250, 185, 050);//Creates the colour for the foam
			Color fire2 = new Color( 250, 137, 0);// Creates and sets the colour of the sea
			
					
			g.setColor(fire1);
			g.fillOval(xLeft, yTop, 20, 20);
			g.fillOval(xLeft, yTop+20, 20, 20);
			g.fillOval(xLeft, yTop+60, 20, 20);
			g.fillOval(xLeft, yTop+40, 20, 20);
			g.fillOval(xLeft, yTop+80, 20, 20);
			
			g.setColor(fire2);
			g.fillOval(xLeft+4, yTop +4, 13, 13);
			g.fillOval(xLeft+4, yTop +24, 13, 13);
			g.fillOval(xLeft+4, yTop +64, 13, 13);
			g.fillOval(xLeft+4, yTop +44, 13, 13);
			g.fillOval(xLeft+4, yTop +84, 13, 13);
			
			g.setColor(fire1);
			
			g.fillOval(xLeft+8, yTop +8, 5, 5);
			g.fillOval(xLeft+8, yTop +28, 5, 5);
			g.fillOval(xLeft+8, yTop +68, 5, 5);
			g.fillOval(xLeft+8, yTop +48, 5, 5);
			g.fillOval(xLeft+8, yTop +88, 5, 5);
			*///--------------------------------
		}
		
}			


/*Original unscaled code

/* File: AircraftCarrier.java	
Instructions to draw a AircraftCarrier on the screen.
*
	
import java.awt.*;

public class AircraftCarrier 
{
	/**
		Constructs a AircraftCarrier with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*
	
	private int xLeft;
	private int yTop;
	
	public AircraftCarrier(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void paint(Graphics g)
		{
			Color navyGrey = new Color( 180, 180, 180);			
			
			
			//draw main body of ship
			g.setColor(navyGrey);
			g.fillRect(xLeft, yTop, 40, 200);
			
			//draw detail
			g.setColor(Color.black);	
			
			g.drawRect(xLeft, yTop, 40, 200); //outline
			//g.setColor(navyGrey);
				
				
						
			//Mid deck tower
			g.drawRect(xLeft+30,yTop+80,10,40);
			g.drawRect(xLeft+35,yTop+90,5,20);
			
			//Draw Runway
			
			g.setColor(Color.white);
			g.fillRect(xLeft+20,yTop+5,2,20);
			g.fillRect(xLeft+20,yTop+30,2,20);
			g.fillRect(xLeft+20,yTop+55,2,20);
			g.fillRect(xLeft+20,yTop+80,2,20);
			g.fillRect(xLeft+20,yTop+105,2,20);
			g.fillRect(xLeft+20,yTop+130,2,20);
			g.fillRect(xLeft+20,yTop+155,2,20);
			g.fillRect(xLeft+20,yTop+180,2,15);
			
			

		}
		
}
			*/