package Battleships;
/*
 * Author: Michael
 * Created: 16 April 2005 15:44:52
 * Modified: 16 April 2005 15:44:52
 */

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		this.setSize(200,200);
		
		setBackground(Color.blue);
		super.paintComponent(g);
		// ship objects hold their starting co-ord and orientation
		
		MissIcon.paint(g,0,0);
		MissIcon.paint(g,0,20);
		MissIcon.paint(g,0,40);
		MissIcon.paint(g,0,60);
		MissIcon.paint(g,0,80);
		MissIcon.paint(g,0,100);
		MissIcon.paint(g,0,120);
		MissIcon.paint(g,0,140);
		MissIcon.paint(g,0,160);
		MissIcon.paint(g,0,180);
		MissIcon.paint(g,0,200);
		AircraftCarrier.paint(g,100,0);
		AircraftCarrierH.paint(g,0,100);
		HitIcon.paint(g,0,100);
		HitIcon.paint(g,20,100);
		HitIcon.paint(g,40,100);
		HitIcon.paint(g,60,100);
		HitIcon.paint(g,80,100);
		HitIcon.paint(g,100,100);
		HitIcon.paint(g,120,100);
		HitIcon.paint(g,140,100);
		HitIcon.paint(g,160,100);
		HitIcon.paint(g,180,100);
		HitIcon.paint(g,200,100);
	}

}
