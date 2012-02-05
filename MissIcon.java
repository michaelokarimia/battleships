/* File: Miss.java	
Instructions to draw a splash, signifing a missed shot on the screen.
*/
	
import java.awt.*;

public class MissIcon
{
	/**
		Constructs a splash shape with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	
/*	private int xLeft;
	private int yTop;
	
	public Miss(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	*/
	public static void paint(Graphics g, int xLeft, int yTop)
		{
			Color foamBlue = new Color( 150, 237, 255);//Creates the colour for the foam
			Color paleBlue = new Color( 50, 137, 205);// Creates and sets the colour of the sea
			
					
			g.setColor(foamBlue);
			g.fillOval(xLeft, yTop, 20, 20);
			
			
			g.setColor(paleBlue);
			g.fillOval(xLeft+4, yTop +4, 13, 13);
			
			
			g.setColor(foamBlue);
			g.fillOval(xLeft+8, yTop +8, 5, 5);
		}
		
}			