package Battleships.Graphics;
/* File: Spash.java	
Instructions to draw a splash, signifing a missed shot on the screen.
*/
	
import java.awt.*;

public class SplashIcon 
{
	/**
		Constructs a splash shape with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	
	private int xLeft;
	private int yTop;
	
	public SplashIcon(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void paint(Graphics g)
		{
			Color foamBlue = new Color( 150, 237, 255);//Creates the colour for the foam
			Color paleBlue = new Color( 50, 137, 205);// Creates and sets the colour of the sea
			
					
			g.setColor(foamBlue);
			g.fillOval(xLeft, yTop, 40, 40);
			
			
			g.setColor(paleBlue);
			g.fillOval(xLeft+7, yTop +7, 25, 25);
			
			
			g.setColor(foamBlue);
			g.fillOval(xLeft+15, yTop +15, 10, 10);
		
		}
		
}			