package Battleships.Graphics;
/*
 * Author: Michael
 * Created: 16 April 2005 15:44:52
 * Modified: 16 April 2005 15:44:52
 */

import javax.swing.*;


import java.awt.*;

public class HomePanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		this.setSize(200,200);
		
		setBackground(Color.blue);
		super.paintComponent(g);
		// ship objects hold their starting co-ord and orientation
		
		DrawGrid.paint(g,0,0);
		/*
		Battleship.paint(g,0,0);
		SubmarineH.paint(g,120,40);
		DestroyerH.paint(g,0,140);
		Minesweeper.paint(g,140,100);
		AircraftCarrier.paint(g,100,0);
		
		Hit.paint(g,100,60);
		
		Miss.paint(g,0,160);
		Miss.paint(g,0,180);
		Miss.paint(g,0,200);
		Miss.paint(g,0,80);	
		Miss.paint(g,0,100);
		Miss.paint(g,20,100);
		Miss.paint(g,40,100);
		Miss.paint(g,60,100);
		Miss.paint(g,80,100);
		Miss.paint(g,100,100);
		Miss.paint(g,160,100);
		Miss.paint(g,180,100);
		Miss.paint(g,200,100);
		
		Hit.paint(g,100,20);
		*/
		
	}

}
