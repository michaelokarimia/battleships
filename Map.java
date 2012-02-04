/* File: Miss.java	
Instructions to draw a splash, signifing a missed shot on the screen.
*/
	
import java.awt.*;

public class Map// extends Graphics2D
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
	public static void paint(Graphics g, int xLeft, int yTop, int val)
		{
			
			g.setColor(Color.BLACK);				
			
			/*
			if(val < 0)
			{	g.setColor(Color.blue);
			}
			if(val == 0)
			{g.setColor(Color.white);
			}
			
			if(val == 1)
			{
				Color mapVal = new Color(190, 150, 150);
				g.setColor(mapVal);
			}
			if(val == 2)
			{
				Color mapVal = new Color(200, 150, 150);
				g.setColor(mapVal);
			}
			
			if(val == 3)
			{
				Color mapVal = new Color(210, 150, 150);
				g.setColor(mapVal);
			}
			
			if(val == 4)
			{
				Color mapVal = new Color(220, 150, 150);
				g.setColor(mapVal);
			}
			
			if(val == 9)
			{g.setColor(Color.black);
			}
			*/
			
			g.fillRect(xLeft, yTop, 20, 20);
			
			
		}
		
}			