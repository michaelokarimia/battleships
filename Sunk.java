/* File: Hit.java	
Instructions to draws a sunk element, signifying part of a sunk ship on the screen.
*/
	
import java.awt.*;

public class Sunk 
{

	public static void paint(Graphics g, int xLeft, int yTop)
		{
					
			g.setColor(Color.red);
			g.fillRect(xLeft, yTop, 20, 20);
			
		}
		
}	
	
