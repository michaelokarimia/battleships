import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;	
	
class GUI extends JFrame
{
	//private static final int Panel_Width;
	//private static final int Panel_Height;
	
	public GUI()
	{
		super("Battleships");	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(2,1));
		//setPreferredSize(new Dimension(Panel_Width,Panel_Height));
		contentPane.setSize(200,900);
		
		/**Draws the Player's Grid 3 by 3*/
		Container playerGrid = new Container();
		playerGrid.setLayout(new GridLayout());
		playerGrid.setSize(300,200);
		/*Start Creating the grid buttons*/
		JPanel pG11 = new JPanel();
		JPanel pG12 = new JPanel();
		JPanel pG13 = new JPanel();
		
		JPanel pG21 = new JPanel();
		JPanel pG22 = new JPanel();
		JPanel pG23 = new JPanel();
		
		JPanel pG31 = new JPanel();
		JPanel pG32 = new JPanel();
		JPanel pG33 = new JPanel();
		
		//add label to the grid panel
		
		Graphics2D g;
		//pG11.paintComponent(g);
		//Miss m = new Miss()
		/*	
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
		}*/
		
		GridPanel gP = new GridPanel();
	
		//pG11.draw(g);
		/*Place the grid panels in the player grid container*/
		playerGrid.add(gP);
		/*playerGrid.add(pG12);
		p*layerGrid.add(pG13);
		
		playerGrid.add(pG21);
		playerGrid.add(pG22);
		playerGrid.add(pG23);
		
		playerGrid.add(pG31);
		playerGrid.add(pG32);
		playerGrid.add(pG33);
		*/
		//Draw the computer's Grid 3 by 3
		
		Container computerGrid = new Container();
		computerGrid.setLayout(new GridLayout());
		
		/*Start Creating the grid buttons*/
		JPanel cG11 = new JPanel();
			
		/*Place the grid buttons in the computer grid container*/
		GridPanel gC = new GridPanel();
		InfluencePanel iP = new InfluencePanel();
		
		computerGrid.add(gC);
	
		/*
		Creates the southPanel. This panel holds the ship status
		and rotate button
		*/
		Container southPanel = new Container();
		southPanel.setLayout(new GridLayout(1,2));
		southPanel.setSize(400,400);
		/*
		Creates the shipPanel which contains the status of ships
		*/
		
		Container shipPanel = new Container();
		shipPanel.setLayout(new GridLayout(4,2));
		//adds the Ship Panel to the south panel
		southPanel.add(shipPanel);
		
		/*
			Creates the topShipPanel. This is where the
			placeholders for the top row of ships are
		*/
		
		Container topShipPanel = new Container();
		topShipPanel.setLayout(new FlowLayout());
		//add topShipPanel to shipPanel
		shipPanel.add(topShipPanel);
		
		/*
			Creates the topShipLabelPanel. This is where the
			labels for the top row of ships are
		*/
		
		Container topShipLabelPanel = new Container();
		topShipLabelPanel.setLayout(new FlowLayout());
		//add topShipPanel to shipPanel
		shipPanel.add(topShipLabelPanel);	
		
		/*
			Creates the bottomShipPanel. This is where the
			placeholders for the top row of ships are
		*/
		
		Container bottomShipPanel = new Container();
		bottomShipPanel.setLayout(new FlowLayout());
		//add bottomShipPanel to shipPanel
		shipPanel.add(bottomShipPanel);
		
		/*
			Creates the bottomShipLabelPanel. This is where the
			labels for the bottom row of ships are
		*/
		
		Container bottomShipLabelPanel = new Container();
		bottomShipLabelPanel.setLayout(new FlowLayout());
		//add bottomShipPanel to shipPanel
		shipPanel.add(bottomShipLabelPanel);
				
				
		//add mineweeper label to the topShipLabelPanel
		JLabel minesweeperLabel = new JLabel("Minesweeper");
		topShipLabelPanel.add(minesweeperLabel);
		
		//add submarine label to the topShipLabelPanel
		JLabel submarineLabel = new JLabel("Submarine");
		topShipLabelPanel.add(submarineLabel);
		
		//add destroyer label to the topShipLabelPanel
		JLabel destroyerLabel = new JLabel("Destroyer");
		topShipLabelPanel.add(destroyerLabel);
		
		//add Battleship label to the bottomShipLabelPanel
		JLabel battlershipLabel = new JLabel("Battleship");
		bottomShipLabelPanel.add(battlershipLabel);
		
		//add Aircraft Carrier label to the bottomShipLabelPanel
		JLabel aircraftCarrierLabel = new JLabel("Aircraft Carrier");
		bottomShipLabelPanel.add(aircraftCarrierLabel);
		
		JButton MineButton = new JButton("Minesweeper");
		topShipPanel.add(MineButton);
		
		JButton subButton = new JButton("Submarine");
		topShipPanel.add(subButton);
		
		JButton destButton = new JButton("Destroyer");
		topShipPanel.add(destButton);
		
		JButton battButton = new JButton("Battleship");
		bottomShipPanel.add(battButton);
		
		JButton aCButton = new JButton("Aircraft Carrier");
		bottomShipPanel.add(aCButton);
		
		/*
			Creates the container to go in the right hand side of the southPanel.
			This is where the rotate button will be.
		*/
		
		Container rotatePanel = new Container();
		rotatePanel.setLayout(new FlowLayout());
		//add rotatePanel to southPanel
		southPanel.add(rotatePanel);
		
		JButton rotateButton = new JButton("Rotate");
		rotatePanel.add(rotateButton);
		
		//Add the player grid to the content pane
		contentPane.add(playerGrid/*, BorderLayout.CENTER*/);
		
		//Add the computer grid to the content pane
		contentPane.add(computerGrid/*, BorderLayout.CENTER*/);
		
		//add southPanel to the content pane
		contentPane.add(southPanel/*, BorderLayout.SOUTH*/);
		contentPane.add(iP);
		
		this.pack();
		this.setVisible(true);		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		//g2.drawOval(100,70,150,90);
	}
	
	public static void main(String[] args)
	{
		GUI g = new GUI();	
	}
}
