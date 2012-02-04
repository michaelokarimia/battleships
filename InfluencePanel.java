/*
 * Author: Michael
 * Created: 16 April 2005 17:25:31
 * Modified: 16 April 2005 17:25:31
 */

import javax.swing.*;
import java.awt.*;

public class InfluencePanel extends JPanel
{
	private InfluenceMap m;
	/*
	public InfluencePanel(InfluenceMap map)
	{
	//	super.paintComponent(g);
		m=map;
		
		IMap.paint(g,100,100,170);
		
	}
	*/
	public void paintHit(Graphics g)
	{
		super.paintComponent(g);
		
		IMap.paint(g,100,100,170);
		
	}
	
	public void paintComponent(Graphics g)
	{
		this.setSize(200,200);
		
		//setBackground(Color.white);
		super.paintComponent(g);
		// ship objects hold their starting co-ord and orientation
		DrawGrid.paint(g,0,0);
		
		
		/*
		IMap.paint(g,0,20,0);
		IMap.paint(g,0,40,1);
		IMap.paint(g,0,60,2);
		IMap.paint(g,0,80,3);
		IMap.paint(g,0,100,4);
		IMap.paint(g,0,120,5);
		IMap.paint(g,0,140,6);
		IMap.paint(g,0,160,7);
		IMap.paint(g,0,180,8);
		IMap.paint(g,0,200,9);
		
		
		
		IMap.paint(g,20,0,13);
		IMap.paint(g,40,0,14);
		IMap.paint(g,60,0,15);
		IMap.paint(g,80,0,16);
		IMap.paint(g,100,0,17);
		IMap.paint(g,120,0,18);
		IMap.paint(g,140,0,19);
		IMap.paint(g,160,0,20);
		IMap.paint(g,180,0,21);
		IMap.paint(g,200,0,22);*/
		//IMap.paint(g,100,0,23);
		//IMap.paint(g,100,10,9);
		
	}

}


