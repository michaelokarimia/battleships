import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;	
	
class GUI extends JFrame
{
	
			
		private Grid compHome;
		private Grid compAtt;
		private Grid playerHome;
		private Grid playerAtt;
		private InfluenceMap m;
		
		private AttackPanel cG;
		private HomePanel pG;
		private InfluencePanel iM;
		
		private JTextField outText;
		private int i;
		private int j;
		
		private boolean gameOverMan;
		private boolean playerWins;
		private boolean agentWins;
		
		private boolean playerTurn;
		private boolean agentTurn;
		
		private boolean deployed;
		
		private boolean playerDeployment;
		private boolean agentDeployment;
		
		private boolean horiz;
		private boolean showMap;
		
		private boolean minePlaced;
		private boolean destPlaced;
		private boolean subPlaced;
		private boolean battlePlaced;
		private boolean airPlaced;

		private boolean agentMineSunk;
		private boolean agentDestSunk;
		private boolean agentSubSunk;
		private boolean agentBattleSunk;
		private boolean agentAirSunk;
		
		private boolean playerMineSunk;
		private boolean playerDestSunk;
		private boolean playerSubSunk;
		private boolean playerBattleSunk;
		private boolean playerAirSunk;
		
		private boolean paintMineSunk;
		private boolean paintDestSunk;
		private boolean paintSubSunk;
		private boolean paintBattleSunk;
		private boolean paintAirSunk;
		
		
		private boolean allAgentShipsSunk;
		private boolean allPlayerShipsSunk;
		
	public GUI()
	{
		super("Battleships");	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout(2,1));
		this.setResizable(false);
		
		playerTurn = false;
		deployed = false;
		
		playerDeployment = false;
		agentDeployment = false;
		
		minePlaced = false;
		destPlaced = false;
		subPlaced = false;
		battlePlaced = false;
		airPlaced = false;
		
		horiz= true;
		showMap= true;
		
		
		paintMineSunk= false;
		paintDestSunk= false;
		paintSubSunk= false;
		paintBattleSunk= false;
		paintAirSunk= false;
		
		allAgentShipsSunk = false;
		allPlayerShipsSunk = false;
		
		gameOverMan = false;
		playerWins = false;
		
		
		//attack panel
		Container APanel = new Container();
		APanel.setLayout(new GridLayout());
		
		//home panel
		Container HPanel = new Container();
		HPanel.setLayout(new GridLayout());
	
		//influence map
		Container IMPanel = new Container();
		IMPanel.setLayout(new GridLayout());
		
		//center panel where grids are
		Container CenterPanel = new Container();
		CenterPanel.setLayout(new GridLayout(1,3));
		//create grids and maps
		
		//attack panel add listener
		cG = new AttackPanel();
		cG.addMouseListener(new AttackMousePressListener(cG,this));
		
		
		pG = new HomePanel();
		pG.addMouseListener(new HomeMousePressListener(pG, this));
		
		iM = new InfluencePanel();
		
		APanel.add(cG);
		CenterPanel.add(APanel);
		
		HPanel.add(pG);
		CenterPanel.add(HPanel);
		
		IMPanel.add(iM);
		CenterPanel.add(IMPanel);
		
	
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
	//	JLabel minesweeperLabel = new JLabel("Minesweeper");
		//topShipLabelPanel.add(minesweeperLabel);
		
		//add submarine label to the topShipLabelPanel
	//	JLabel submarineLabel = new JLabel("Submarine");
		//topShipLabelPanel.add(submarineLabel);
		
		//add destroyer label to the topShipLabelPanel
		//JLabel destroyerLabel = new JLabel("Destroyer");
		//topShipLabelPanel.add(destroyerLabel);
		
		//add Battleship label to the bottomShipLabelPanel
	//	JLabel battlershipLabel = new JLabel("Battleship");
	//	bottomShipLabelPanel.add(battlershipLabel);
		
		//add Aircraft Carrier label to the bottomShipLabelPanel
	//	JLabel aircraftCarrierLabel = new JLabel("Aircraft Carrier");
	//	bottomShipLabelPanel.add(aircraftCarrierLabel);
		
		JButton NewButton = new JButton("New Game");
		topShipPanel.add(NewButton);
	//	NewButton.addMouseListener(new NewButtonAction(this));
		
		JButton hideButton = new JButton("Hide Influence Map");
		topShipPanel.add(hideButton);
		hideButton.addMouseListener(new HideButtonAction(this));
		
		JButton destButton = new JButton("Rotate");
		topShipPanel.add(destButton);
		
