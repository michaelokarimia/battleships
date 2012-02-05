import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;	
	
class GUI extends JFrame
{
	
			
		
		
		
		
		private AttackPanel attackPanel;
		private HomePanel homePanel;
		private InfluencePanel influenceMapPanel;
		
		JTextField outText;
		private int i;
		private int j;
		
		GameState gameState;
		
		private boolean agentWins;
		
	
	
		
		private boolean playerDeployment;
		private boolean agentDeployment;
		
		private boolean horiz;
		private boolean showMap;
		
		private boolean minePlaced;
		private boolean destPlaced;
		private boolean subPlaced;
		private boolean battlePlaced;
		private boolean airPlaced;

		boolean agentMineSunk;
		boolean agentDestSunk;
		boolean agentSubSunk;
		boolean agentAirSunk;
		
		boolean playerMineSunk;
		private boolean paintMineSunk;
		private boolean paintDestSunk;
		private boolean paintSubSunk;
		private boolean paintBattleSunk;
		private boolean paintAirSunk;
		
		
		public GUI(GameState paramGameState)
	{
		super("Battleships");	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout(2,1));
		this.setResizable(false);
		
		
		
		
		playerDeployment = false;
		agentDeployment = false;
		
		minePlaced = false;
		destPlaced = false;
		subPlaced = false;
		battlePlaced = false;
		airPlaced = false;
		
		setHoriz(true);
		showMap= true;
		
		
		paintMineSunk= false;
		paintDestSunk= false;
		paintSubSunk= false;
		paintBattleSunk= false;
		paintAirSunk= false;
	
		gameState = paramGameState;
		
		
		
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
		attackPanel = new AttackPanel();
		attackPanel.addMouseListener(new AttackMousePressListener(attackPanel,this));
		
		
		homePanel = new HomePanel();
		homePanel.addMouseListener(new HomeMousePressListener(homePanel, this));
		
		influenceMapPanel = new InfluencePanel();
		
		APanel.add(attackPanel);
		CenterPanel.add(APanel);
		
		HPanel.add(homePanel);
		CenterPanel.add(HPanel);
		
		IMPanel.add(influenceMapPanel);
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
		
		
		setOutText(new JTextField("lookat me!"));
		getOutText().setText("Welcome To Battleships. Place ships on the middle grid");
		getOutText().setEditable(false);
		rotatePanel.add(getOutText());
		
		contentPane.add(CenterPanel,BorderLayout.CENTER);
		contentPane.add(southPanel,BorderLayout.SOUTH);
		
