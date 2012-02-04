/*
 * Author: Michael
 * Created: 16 April 2005 15:44:52
 * Modified: 16 April 2005 15:44:52
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AttackPanel extends JPanel 
{
	
	public void AttackPanel()
	{
	Graphics g = getGraphics();
	
		
		MouseListener listener = new MousePressListener(this);
		addMouseListener(listener);
		
		
	
	}

	public void paintComponent(Graphics g)
	{
		this.setSize(200,200);
		
		setBackground(Color.blue);
		super.paintComponent(g);
		// ship objects hold their starting co-ord and orientation
		Grid.paint(g,0,0);
			
		Miss.paint(g,0,0);
		/*Miss.paint(g,0,20);
		Miss.paint(g,0,40);
		Miss.paint(g,0,60);
		Miss.paint(g,0,80);
		Miss.paint(g,0,100);
		Miss.paint(g,0,120);
		Miss.paint(g,0,140);
		Miss.paint(g,0,160);
		Miss.paint(g,0,180);
		Miss.paint(g,0,200);
		*/
		Hit.paint(g,0,100);
		/*Hit.paint(g,20,100);
		Hit.paint(g,40,100);
		Hit.paint(g,60,100);
		Hit.paint(g,80,100);
		Hit.paint(g,100,100);
		Hit.paint(g,120,100);
		Hit.paint(g,140,100);
		Hit.paint(g,160,100);
		Hit.paint(g,180,100);
		Hit.paint(g,200,100);
		*/
	}

}

class MousePressListener extends MouseAdapter
		{
	
	private AttackPanel a;
	
	public MousePressListener(AttackPanel p)
	{
		a=p;
	}
	
			public void mousePressed(MouseEvent event)
			{
				
				Graphics g = a.getGraphics();
				int x = event.getX();
				int y = event.getY();
			
				Miss.paint(g,x,y);
				
				System.out.println("yes");
				//repaint();
			}
			/*
			public void mouseRelased(MouseEvent event){}
			public void mouseClicked(MouseEvent event) {}
			public void mouseEntered(MouseEvent event){}
			public void mouseExit(MouseEvent event){}
			*/
		}