		JButton rotateButton = new JButton("Rotate Ship");
		rotateButton.addMouseListener(new RotateButtonAction(this));
		bottomShipPanel.add(rotateButton);
		
		JButton quitButton = new JButton("Quit");
		quitButton.addMouseListener(new QuitButtonAction());
		bottomShipPanel.add(quitButton);
		
		/*
			Creates the container to go in the right hand side of the southPanel.
			This is where the rotate button will be.
		*/
		
		Container rotatePanel = new Container();
		rotatePanel.setLayout(new BorderLayout());
		//add rotatePanel to southPanel
		southPanel.add(rotatePanel);
		
		
		
		JButton viewMap = new JButton("View Influence Map");
		viewMap.addMouseListener(new ShowButtonAction(this));
		rotatePanel.add(viewMap, BorderLayout.NORTH);
		
		
		outText = new JTextField("lookat me!");
		outText.setText("Welcome To Battleships. Place ships on the middle grid");
		outText.setEditable(false);
		rotatePanel.add(outText);
		
		contentPane.add(CenterPanel,BorderLayout.CENTER);
		contentPane.add(southPanel,BorderLayout.SOUTH);
		
		this.pack();
		this.setSize(640,400);
		this.setVisible(true);
			
	}
	
	public void setOut(String s)
	{
		outText.setText(s);
	}
	public void repaint()
	{
		Graphics g = cG.getGraphics();	
		
		for (int i = 0; i < 10; i++) //change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)//change this to CoLumns for default
			{
				if (playerAtt.getGridVal(i,j) == 1)
					Miss.paint(g,(j*20),(i*20));
				else
				if (compHome.getGridVal(i,j) < -1)
					Hit.paint(g,(j*20),(i*20));
				
				
			}
		}
		
		/*
		Graphics g = iM.getGraphics();	
		
		for (int i = 0; i < 10; i++) //change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)//change this to CoLumns for default
			{
				int col = 0;
				IMap.paint(g,(j*20),(i*20), col);
			}
		}*/
	}
	
	public boolean getPaintMineSunk()
	{
		return paintMineSunk;
	}
	
	public void setPaintMineSunk()
	{
	 	paintMineSunk= true;
	}
	
	public boolean getPaintDestSunk()
	{
		return paintDestSunk;
	}
	
	public void setPaintDestSunk()
	{
	 	paintDestSunk= true;
	}
	
	public boolean getPaintSubSunk()
	{
		return paintSubSunk;
	}
	
	public void setPaintSubSunk()
	{
	 	paintSubSunk= true;
	}
	public boolean getPaintBattleSunk()
	{
		return paintBattleSunk;
	}
	
	public void setPaintBattleSunk()
	{
	 	paintBattleSunk= true;
	}	
		
	public boolean getPaintAirSunk()
	{
		return paintAirSunk;
	}
	
	public void setPaintAirSunk()
	{
	 	paintAirSunk= true;
	}
			
	public void reset()
	{
		
		 i = 0;
		 j = 0;
		
		 gameOverMan= false;
		 playerWins= false;
		 agentWins= false;
		
		 playerTurn= false;
		 agentTurn= false;
		
		 deployed= false;
		
		 playerDeployment= false;
		 agentDeployment= false;
		
		 horiz= false;
		 showMap= false;
		
		 minePlaced= false;
		 destPlaced= false;
		 subPlaced= false;
		 battlePlaced= false;
		 airPlaced= false;

		 agentMineSunk= false;
		 agentDestSunk= false;
		 agentSubSunk= false;
		 agentBattleSunk= false;
		 agentAirSunk= false;
		
		 playerMineSunk= false;
		 playerDestSunk= false;
		 playerSubSunk= false;
		 playerBattleSunk= false;
		 playerAirSunk= false;
				
		 allAgentShipsSunk= false;
		 allPlayerShipsSunk= false;
		
		//this = new GUI();
		
		playerTurn = false;
		deployed = false;
		
		playerDeployment = false;
		agentDeployment = false;
		
		minePlaced = false;
		destPlaced = false;
		subPlaced = false;
		battlePlaced = false;
		airPlaced = false;
		
		horiz= true;
		showMap= true;
		
		allAgentShipsSunk = false;
		allPlayerShipsSunk = false;
		
		gameOverMan = false;
		playerWins = false;
		
		Grid compHome = new Grid(10,10);
		Grid compAtt = new Grid(10,10);
		Grid playerHome = new Grid(10,10);
		Grid playerAtt = new Grid(10,10);
		InfluenceMap m = new InfluenceMap();
		
		this.setGrids(compHome,compAtt,playerHome,playerAtt,m);
		
		this.pack();
		this.setSize(640,400);
		this.setVisible(true);	

	}
	
	public void paintComponent(Graphics g)
	{
		//super.paint(g);
		//Graphics2D g2 = (Graphics2D)g;
		
	}
		
	public void setGrids(Grid cHome, Grid cAtt, Grid pHome, Grid pAtt, InfluenceMap map)
	{
		compHome = cHome;
		compAtt = cAtt;
		playerHome = pHome;
		playerAtt = pAtt;
		m = map;
	}
		
	
	public String placeAir(int i, int j)
	{
		String out ="";
		if(!airPlaced)
		{
			if(horiz)
			{
				boolean valid;
				valid = playerHome.addAir(i,j,0);
		
				Graphics hp = pG.getGraphics();
		
				if(valid)
				{	
					AircraftCarrierH.paint(hp,(j*20),(i*20));
					out = out + playerHome.toString();
					airPlaced = true;
					outText.setText("Air Placed");
				}
				else
				{
					outText.setText("Aircraft Carrier Will Not Fit Here");
					out ="not valid";
					out = out + playerHome.toString();
				}	
			}
		
		else 
		{
			boolean valid;
			valid = playerHome.addAir(i,j,1);
			if(valid)
			{
				Graphics hp = pG.getGraphics();	
				AircraftCarrier.paint(hp,(j*20),(i*20));
				out = out + playerHome.toString();
				airPlaced = true;
				outText.setText("Air Placed");
			}
			else
			{
				out ="not valid";
				out = out + playerHome.toString();
			}	
		
		}
		}
		return out;
	}
	
	
	public String placeBattle(int i, int j)
	{
		String out ="";
		if(airPlaced && !battlePlaced)
		{
			if(horiz)
			{
				boolean valid;
				valid = playerHome.addBattle(i,j,0);
		
				Graphics hp = pG.getGraphics();
		
				if(valid)
				{	
					BattleshipH.paint(hp,(j*20),(i*20));
					out = out + playerHome.toString();
					battlePlaced = true;
				//	outText.setText("Battleship Placed");
				}
				else
				{
					out ="not valid";
					out = out + playerHome.toString();
					outText.setText("Battleships Will Not Fit Here");
				}	
			}
		
		else 
		{
			boolean valid;
			valid = playerHome.addBattle(i,j,1);
			if(valid)
			{
				Graphics hp = pG.getGraphics();	
				Battleship.paint(hp,(j*20),(i*20));
				out = out + playerHome.toString();
				battlePlaced = true;
				outText.setText("Battleship Placed");
			}
			else
			{
				out ="not valid";
				out = out + playerHome.toString();
				outText.setText("Battleships Will Not Fit Here");
			}	
		
		}
		}
		return out;
	}	
	

	public String placeDest(int i, int j)
	{
		String out ="";
		if(airPlaced && battlePlaced && !destPlaced)
		{
			if(horiz)
			{
				boolean valid;
				valid = playerHome.addDest(i,j,0);
		
				Graphics hp = pG.getGraphics();
		
				if(valid)
				{	
					DestroyerH.paint(hp,(j*20),(i*20));
					out = out + playerHome.toString();
					destPlaced = true;
					outText.setText("Destroyer Placed");
				}
				else
				{
					out ="not valid";
					out = out + playerHome.toString();
					outText.setText("Destroyer Will Not Fit Here");
				}	
			}
		
		else 
		{
			boolean valid;
			valid = playerHome.addDest(i,j,1);
			if(valid)
			{
				Graphics hp = pG.getGraphics();	
				Destroyer.paint(hp,(j*20),(i*20));
				out = out + playerHome.toString();
				destPlaced = true;
				outText.setText("Destroyer Placed");
			}
			else
			{
				out ="not valid";
				out = out + playerHome.toString();
				
			}	
		
		}
		}
		return out;
	}
	
	
	public String placeSub(int i, int j)
	{
		String out ="";
		if(airPlaced && battlePlaced && destPlaced && !subPlaced)
		{
			if(horiz)
			{
				boolean valid;
				valid = playerHome.addSub(i,j,0);
		
				Graphics hp = pG.getGraphics();
		
				if(valid)
				{	
					SubmarineH.paint(hp,(j*20),(i*20));
					out = out + playerHome.toString();
					subPlaced = true;
					outText.setText("Submarine Placed");
				}
				else
				{
					out ="not valid";
					out = out + playerHome.toString();
					outText.setText("Submarine Will Not Fit Here");
				}	
			}
		
		else 
		{
			boolean valid;
			valid = playerHome.addSub(i,j,1);
			if(valid)
			{
				Graphics hp = pG.getGraphics();	
				Submarine.paint(hp,(j*20),(i*20));
				out = out + playerHome.toString();
				subPlaced = true;
				outText.setText("Submarine Placed");
			}
			else
			{
				out ="not valid";
				out = out + playerHome.toString();
				outText.setText("Submarine Will Not Fit Here");
			}	
		
		}
		}
		return out;
	}	
	
	
	
	public String placeMine(int i, int j)
	{
		String out ="";
		if(airPlaced && battlePlaced && destPlaced && subPlaced && !minePlaced)
		{
			if(horiz)
			{
				boolean valid;
				valid = playerHome.addMine(i,j,0);
		
				Graphics hp = pG.getGraphics();
		
				if(valid)
				{	
					MinesweeperH.paint(hp,(j*20),(i*20));
					out = out + playerHome.toString();
					minePlaced = true;
					outText.setText("Minesweeper Placed");
				}
				else
				{
					out ="not valid";
					out = out + playerHome.toString();
					outText.setText("Minesweeper Will Not Fit Here");
				}	
			}
		
		else 
		{
			boolean valid;
			valid = playerHome.addMine(i,j,1);
			if(valid)
			{
				Graphics hp = pG.getGraphics();	
				Minesweeper.paint(hp,(j*20),(i*20));
				out = out + playerHome.toString();
				minePlaced = true;
				outText.setText("Minesweeper Placed");
			}
			else
			{
				out ="not valid";
				out = out + playerHome.toString();
				outText.setText("Minesweeper Will Not Fit Here");
			}	
		
		}
		
		if(airPlaced && battlePlaced && destPlaced && subPlaced && minePlaced)
				this.endDeployment();
			
		}
		
		
		return out;
	}	
	
	public boolean rotate()
	{
		horiz= !horiz;
		if(horiz&&!deployed)
		outText.setText("Ship Will Be Placed Horizontally");
		if(!horiz&&!deployed)
		outText.setText("Ship Will Be Placed Vertically");
		return horiz;
	}
	
	public void showMap()
	{
		showMap= true;
		this.paintMap();
		outText.setText("Influence Map shown");
	}
	
	public void hideMap()
	{
		showMap= false;
		
		Graphics g = iM.getGraphics();	
		
		for (int i = 0; i < 10; i++) //change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)//change this to CoLumns for default
			{
				int col = 0;
				IMap.paint(g,(j*20),(i*20), col);
			}
		}
		
		outText.setText("Influence Map Hidden");
	}	
	
    public String deploy(int i, int j)
	{
		String out1= "";
		deployed=false;
		out1=this.placeAir(i,j);
		out1= out1 + "\n" +this.placeBattle(i,j);
		out1= out1 + "\n" +this.placeDest(i,j);
		out1= out1 + "\n" +this.placeSub(i,j);
		out1= out1 + "\n" +this.placeMine(i,j);
	//	if(playerHome.allShipsPlaced())
	//	{
			//this.deployed();
	//	}
			//this.playerTurn();	
	out1=out1 + playerTurn;	/*playerHome.allShipsPlaced()*/;
	
	
		return out1;
	}

	public void AllAgentShipsSunk()
	{
		allAgentShipsSunk=true;
	}
	
	
	public void AllPlayerShipsSunk()
	{
		allPlayerShipsSunk=true;
	}
	
	public boolean getAgentShipsSunk()
	{
		return allAgentShipsSunk;
	}
	
	public boolean getPlayerShipsSunk()
	{
		return allPlayerShipsSunk;
	}
	
	public boolean getPlayerWins()
	{
		return playerWins;
	}
	
	public boolean getAgentWins()
	{
		return playerWins;
	}
	
	public void setAgentWins()
	{
		agentWins= true;
		playerWins= false;
	}
	
	public void setPlayerWins()
	{
		agentWins= false;
		playerWins= true;
	}
	
	public boolean getGameOver()
	{
		return gameOverMan;
	}

	public boolean deployed()
	{
		return deployed;
	}
	
	public void setGameOver()
	{
		gameOverMan = true;
	}
	
	public void playerTurn()
	{
		agentTurn=false;
		if(deployed == true)
		{
			playerTurn= true;
		}
		else
		playerTurn=false;
		outText.setText("Player Turn, Fire A Shot!");
	}
	
	public void agentTurn()
	{
		playerTurn= false;
		agentTurn=true;
		outText.setText("Agent Turn, please wait");
	
	}
	
	public boolean getPlayerTurn()
	{
			return playerTurn;
	}
	
	/*
	public void startDeployment()
	{
		deployment= true;
	}*/
	
	public void endDeployment()
	{
		if(minePlaced && destPlaced && subPlaced &&	battlePlaced &&	airPlaced)
		deployed= true;
		outText.setText("All Ships Deployed, Player's Turn! Click on the left grid to fire shots");
		this.playerTurn();
	} 
	
	public String shot(int i, int j)
	{
		int sqr = playerAtt.getGridVal(i,j);
		String out ="";
		if(playerTurn && deployed)
		{
			if (sqr ==0)
			{
				boolean hit = false;
				hit = compHome.shot(i,j);
		
				Graphics ap = cG.getGraphics();
		
				if(hit)
				{
					Hit.paint(ap,(j*20),(i*20));
					playerAtt.update(i,j,9);
					outText.setText("HIT! Have Another Turn!");
				}
				else
				if(!hit)
				{
					Miss.paint(ap,(j*20),(i*20));
					compHome.update(i,j,1);
					playerAtt.set(i,j,1);
					this.agentTurn();
					out="Miss!"+ playerTurn;
					outText.setText("Miss. Agent's Turn");
					
				//	System.out.println("Player turn over");
				}
			}
		//this.paintSunk();
		}
		//if(compHome.
		
		
		out = out + "CompHome " + compHome.toString();
		out = out + "player Attack = \n" + playerAtt.toString();
		
	//	System.out.println("subk status is " agentMineSunk|| agentDestSunk || agentSubSunk || agentBattleSunk || agentAirSunk);
		return out;	
	}
	
	public void paintMap()
	{
		
		Graphics g = iM.getGraphics();	
		
		for (int i = 0; i < 10; i++) //change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)//change this to CoLumns for default
			{
				int col = m.getVal(i,j);
				
				if(showMap)
				{
					IMap.paint(g,(j*20),(i*20), col);
				}
			}
		}
		
		
	}
		
	
	public void paintSunk()
	{
		this.checkSunk();
		for (int i = 0; i < 10; i++) //change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)//change this to CoLumns for default
			{
				if(compHome.getGridVal(i,j) ==-3 && agentAirSunk)
				{					
					Graphics ap = cG.getGraphics();	
					Sunk.paint(ap,(j*20),(i*20));
				}
				
				if(compHome.getGridVal(i,j) ==-4 && agentBattleSunk)
				{					
					Graphics ap = cG.getGraphics();	
					Sunk.paint(ap,(j*20),(i*20));
				}
				
				//(agentMineSunk || agentDestSunk || agentSubSunk || agentBattleSunk
			}
		}
	}
	
	public void checkSunk()
	{
		if(playerHome.checkAirSunk())
		{
			playerAirSunk = true;
				
		}
		if(playerHome.checkBattleSunk())
		{
			playerBattleSunk = true;
		}
		if(playerHome.checkDestSunk())
		{
			playerDestSunk = true;
		}
		if(playerHome.checkSubSunk())
		{
			playerSubSunk = true;
		}
		if(playerHome.checkMineSunk())
		{
			playerMineSunk = true;
		}
	
		if(compHome.checkAirSunk())
		{
			agentAirSunk = true;
	//		outText.setText("You Have sunk the Agent's Aircraft Carrier");
		}
		if(compHome.checkBattleSunk())
		{
			agentBattleSunk = true;
		//	outText.setText("You Have sunk the Agent's Battleship");
		}
		if(compHome.checkDestSunk())
		{
			agentDestSunk = true;
		//	outText.setText("You Have sunk the Agent's Destroyer");
		}
		if(compHome.checkSubSunk())
		{
			agentSubSunk = true;
			//outText.setText("You Have sunk the Agent's Submarine");
		}
		if(compHome.checkMineSunk())
		{
			agentMineSunk = true;
			
		}
		
		if(agentAirSunk&&agentBattleSunk&&agentDestSunk&&agentSubSunk&&agentMineSunk)
		this.AllAgentShipsSunk();
		
		if(playerAirSunk&&playerBattleSunk&&playerDestSunk&&playerSubSunk&&playerMineSunk)
		this.AllPlayerShipsSunk();

	}

