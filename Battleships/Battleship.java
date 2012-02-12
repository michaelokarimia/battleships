package Battleships;
/* File: Battleship.java	
Instructions to draw a Battleship on the screen.
*/
	
import java.awt.*;


public class Battleship 
{
	/**
		Constructs a Battleship with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	/*
	private int xLeft;
	private int yTop;
	
	public void Battleship(int x, int y)
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
			g.fillOval(xLeft, yTop, 20, 80);
			
			//draw detail
			g.setColor(Color.black);	
			
			g.drawOval(xLeft, yTop, 20, 80); //outline
			g.setColor(navyGrey);
				
				
						
			//Mid deck tower
			g.setColor(Color.black);
			g.drawRect(xLeft+5,yTop+40,10,15);
			g.drawLine(xLeft+5,yTop+40,xLeft+10,yTop+20);
			g.drawLine(xLeft+10,yTop+20,xLeft+15,yTop+40);
			g.drawRect(xLeft+7,yTop+45,5,5);
			g.drawLine(xLeft+5,yTop+55,xLeft+10,yTop+63);
			g.drawLine(xLeft+10,yTop+63,xLeft+15,yTop+55);
			
			//Draw Top Gun Barrel
			g.drawOval(xLeft+5, yTop +5,10, 10);
			g.drawLine(xLeft+13,yTop,xLeft+13,yTop+10);
			g.drawLine(xLeft+8,yTop,xLeft+8,yTop+10);
			
			//Draw Bottom Gun Barrel
			g.drawOval(xLeft+5, yTop +65, 10, 10);
			g.drawLine(xLeft+7,yTop+70,xLeft+7,yTop+80);
			g.drawLine(xLeft+13,yTop+70,xLeft+13,yTop+80);

		}
		
}			