		this.pack();
		this.setSize(640,400);
		this.setVisible(true);
			
	}
	
	public void setOut(String s)
	{
		getOutText().setText(s);
	}
	public void repaint()
	{
		Graphics attackPanelGraphics = attackPanel.getGraphics();	
		
		for (int i = 0; i < 10; i++) //change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)//change this to CoLumns for default
			{
				if (gameState.playerAtt.getGridVal(i,j) == 1)
					MissIcon.paint(attackPanelGraphics,(j*20),(i*20));
				else
				if (gameState.isCompHomeGridLessThanMinus1(i,j))
					HitIcon.paint(attackPanelGraphics,(j*20),(i*20));
				
				
			}
		}

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
		
		 gameState = new GameState();
	
		 agentWins= false;
		
		 
		
		 
		
		 playerDeployment= false;
		 agentDeployment= false;
		
		 setHoriz(false);
		 showMap= false;
		
		 minePlaced= false;
		 destPlaced= false;
		 subPlaced= false;
		 battlePlaced= false;
		 airPlaced= false;

		 agentMineSunk= false;
		 agentDestSunk= false;
		 agentSubSunk= false;
		 		
		 playerMineSunk= false;
		 			 		
		
		
		playerDeployment = false;
		agentDeployment = false;
		
		minePlaced = false;
		destPlaced = false;
		subPlaced = false;
		battlePlaced = false;
		airPlaced = false;
		
		setHoriz(true);
		showMap= true;
		
		
		
		Grid compHome = new Grid(10,10);
		Grid compAtt = new Grid(10,10);
	
		
		
		
		
		
		this.pack();
		this.setSize(640,400);
		this.setVisible(true);	

	}
	
	public void paintComponent(Graphics g)
	{
		//super.paint(g);
		//Graphics2D g2 = (Graphics2D)g;
		
	}
		
	
		
	
	public String placeAir(int i, int j)
	{
		String out ="";
		if(!airPlaced)
		{
			if(isShipRotatedHorizonally())
			{
				boolean valid;
				valid = gameState.playerHomeGrid.addAir(i,j,0);
		
				Graphics hp = homePanel.getGraphics();
		
				if(valid)
				{	
					AircraftCarrierH.paint(hp,(j*20),(i*20));
					out = out + gameState.playerHomeGrid.toString();
					airPlaced = true;
					getOutText().setText("Air Placed");
				}
				else
				{
					getOutText().setText("Aircraft Carrier Will Not Fit Here");
					out ="not valid";
					out = out + gameState.playerHomeGrid.toString();
				}	
			}
		
		else 
		{
			boolean valid;
			valid = gameState.playerHomeGrid.addAir(i,j,1);
			if(valid)
			{
				Graphics hp = homePanel.getGraphics();	
				AircraftCarrier.paint(hp,(j*20),(i*20));
				out = out + gameState.playerHomeGrid.toString();
				airPlaced = true;
				getOutText().setText("Air Placed");
			}
			else
			{
				out ="not valid";
				out = out + gameState.playerHomeGrid.toString();
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
			if(isShipRotatedHorizonally())
			{
				boolean valid;
				valid = gameState.playerHomeGrid.addBattle(i,j,0);
		
				Graphics hp = homePanel.getGraphics();
		
				if(valid)
				{	
					BattleshipH.paint(hp,(j*20),(i*20));
					out = out + gameState.playerHomeGrid.toString();
					battlePlaced = true;
				//	outText.setText("Battleship Placed");
				}
				else
				{
					out ="not valid";
					out = out + gameState.playerHomeGrid.toString();
					getOutText().setText("Battleships Will Not Fit Here");
				}	
			}
		
		else 
		{
			boolean valid;
			valid = gameState.playerHomeGrid.addBattle(i,j,1);
			if(valid)
			{
				Graphics hp = homePanel.getGraphics();	
				Battleship.paint(hp,(j*20),(i*20));
				out = out + gameState.playerHomeGrid.toString();
				battlePlaced = true;
				getOutText().setText("Battleship Placed");
			}
			else
			{
				out ="not valid";
				out = out + gameState.playerHomeGrid.toString();
				getOutText().setText("Battleships Will Not Fit Here");
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
			if(isShipRotatedHorizonally())
			{
				boolean valid;
				valid = gameState.playerHomeGrid.addDest(i,j,0);
		
				Graphics hp = homePanel.getGraphics();
		
				if(valid)
				{	
					DestroyerH.paint(hp,(j*20),(i*20));
					out = out + gameState.playerHomeGrid.toString();
					destPlaced = true;
					getOutText().setText("Destroyer Placed");
				}
				else
				{
					out ="not valid";
					out = out + gameState.playerHomeGrid.toString();
					getOutText().setText("Destroyer Will Not Fit Here");
				}	
			}
		
		else 
		{
			boolean valid;
			valid = gameState.playerHomeGrid.addDest(i,j,1);
			if(valid)
			{
				Graphics hp = homePanel.getGraphics();	
				Destroyer.paint(hp,(j*20),(i*20));
				out = out + gameState.playerHomeGrid.toString();
				destPlaced = true;
				getOutText().setText("Destroyer Placed");
			}
			else
			{
				out ="not valid";
				out = out + gameState.playerHomeGrid.toString();
				
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
			if(isShipRotatedHorizonally())
			{
				boolean valid;
				valid = gameState.playerHomeGrid.addSub(i,j,0);
		
				Graphics hp = homePanel.getGraphics();
		
				if(valid)
				{	
					SubmarineH.paint(hp,(j*20),(i*20));
					out = out + gameState.playerHomeGrid.toString();
					subPlaced = true;
					getOutText().setText("Submarine Placed");
				}
				else
				{
					out ="not valid";
					out = out + gameState.playerHomeGrid.toString();
					getOutText().setText("Submarine Will Not Fit Here");
				}	
			}
		
		else 
		{
			boolean valid;
			valid = gameState.playerHomeGrid.addSub(i,j,1);
			if(valid)
			{
				Graphics hp = homePanel.getGraphics();	
				Submarine.paint(hp,(j*20),(i*20));
				out = out + gameState.playerHomeGrid.toString();
				subPlaced = true;
				getOutText().setText("Submarine Placed");
			}
			else
			{
				out ="not valid";
				out = out + gameState.playerHomeGrid.toString();
				getOutText().setText("Submarine Will Not Fit Here");
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
			if(isShipRotatedHorizonally())
			{
				boolean valid;
				valid = gameState.playerHomeGrid.addMine(i,j,0);
		
				Graphics hp = homePanel.getGraphics();
		
				if(valid)
				{	
					MinesweeperH.paint(hp,(j*20),(i*20));
					out = out + gameState.playerHomeGrid.toString();
					minePlaced = true;
					getOutText().setText("Minesweeper Placed");
				}
				else
				{
					out ="not valid";
					out = out + gameState.playerHomeGrid.toString();
					getOutText().setText("Minesweeper Will Not Fit Here");
				}	
			}
		
		else 
		{
			boolean valid;
			valid = gameState.playerHomeGrid.addMine(i,j,1);
			if(valid)
			{
				Graphics hp = homePanel.getGraphics();	
				Minesweeper.paint(hp,(j*20),(i*20));
				out = out + gameState.playerHomeGrid.toString();
				minePlaced = true;
				getOutText().setText("Minesweeper Placed");
			}
			else
			{
				out ="not valid";
				out = out + gameState.playerHomeGrid.toString();
				getOutText().setText("Minesweeper Will Not Fit Here");
			}	
		
		}
		
		if(airPlaced && battlePlaced && destPlaced && subPlaced && minePlaced)
				this.endDeployment();
			
		}
		
		
		return out;
	}	
	
	public boolean rotate()
	{
		setHoriz(!isShipRotatedHorizonally());
		if(isShipRotatedHorizonally()&&!gameState.isDeployed())
		getOutText().setText("Ship Will Be Placed Horizontally");
		if(!isShipRotatedHorizonally()&&!gameState.isDeployed())
		getOutText().setText("Ship Will Be Placed Vertically");
		return isShipRotatedHorizonally();
	}
	
	public void showMap()
	{
		showMap= true;
		this.paintMap();
		getOutText().setText("Influence Map shown");
	}
	
	public void hideMap()
	{
		showMap= false;
		
		Graphics g = influenceMapPanel.getGraphics();	
		
		for (int i = 0; i < 10; i++) //change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)//change this to CoLumns for default
			{
				int col = 0;
				IMap.paint(g,(j*20),(i*20), col);
			}
		}
		
		getOutText().setText("Influence Map Hidden");
	}	
	
    public String deploy(int i, int j)
	{
		String out1= "";
		
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
	out1=out1 + gameState.playerTurn;	/*playerHome.allShipsPlaced()*/;
	
	
		return out1;
	}

	
	

	

	
	public void setAgentWins()
	{
		agentWins= true;
		
	}
	
	public boolean getGameOver()
	{
		return gameState.IsGameOver();
	}

	
	

	
	public void playerTurn()
	{
		gameState.agentTurn=false;
		if(gameState.isDeployed())
		{
			gameState.playerTurn= true;
			getOutText().setText("Player Turn, Fire A Shot!");
		}
		else
			{gameState.playerTurn=false;}
		
	}
	
	public void agentTurn()
	{
		gameState.playerTurn= false;
		gameState.agentTurn=true;
		getOutText().setText("Agent Turn, please wait");
	
	}
	
	public boolean getPlayerTurn()
	{
			return gameState.playerTurn;
	}
	
	/*
	public void startDeployment()
	{
		deployment= true;
	}*/
	
	public void endDeployment()
	{
		if(minePlaced && destPlaced && subPlaced &&	battlePlaced &&	airPlaced)
		gameState.SetAllShipsDeployed();
		getOutText().setText("All Ships Deployed, Player's Turn! Click on the left grid to fire shots");
		this.playerTurn();
	} 
	
	
	
	public void paintMap()
	{
		
		Graphics g = influenceMapPanel.getGraphics();	
		
		for (int i = 0; i < 10; i++) //change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)//change this to CoLumns for default
			{
				int col = gameState.influenceMap.getVal(i,j);
				
				if(showMap)
				{
					IMap.paint(g,(j*20),(i*20), col);
				}
			}
		}
		
		
	}
		
	
	public void paintPlayerAttackGrid()
	{
		this.gameState.setShipSunkStates();
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				if(gameState.isCompHomegridRefIsminus3(i,j) && gameState.agentAirSunk)
				{					
					Graphics attackPanelGraphics = attackPanel.getGraphics();	
					Sunk.paint(attackPanelGraphics,(j*20),(i*20));
				}
				
				if(gameState.isCompHomeGridRefMinus4(i,j) && gameState.agentBattleSunk)
				{					
					Graphics ap = attackPanel.getGraphics();	
					Sunk.paint(ap,(j*20),(i*20));
				}
				
				//(agentMineSunk || agentDestSunk || agentSubSunk || agentBattleSunk
			}
		}
	}
	
	
	
	
	
	public void agentShot(int X, int Y)
		
	{
		if(gameState.agentTurn && gameState.isDeployed())
		{
		int sqrVal = gameState.playerHomeGrid.getGridVal(X,Y);
						
						if(sqrVal < 0 || sqrVal==1)
						{
							System.out.println("Shot already taken! Have another go"); 
						}
							
						if(sqrVal == 0)
						{
							System.out.println(gameState.playerHomeGrid.shot(X,Y));
							gameState.compAtt.update(X,Y,1);
							gameState.influenceMap.miss(X,Y);
							this.paintMap();
							Graphics hp = homePanel.getGraphics();	
							MissIcon.paint(hp,(Y*20),(X*20));
							getOutText().setText("Agent Has Missed. Player's Turn");
							this.playerTurn();
						}
						
						if(sqrVal > 1)
						{
							System.out.println(gameState.playerHomeGrid.shot(X,Y));
							gameState.compAtt.update(X,Y,8);
							gameState.influenceMap.hit(X,Y);
							Graphics hp = homePanel.getGraphics();	
							HitIcon.paint(hp,(Y*20),(X*20));
							getOutText().setText("Agent Has Hit One Of your ships! Agent's Turn again");
							this.paintMap();
							
						}
						
						System.out.println("compAtt");						
						System.out.println(gameState.compAtt.toString());
						
						if(sqrVal==0)
							this.playerTurn();
				
		}		
		
		System.out.println("Map is \n" + gameState.influenceMap.toString());
		
		
	}
		

	
	public static void main (String args[])
	{
		GameState gameState = new GameState();
		GUI gui = new GUI(gameState);
		Agent smith = new Agent();

		
	System.out.println("PlayerTurn " + gui.getPlayerTurn());
	System.out.println("Deployed " + gui.gameState.isDeployed());
	
	System.out.println("PlayerTurn " + gui.getPlayerTurn());	
	System.out.println("Deployed " + gui.gameState.isDeployed());
		
	
	while(!gui.gameState.isDeployed())
	{
		//Systems.out.println()
		//wait
		
	}
	
	gameState.addAgentShips(smith.placeShips());
	/*
	compHome.addAir(0,0,0);
	compHome.addBattle(1,0,0);
	compHome.addDest(2,0,0);
	compHome.addSub(3,0,0);
	compHome.addDest(4,0,0);
	compHome.addMine(5,0,0);*/
			//g.paintMap();

		gui.playerTurn();
	//=====================Game logic=======================================
		
		while (!gui.getGameOver() && gui.gameState.isDeployed())
		{
			
			while (gui.getPlayerTurn())
			{
				gui.gameState.setShipSunkStates();
			if(gui.gameState.areAllAgentShipsSunk())
			{
				System.out.println("All sunk");
				gameState.SetGameOver();
				gameState.PlayerIsTheWinner();
				gui.agentTurn();
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
			gui.repaint();
	//		System.out.println("AgentTurnNoWNOWNOWNOWNOW!!");
			
			while(!gui.getPlayerTurn() &&!gui.getGameOver()&&gui.gameState.isDeployed())
			{
			
			System.out.println("agent turn");
			smith.nextShot(gameState.influenceMap,gameState.compAtt);
			gui.agentShot(smith.getI(),smith.getJ());
			System.out.println("shot at " + smith.getI() + " " +smith.getJ());
			System.out.println(gameState.compAtt.toString());
			//if(gameState.playerHome.get(i,j
			
			
			
			System.out.println("Player Home board \n" +gameState.playerHomeGrid.toString());
			if(gameState.playerHomeGrid.checkMineSunk()&& !gui.getPaintMineSunk())
			{
					for (int i = 0; i < 10; i++) //change these to ROWS to use the default
					{
						for (int j = 0; j < 10; j++)//change this to CoLumns for default
						{
							if(gameState.playerHomeGrid.getGridVal(i,j) ==-6)
							{
								smith.setSunk(i,j);
								gui.setPaintMineSunk();
							}
						}
					}
			}
			
			if(gameState.playerHomeGrid.checkDestSunk() && !gui.getPaintDestSunk())
			{
					for (int i = 0; i < 10; i++) //change these to ROWS to use the default
					{
						for (int j = 0; j < 10; j++)//change this to CoLumns for default
						{
							if(gameState.playerHomeGrid.getGridVal(i,j) ==-1)
							{
								smith.setSunk(i,j);
								gui.setPaintDestSunk();
							}
						}
					}
			}
			
			if(gameState.playerHomeGrid.checkSubSunk() && !gui.getPaintSubSunk())
			{
					for (int i = 0; i < 10; i++) //change these to ROWS to use the default
					{
						for (int j = 0; j < 10; j++)//change this to CoLumns for default
						{
							if(gameState.playerHomeGrid.getGridVal(i,j) ==-5)
							{
								smith.setSunk(i,j);
								gui.setPaintSubSunk();
							}
						}
					}
			}
			
			if(gameState.playerHomeGrid.checkBattleSunk() && !gui.getPaintBattleSunk())
			{
					for (int i = 0; i < 10; i++) //change these to ROWS to use the default
					{
						for (int j = 0; j < 10; j++)//change this to CoLumns for default
						{
							if(gameState.playerHomeGrid.getGridVal(i,j) ==-4)
							{
								smith.setSunk(i,j);
								gui.setPaintBattleSunk();
							}
						}
					}
			}
			
			if(gameState.playerHomeGrid.checkAirSunk() && !gui.getPaintAirSunk())
			{
					for (int i = 0; i < 10; i++) //change these to ROWS to use the default
					{
						for (int j = 0; j < 10; j++)//change this to CoLumns for default
						{
							if(gameState.playerHomeGrid.getGridVal(i,j) ==-3)
							{
								smith.setSunk(i,j);
								gui.setPaintAirSunk();
							}
						}
					}
			}
			
			gui.gameState.setShipSunkStates();
			
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			if(g.getAgentShipsSunk())
			{
				g.setGameOver();
				g.setPlayerWins();
			}
			*/
			if(gui.gameState.getPlayerShipsSunk())
			{
				gui.setAgentWins();
				gameState.SetGameOver();
				gui.playerTurn();
				
			}			
			}
			

		}
		
		System.out.println("Game Over!");
		if(gameState.isPlayerWinner())
		{
			System.out.println("Player Wins");
			gui.setOut("Game Over! You Win!");
		}
		else
		{
			System.out.println("Computer Wins");
			gui.setOut("Game Over! Agent Wins!");
		}
		
		}


	private void setHoriz(boolean horiz) {
		this.horiz = horiz;
	}

	private boolean isShipRotatedHorizonally() {
		return horiz;
	}

	public void setOutText(JTextField outText) {
		this.outText = outText;
	}

	public JTextField getOutText() {
		return outText;
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
				if(gui.gameState.IsAcceptingPlayerInput())
				{
					Graphics g = a.getGraphics();
					int x = event.getX();
					int y = event.getY();
				
					int gridj= resolveAxisCoOrdinate(x);
					int gridi= resolveAxisCoOrdinate(y);
				
					Graphics attackPanelGraphics = a.getGraphics();
					
	                String acceptPlayerShotString = 
	                	gui.gameState.acceptPlayerShot(gridi,gridj, attackPanelGraphics, gui.outText);
	                
	                //gui.gameState.updatePlayerClick(gridi, gridj, gui);
	                
	                
	                
					System.out.println(acceptPlayerShotString);
					System.out.println("Element corresponds to " + gridi + gridj);
					
					
				}
			}

			private int resolveAxisCoOrdinate(int x) {
				if (x < 20)
					return 0;
				else if (x <40)
					return 1;
				else if (x <60)
					return 2;
				else if (x <80)
					return 3;
				else if (x <100)
					return 4;
				else if (x <120)
					return 5;
				else if (x <140)
					return 6;
				else if (x <160)
					return 7;
				else if (x <180)
					return 8;
				else if (x <200)
					return 9;
				return -1;
			}


			
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
				if(!gui.gameState.isDeployed())
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