public void outputHitList()
{
	
		if(compHome.checkAirSunk())
		{
			outText.setText("You Have sunk the Agent's Aircraft Carrier");
		}
		if(compHome.checkBattleSunk())
		{
			outText.setText(outText.getText() +("You Have sunk the Agent's Battleship"));
		}
		if(compHome.checkDestSunk())
		{
			outText.setText(outText.getText() +("You Have sunk the Agent's Destroyer"));
		}
		if(compHome.checkSubSunk())
		{
			outText.setText(outText.getText() +("You Have sunk the Agent's Submarine"));
		}
		if(compHome.checkMineSunk())
		{
			outText.setText(outText.getText() + ("You Have sunk the Agent's Minesweeper"));
		}
	
}
	
	
	
	public void agentShot(int X, int Y)
		
	{
		if(agentTurn && deployed)
		{
		int sqrVal = playerHome.getGridVal(X,Y);
						
						if(sqrVal < 0 || sqrVal==1)
						{
							System.out.println("Shot already taken! Have another go"); 
						}
							
						if(sqrVal == 0)
						{
							System.out.println(playerHome.shot(X,Y));
							compAtt.update(X,Y,1);
							m.miss(X,Y);
							this.paintMap();
							Graphics hp = pG.getGraphics();	
							Miss.paint(hp,(Y*20),(X*20));
							outText.setText("Agent Has Missed. Player's Turn");
							this.playerTurn();
						}
						
						if(sqrVal > 1)
						{
							System.out.println(playerHome.shot(X,Y));
							compAtt.update(X,Y,8);
							m.hit(X,Y);
							Graphics hp = pG.getGraphics();	
							Hit.paint(hp,(Y*20),(X*20));
							outText.setText("Agent Has Hit One Of your ships! Agent's Turn again");
							this.paintMap();
							
						}
						
						System.out.println("compAtt");						
						System.out.println(compAtt.toString());
						
						if(sqrVal==0)
							this.playerTurn();
				
		}		
		
		System.out.println("Map is \n" + m.toString());
		
		
	}
		

	
	public static void main (String args[])
	{
		
		Grid compHome = new Grid(10,10);
		Grid compAtt = new Grid(10,10);
		Grid playerHome = new Grid(10,10);
		Grid playerAtt = new Grid(10,10);
		InfluenceMap m = new InfluenceMap();
		
		GUI g = new GUI();
		//g.startDeployment();
		/*\
		compHome.addAir(0,0,1);
		
		compHome.addBattle(3,5,0);
		compHome.addDest(6,6,1);
		compHome.addSub(2,7,0);
		compHome.addMine(8,7,0);
		*/
		
		//g.playerTurn();
			
	g.setGrids(compHome,compAtt,playerHome,playerAtt,m);
	
		Agent smith = new Agent();
	//	g.agentTurn();
	//	compHome = (Grid)smith.placeShips();
	//	System.out.println("comp home");
	//	compHome.toString();
		
	System.out.println("PlayerTurn " + g.getPlayerTurn());
	System.out.println("Deployed " + g.deployed());
	
	System.out.println("PlayerTurn " + g.getPlayerTurn());	
	System.out.println("Deployed " + g.deployed());
		
	
	while(!g.deployed())
	{
		//Systems.out.println()
		//wait
		
	}
	
	compHome = (Grid)smith.placeShips();
	/*
	compHome.addAir(0,0,0);
	compHome.addBattle(1,0,0);
	compHome.addDest(2,0,0);
	compHome.addSub(3,0,0);
	compHome.addDest(4,0,0);
	compHome.addMine(5,0,0);*/
	g.setGrids(compHome,compAtt,playerHome,playerAtt,m);
		//g.paintMap();

		g.playerTurn();
	//=====================Game logic=======================================
		
		while (!g.getGameOver() && g.deployed())
		{
			
			while (g.getPlayerTurn())
			{
				g.checkSunk();/*
			System.out.println("AC Sunk " + compHome.checkAirSunk());
			System.out.println("bat Sunk " + compHome.checkBattleSunk());
			System.out.println("dest Sunk " + compHome.checkDestSunk());
			System.out.println("sub Sunk " + compHome.checkSubSunk());
			System.out.println("mine Sunk " + compHome.checkMineSunk());
			*/
			if(g.getAgentShipsSunk())
			{
				System.out.println("All sunk");
				g.setGameOver();
				g.setPlayerWins();
				g.agentTurn();
			}
			/*
			if(g.getPlayerShipsSunk())
			{
				g.setGameOver();
				g.setAgentWins();
				//g.setPlayerTurn;
			}
			*/
			
				//g.agentTurn();
				
			}
			g.repaint();
	//		System.out.println("AgentTurnNoWNOWNOWNOWNOW!!");
			
			while(!g.getPlayerTurn() &&!g.getGameOver()&&g.deployed())
			{
			
			System.out.println("agent turn");
			smith.nextShot(m,compAtt);
			g.agentShot(smith.getI(),smith.getJ());
			System.out.println("shot at " + smith.getI() + " " +smith.getJ());
			System.out.println(compAtt.toString());
			//if(playerHome.get(i,j
			
			
			
			System.out.println("Player Home board \n" +playerHome.toString());
			if(playerHome.checkMineSunk()&& !g.getPaintMineSunk())
			{
					for (int i = 0; i < 10; i++) //change these to ROWS to use the default
					{
						for (int j = 0; j < 10; j++)//change this to CoLumns for default
						{
							if(playerHome.getGridVal(i,j) ==-6)
							{
								smith.setSunk(i,j);
								g.setPaintMineSunk();
							}
						}
					}
			}
			
			if(playerHome.checkDestSunk() && !g.getPaintDestSunk())
			{
					for (int i = 0; i < 10; i++) //change these to ROWS to use the default
					{
						for (int j = 0; j < 10; j++)//change this to CoLumns for default
						{
							if(playerHome.getGridVal(i,j) ==-1)
							{
								smith.setSunk(i,j);
								g.setPaintDestSunk();
							}
						}
					}
			}
			
			if(playerHome.checkSubSunk() && !g.getPaintSubSunk())
			{
					for (int i = 0; i < 10; i++) //change these to ROWS to use the default
					{
						for (int j = 0; j < 10; j++)//change this to CoLumns for default
						{
							if(playerHome.getGridVal(i,j) ==-5)
							{
								smith.setSunk(i,j);
								g.setPaintSubSunk();
							}
						}
					}
			}
			
			if(playerHome.checkBattleSunk() && !g.getPaintBattleSunk())
			{
					for (int i = 0; i < 10; i++) //change these to ROWS to use the default
					{
						for (int j = 0; j < 10; j++)//change this to CoLumns for default
						{
							if(playerHome.getGridVal(i,j) ==-4)
							{
								smith.setSunk(i,j);
								g.setPaintBattleSunk();
							}
						}
					}
			}
			
			if(playerHome.checkAirSunk() && !g.getPaintAirSunk())
			{
					for (int i = 0; i < 10; i++) //change these to ROWS to use the default
					{
						for (int j = 0; j < 10; j++)//change this to CoLumns for default
						{
							if(playerHome.getGridVal(i,j) ==-3)
							{
								smith.setSunk(i,j);
								g.setPaintAirSunk();
							}
						}
					}
			}
			
			g.checkSunk();
			
			for(int i = 0; i<100000; i++)
			{
				for(int j = 0; j<3000; j++)
				{
					//waste time to see the shots happen at a slower speed
				}
				
			}
			
			
			/*
			if(g.getAgentShipsSunk())
			{
				g.setGameOver();
				g.setPlayerWins();
			}
			*/
			if(g.getPlayerShipsSunk())
			{
				g.setAgentWins();
				g.setGameOver();
				g.playerTurn();
				
			}			
			}
			

		}
		
		System.out.println("Game Over!");
		if(g.getPlayerWins())
		{
			System.out.println("Player Wins");
			g.setOut("Game Over! You Win!");
		}
		else
		{
			System.out.println("Computer Wins");
			g.setOut("Game Over! Agent Wins!");
		}
		
		}	
		
		/*
		smith.nextShot(m, compAtt);
		int i =smith.getI();
		int j =smith.getJ();
		while(!g.getPlayerTurn() && !g.getGameOver())
		{
			g.agentShot(0,0);
		}
		System.out.println(compHome.toString());
		
		*/
	
	
}
	



