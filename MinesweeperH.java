/* File: MinesweeperH.java	
Instructions to draw a Minesweeper on the screen.
*/
	
import java.awt.*;

public class MinesweeperH 
{
	/**
		Constructs a horizontal Minesweeper with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	/*
	private int xLeft;
	private int yTop;
	
	public MinesweeperH(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	*/
	public static void paint(Graphics g, int xLeft, int yTop)
		{
			
			//Color of the ship
			Color navyGrey = new Color( 180, 180, 180);			
			g.setColor(navyGrey);
			//Draw Main Body of ship
			g.fillOval(xLeft, yTop, 40, 20);
			//Draw detail on ship
			g.setColor(Color.black);	
			g.drawOval(xLeft, yTop, 40, 20);
			g.setColor(navyGrey);
			g.fillRect(xLeft+20,yTop,20,20);
			
			/*Gun turret*/
			g.setColor(Color.black);
			g.drawOval(xLeft+5, yTop +5, 10, 10);
			g.drawRect(xLeft+20,yTop+5,15,10);
			g.drawRect(xLeft+25,yTop+8,5,5);
			g.drawLine(xLeft,yTop+10,xLeft+10,yTop+10);
			
			/*Outline of the stern of the ship*/
			g.drawLine(xLeft+40,yTop,xLeft+20,yTop);
			
			g.drawLine(xLeft+40,yTop,xLeft+40,yTop+20);
			
			g.drawLine(xLeft+40,yTop+20,xLeft+20,yTop+20);


		
		}
		
}			



/*orginal unscaled code
/* File: MinesweeperH.java	
Instructions to draw a Minesweeper on the screen.

	
import java.awt.*;

public class MinesweeperH 
{
	/**
		Constructs a horizontal Minesweeper with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	
	
	private int xLeft;
	private int yTop;
	
	public MinesweeperH(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	
	public void paint(Graphics g)
		{
			
			//Color of the ship
			Color navyGrey = new Color( 180, 180, 180);			
			g.setColor(navyGrey);
			//Draw Main Body of ship
			g.fillOval(xLeft, yTop, 80, 40);
			//Draw detail on ship
			g.setColor(Color.black);	
			g.drawOval(xLeft, yTop, 80, 40);
			g.setColor(navyGrey);
			g.fillRect(xLeft+40,yTop,40,40);
			
			//Gun turret
			g.setColor(Color.black);
			g.drawOval(xLeft+10, yTop +10, 20, 20);
			g.drawRect(xLeft+40,yTop+10,30,20);
			g.drawRect(xLeft+50,yTop+15,10,10);
			g.drawLine(xLeft,yTop+20,xLeft+20,yTop+20);
			
			//Outline of the stern of the ship
			g.drawLine(xLeft+40,yTop,xLeft+80,yTop);
			
			g.drawLine(xLeft+80,yTop,xLeft+80,yTop+40);
			
			g.drawLine(xLeft+80,yTop+40,xLeft+40,yTop+40);


		
		}
		
}			

*/