/* File: BattleshipH.java	
Instructions to draw a Horzonatal Battleship on the screen.
*/
	
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BattleshipH 
{
	/**
		Constructs a horizontal Battleship with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	/*
	private int xLeft;
	private int yTop;
	private float s;
	
	public BattleshipH(int x, int y/*, float s)
	{
		xLeft = x;
		yTop = y;
		/*s=s;
	}
	*/
	public static void paint(Graphics g, int xLeft, int yTop)
		{
			Color navyGrey = new Color( 180, 180, 180);			
			
			//s= 1;
			
			//draw main body of ship
			g.setColor(navyGrey);
			g.fillOval(xLeft, yTop, 80, 20);
			
			
			
			//draw detail
			g.setColor(Color.black);	
			
			
			
			
			g.drawOval(xLeft, yTop, 80, 20); //outline
			g.setColor(navyGrey);
				
				
						
			//Mid deck tower
			g.setColor(Color.black);
			g.drawRect(xLeft+40,yTop+5,15,10);
			g.drawLine(xLeft+40,yTop+5,xLeft+20,yTop+10);
			g.drawLine(xLeft+20,yTop+10,xLeft+40,yTop+15);
			g.drawRect(xLeft+45,yTop+7,5,5);
			g.drawLine(xLeft+55,yTop+5,xLeft+63,yTop+10);
			g.drawLine(xLeft+63,yTop+10,xLeft+55,yTop+15);
			
			//Draw Top Gun Barrel
			g.drawOval(xLeft+5, yTop +5, 10, 10);
			g.drawLine(xLeft,yTop+13,xLeft+10,yTop+13);
			g.drawLine(xLeft,yTop+8,xLeft+10,yTop+8);
			
			//Draw Bottom Gun Barrel
			g.drawOval(xLeft+65, yTop +5, 10, 10);
			g.drawLine(xLeft+70,yTop+8,xLeft+80,yTop+8);
			g.drawLine(xLeft+70,yTop+13,xLeft+80,yTop+13);

		}

	
	/*Original Code
	
	public BattleshipH(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void paint(Graphics g)
		{
			Color navyGrey = new Color( 180, 180, 180);			
			
			s= 1;
			
			//draw main body of ship
			g.setColor(navyGrey);
			g.fillOval(xLeft, yTop, 160, 40);
			
			//draw detail
			g.setColor(Color.black);	
			
			g.drawOval(xLeft, yTop, 160, 40); //outline
			g.setColor(navyGrey);
				
				
						
			//Mid deck tower
			g.setColor(Color.black);
			g.drawRect(xLeft+80,yTop+10,30,20);
			g.drawLine(xLeft+80,yTop+10,xLeft+40,yTop+20);
			g.drawLine(xLeft+40,yTop+20,xLeft+80,yTop+30);
			g.drawRect(xLeft+90,yTop+15,10,10);
			g.drawLine(xLeft+110,yTop+10,xLeft+125,yTop+20);
			g.drawLine(xLeft+125,yTop+20,xLeft+110,yTop+30);
			
			//Draw Top Gun Barrel
			g.drawOval(xLeft+10, yTop +10, 20, 20);
			g.drawLine(xLeft,yTop+25,xLeft+20,yTop+25);
			g.drawLine(xLeft,yTop+15,xLeft+20,yTop+15);
			
			//Draw Bottom Gun Barrel
			g.drawOval(xLeft+130, yTop +10, 20, 20);
			g.drawLine(xLeft+140,yTop+15,xLeft+160,yTop+15);
			g.drawLine(xLeft+140,yTop+25,xLeft+160,yTop+25);

		}
		*/

}			