class AttackMousePressListener extends MouseAdapter
{
	
	private AttackPanel a;
	private GUI gui;
	
	public AttackMousePressListener(AttackPanel p, GUI gui2)
	{
		a=p;
		gui=gui2;
	}
	  
	
			public void mousePressed(MouseEvent event)
			{
				
				Graphics g = a.getGraphics();
				int x = event.getX();
				int y = event.getY();
			
				int gridj= -1;
				int gridi= -1;
				
				//corresponds the X co-ord to j grid element
				
				if (x < 20)
					gridj=0;
				else if (x <40)
					gridj=1;
				else if (x <60)
					gridj=2;
				else if (x <80)
					gridj=3;
				else if (x <100)
					gridj=4;
				else if (x <120)
					gridj=5;
				else if (x <140)
					gridj=6;
				else if (x <160)
					gridj=7;
				else if (x <180)
					gridj=8;
				else if (x <200)
					gridj=9;

				//corresponds the X co-ord to j grid element
				if (y < 20)
					gridi=0;
				else if (y <40)
					gridi=1;
				else if (y <60)
					gridi=2;
				else if (y <80)
					gridi=3;
				else if (y <100)
					gridi=4;
				else if (y <120)
					gridi=5;
				else if (y <140)
					gridi=6;
				else if (y <160)
					gridi=7;
				else if (y <180)
					gridi=8;
				else if (y <200)
					gridi=9;

				//compHome.shot(gridi,gridj);
				if(gui.getPlayerTurn()&&!gui.getGameOver()&&gui.deployed())
				{
					System.out.println(gui.shot(gridi,gridj));
					gui.checkSunk();
				}
				//Miss.paint(g,(gridj*20),(gridi*20));
					
				System.out.println("Element corresponds to " + gridi + gridj);
				
				//repaint();
			}
			/*
			public void mouseRelased(MouseEvent event){}
			public void mouseClicked(MouseEvent event) {}
			public void mouseEntered(MouseEvent event){}
			public void mouseExit(MouseEvent event){}
			*/
}

