package Battleships.Graphics;
/* File: Hit.java	
Instructions to draw a splash, signifing a missed shot on the screen.
*/
	
import java.awt.*;

public class HitIcon 
{
	/**
		Constructs a splash shape with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	/*
	private int xLeft;
	private int yTop;
	
	public Hit(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	*/
	public static void paint(Graphics g, int xLeft, int yTop)
		{
			Color fire1 = new Color( 250, 185, 050);//Creates the colour for the foam
			Color fire2 = new Color( 250, 137, 0);// Creates and sets the colour of the sea
			
					
			g.setColor(fire1);
			g.fillOval(xLeft, yTop, 20, 20);
			
			
			g.setColor(fire2);
			g.fillOval(xLeft+4, yTop +4, 13, 13);
			
			
			g.setColor(fire1);
			g.fillOval(xLeft+8, yTop +8, 5, 5);
		
		}
		
}	
	

/*original unscaled code

/* File: Hit.java	
Instructions to draw a splash, signifing a missed shot on the screen.
*
	
import java.awt.*;

public class Hit 
{
	/**
		Constructs a splash shape with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*
	
	private int xLeft;
	private int yTop;
	
	public Hit(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void paint(Graphics g)
		{
			Color fire1 = new Color( 250, 185, 050);//Creates the colour for the foam
			Color fire2 = new Color( 250, 137, 0);// Creates and sets the colour of the sea
			
					
			g.setColor(fire1);
			g.fillOval(xLeft, yTop, 40, 40);
			
			
			g.setColor(fire2);
			g.fillOval(xLeft+7, yTop +7, 25, 25);
			
			
			g.setColor(fire1);
			g.fillOval(xLeft+15, yTop +15, 10, 10);
		
		}
		
}			

*/