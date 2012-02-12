package Battleships.Graphics;
/*	File: Grid.java	
Instructions to draw a 10 by 10 grid on the screen.
*/
import java.awt.*;

public class DrawGrid
{
	/**
		Constructs a car with a given top left corner.
		@param x the x-coordinate of the top left corner
		@param y the y-coordinate of the top left corner
	*/
	/*
	private int xLeft;
	private int yTop;
	
	public Grid(int x, int y)
	{
		xLeft = x;
		yTop = y;
	}
	*/
	public static void paint(Graphics g, int xLeft, int yTop)
		{
			g.setColor(Color.black);
			g.drawRect(xLeft,yTop,200,200);
			
			g.drawRect(xLeft,yTop,20,200); //the vertical collumn
			
			g.drawRect(xLeft,yTop,40,200);
			g.drawRect(xLeft,yTop,60,200);
			g.drawRect(xLeft,yTop, 80,200);
			g.drawRect(xLeft,yTop,100,200);
			g.drawRect(xLeft,yTop,120,200);
			g.drawRect(xLeft,yTop,140,200);
			g.drawRect(xLeft,yTop,160,200);
			g.drawRect(xLeft,yTop,180,200);
			g.drawRect(xLeft,yTop,200,200);//Finished drawing Vertical collumns 			
								
			//g.setColor(Color.blue);
			g.drawRect(xLeft,yTop,200,20); //the horzontal collumn
			g.drawRect(xLeft,yTop,200,40);
			g.drawRect(xLeft,yTop,200,60);
			g.drawRect(xLeft,yTop,200,80 );
			g.drawRect(xLeft,yTop,200,100);
			g.drawRect(xLeft,yTop,200,120);
			g.drawRect(xLeft,yTop,200,140);
			g.drawRect(xLeft,yTop,200,160);
			g.drawRect(xLeft,yTop,200,180);
			g.drawRect(xLeft,yTop,200,200);// finished drawing Grid
			//g.setColor(Color.black);
		}

	
}
	