class HomeMousePressListener extends MouseAdapter
{
	
	private HomePanel a;
	private GUI gui;
	
	public HomeMousePressListener(HomePanel p, GUI gui2)
	{
		a=p;
		gui=gui2;
	}
	
	
			public void mousePressed(MouseEvent event)
			{
				
				Graphics g = a.getGraphics();
				int x = event.getX();
				int y = event.getY();
			
				int gridj= -1;
				int gridi= -1;
				
				//corresponds the X co-ord to j grid element
				
				if (x < 20)
					gridj=0;
				else if (x <40)
					gridj=1;
				else if (x <60)
					gridj=2;
				else if (x <80)
					gridj=3;
				else if (x <100)
					gridj=4;
				else if (x <120)
					gridj=5;
				else if (x <140)
					gridj=6;
				else if (x <160)
					gridj=7;
				else if (x <180)
					gridj=8;
				else if (x <200)
					gridj=9;

				//corresponds the X co-ord to j grid element
				if (y < 20)
					gridi=0;
				else if (y <40)
					gridi=1;
				else if (y <60)
					gridi=2;
				else if (y <80)
					gridi=3;
				else if (y <100)
					gridi=4;
				else if (y <120)
					gridi=5;
				else if (y <140)
					gridi=6;
				else if (y <160)
					gridi=7;
				else if (y <180)
					gridi=8;
				else if (y <200)
					gridi=9;

				
				//Hit.paint(g,(gridj*20),(gridi*20));
				if(!gui.deployed())
				{
					System.out.println(gui.deploy(gridi,gridj));
				}
				System.out.println("Element corresponds to " + gridi + gridj);
				//repaint();
			}
			/*
			public void mouseRelased(MouseEvent event){}
			public void mouseClicked(MouseEvent event) {}
			public void mouseEntered(MouseEvent event){}
			public void mouseExit(MouseEvent event){}
			*/
}

	
class RotateButtonAction extends MouseAdapter
{
	
	private GUI gui;
	
	public RotateButtonAction(GUI gui2)
	{
		
		gui=gui2;
	}	
	
	public void mousePressed(MouseEvent event)
	{
		System.out.println("Horiz = " +gui.rotate());
	}

}

class HideButtonAction extends MouseAdapter
{
	
	private GUI gui;
	
	public HideButtonAction(GUI gui2)
	{
		
		gui=gui2;
	}	
	
	public void mousePressed(MouseEvent event)
	{
		gui.hideMap();
	}

}


class ShowButtonAction extends MouseAdapter
{
	
	private GUI gui;
	
	public ShowButtonAction(GUI gui2)
	{
		
		gui=gui2;
	}	
	
	public void mousePressed(MouseEvent event)
	{
		gui.showMap();
	}

}

class NewButtonAction extends MouseAdapter
{
	
	private GUI gui;
	
	public NewButtonAction(GUI gui2)
	{
		
		gui=gui2;
	}	
	
	public void mousePressed(MouseEvent event)
	{
		gui.reset();
	}

}


class QuitButtonAction extends MouseAdapter
{
	
	public QuitButtonAction()
	{}	
	
	public void mouseClicked(MouseEvent event)
	{
		System.exit(1);
	}

}
