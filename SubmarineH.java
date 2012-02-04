/* File: SubmarineH.java	
Instructions to draw a horizontal Submarine on the screen.
*/
	
import java.awt.*;

public class SubmarineH 
{
	/**
		Constructs a horizontal submarine with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	/*
	private int xLeft;
	private int yTop;
	
	public SubmarineH(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	*/
	public static void paint(Graphics g, int xLeft, int yTop)
		{
					
			Color navyGrey = new Color( 180, 180, 180);			
			g.setColor(navyGrey);
			//Shape of Submarine
			g.fillOval(xLeft, yTop, 60, 20);
			
			//Detail of the Sub
			g.setColor(Color.black);
			g.drawOval(xLeft, yTop, 60, 20); //Outline of the submarine
			g.drawOval(xLeft+5, yTop +5, 10, 10);
			g.setColor(navyGrey);
			g.fillRect(xLeft+10,yTop+5,6,10);
			
			
			//Torpedo Tubes
			g.setColor(Color.black);
			g.fillOval(xLeft+10, yTop +8, 2, 2);
			g.fillOval(xLeft+10, yTop +12, 2, 2);
			
			//Spine of Ship
			g.drawLine(xLeft+10,yTop+5,xLeft+50,yTop+5);
			g.drawLine(xLeft+10,yTop+15,xLeft+50,yTop+15);
			g.drawLine(xLeft+15,yTop+10,xLeft+45,yTop+10);			
			g.drawLine(xLeft+50,yTop+5,xLeft+55,yTop+10);
			g.drawLine(xLeft+50,yTop+15,xLeft+55,yTop+10);
			
			//Tail Fin
			g.drawLine(xLeft+60,yTop+5,xLeft+60,yTop+15);



		
		}
		
}			





/* Orginal code, unscaled
/* File: SubmarineH.java	
Instructions to draw a horizontal Submarine on the screen.

	
import java.awt.*;

public class SubmarineH 
{
	/**
		Constructs a horizontal submarine with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	
	
	private int xLeft;
	private int yTop;
	
	public SubmarineH(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void paint(Graphics g)
		{
					
			Color navyGrey = new Color( 180, 180, 180);			
			g.setColor(navyGrey);
			//Shape of Submarine
			g.fillOval(xLeft, yTop, 120, 40);
			
			//Detail of the Sub
			g.setColor(Color.black);
			g.drawOval(xLeft, yTop, 120, 40); //Outline of the submarine
			g.drawOval(xLeft+10, yTop +10, 20, 20);
			g.setColor(navyGrey);
			g.fillRect(xLeft+20,yTop+10,11,20);
			
			
			//Torpedo Tubes
			g.setColor(Color.black);
			g.fillOval(xLeft+20, yTop +15, 3, 3);
			g.fillOval(xLeft+20, yTop +23, 3, 3);
			
			//Spine of Ship
			g.drawLine(xLeft+20,yTop+10,xLeft+100,yTop+10);
			g.drawLine(xLeft+20,yTop+30,xLeft+100,yTop+30);
			g.drawLine(xLeft+30,yTop+20,xLeft+90,yTop+20);			
			g.drawLine(xLeft+100,yTop+10,xLeft+110,yTop+20);
			g.drawLine(xLeft+100,yTop+30,xLeft+110,yTop+20);
			
			//Tail Fin
			g.drawLine(xLeft+120,yTop+10,xLeft+120,yTop+30);



		
		}
		
}			
*/