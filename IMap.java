/* File: Miss.java	
Instructions to draw a splash, signifing a missed shot on the screen.
*/
	
import java.awt.*;

public class IMap// extends Graphics2D
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
			Color mapVal = new Color( 20 , 250, 250);//Creates the colour for the map
			
			if(val==9)
			{
				g.setColor(Color.black);//set to black
			}
			
			if(val < 0)
			{	g.setColor(Color.blue);
			}
			if(val == 0)
			{g.setColor(Color.white);
			}
			
			if(val == 1)
			{
				mapVal = new Color(255, 200,200);
				g.setColor(mapVal);
			}
			
			if(val == 2)
			{
				mapVal = new Color(255, 180,180);
				g.setColor(mapVal);
			}			

			if(val == 3)
			{
				mapVal = new Color(255, 160,160);
				g.setColor(mapVal);
			}		

			if(val == 4)
			{
				mapVal = new Color(255, 140,140);
				g.setColor(mapVal);
			}	
			
			if(val == 5)
			{
				mapVal = new Color(255, 120,120);
				g.setColor(mapVal);
			}
			
			if(val == 6)
			{
				mapVal = new Color(255, 100,100);
				g.setColor(mapVal);
			}
			
			if(val == 7)
			{
				mapVal = new Color(255, 80,80);
				g.setColor(mapVal);
			}
			
			if(val == 8)
			{
				mapVal = new Color(255, 60, 60);
				g.setColor(mapVal);
			}
			
			if(val == 10)
			{
				mapVal = new Color(255, 40, 40);
				g.setColor(mapVal);
			}
			
			if(val == 11)
			{
				mapVal = new Color(255, 20, 20);
				g.setColor(mapVal);
			}
			
			if(val == 12)
			{
				mapVal = new Color(255, 0, 0);
				g.setColor(mapVal);
			}
			
			if(val == 13)
			{
				mapVal = new Color(255, 100, 0);
				g.setColor(mapVal);
			}
			
			if(val == 14)
			{
				mapVal = new Color(255, 120, 0);
				g.setColor(mapVal);
			}
			
			if(val == 15)
			{
				mapVal = new Color(255, 140, 0);
				g.setColor(mapVal);
			}
			
			if(val == 16)
			{
				mapVal = new Color(255, 160, 0);
				g.setColor(mapVal);
			}
			
			if(val == 17)
			{
				mapVal = new Color(255, 180, 0);
				g.setColor(mapVal);
			}
			
			if(val == 18)
			{
				mapVal = new Color(255, 200, 0);
				g.setColor(mapVal);
			}
			
			if(val == 19)
			{
				mapVal = new Color(255, 220, 0);
				g.setColor(mapVal);
			}
			
			if(val == 20)
			{
				mapVal = new Color(255, 240, 0);
				g.setColor(mapVal);
			}
			
			if(val > 20)
			{
				mapVal = new Color(255, 250, 0);
				g.setColor(mapVal);
			}
			
			//g.setColor(mapVal);
			g.fillRect(xLeft, yTop, 20, 20);
			
			
			
		}
		
}			