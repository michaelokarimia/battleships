package Battleships;
import javax.swing.JTextField;

import Battleships.Graphics.AttackPanel;
import Battleships.Graphics.HomePanel;
import Battleships.Graphics.InfluencePanel;


public class BattleShipsEngine {
	public AttackPanel attackPanel;
	public HomePanel homePanel;
	public InfluencePanel influenceMapPanel;
	public JTextField outText;
	public int i;
	public int j;
	public GameState gameState;
	public boolean agentWins;
	public boolean horiz;
	public boolean showMap;
	public boolean minePlaced;
	public boolean destPlaced;
	public boolean subPlaced;
	public boolean battlePlaced;
	
	public boolean agentMineSunk;
	public boolean agentDestSunk;
	public boolean agentSubSunk;
	public boolean agentAirSunk;
	public boolean playerMineSunk;
	public boolean paintMineSunk;
	public boolean paintDestSunk;
	public boolean paintSubSunk;
	public boolean paintBattleSunk;
	public boolean paintAirSunk;

	public BattleShipsEngine() {
	}
	

	public static void main (String args[])
	{
	
		GUI gui = new GUI(new GameState());
		Agent smith = new Agent();

		
		System.out.println("PlayerTurn " + gui.data.gameState.isPlayerTurn());
		System.out.println("Deployed " + gui.data.gameState.isBothPlayerAndAgentShipsDeployed());
		
		System.out.println("PlayerTurn " + gui.data.gameState.isPlayerTurn());	
		System.out.println("Deployed " + gui.data.gameState.isBothPlayerAndAgentShipsDeployed());
			
	
	
	
	
		while(!gui.data.gameState.playerHomeGrid.allShipsPlaced())
		{
				System.out.println("place your ships now");	
		}
		
		gui.data.gameState.addAgentShips(smith.placeShips());
		
		

		gui.data.gameState.setPlayerTurn();
		gui.data.outText.setText(gui.data.gameState.turnToString());

		
		while (!gui.getGameOver() && gui.data.gameState.isBothPlayerAndAgentShipsDeployed())
		{
			
			while (gui.data.gameState.isPlayerTurn())
			{
				gui.data.gameState.setShipSunkStates();
				if(gui.data.gameState.areAllAgentShipsSunk())
				{
					System.out.println("All sunk");
					gui.data.gameState.SetGameOver();
					gui.data.gameState.PlayerIsTheWinner();
				}
				else
				{}
		
				
			}
			gui.repaint();
	//		System.out.println("AgentTurnNoWNOWNOWNOWNOW!!");
			
			while(gui.data.gameState.isAgentTurn())
			{
			
				System.out.println("agent turn");
				smith.nextShot(gui.data.gameState.influenceMap, gui.data.gameState.compAtt);
				gui.agentShot(smith.getI(),smith.getJ());
				System.out.println("shot at " + smith.getI() + " " +smith.getJ());
				System.out.println(gui.data.gameState.compAtt.toString());
				//if(gameState.playerHome.get(i,j
				
				
				
				determineIfShotSunkAShip(gui, smith);
				
				gui.data.gameState.setShipSunkStates();
				
			
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
				if(gui.data.gameState.getPlayerShipsSunk())
				{
					gui.setAgentWins();
					gui.data.gameState.SetGameOver();
					gui.data.gameState.setPlayerTurn();
					
				}			
			}
			

		}
		
		System.out.println("Game Over!");
		if(gui.data.gameState.isPlayerWinner())
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


	private static void determineIfShotSunkAShip(GUI gui, Agent smith) {
		System.out.println("Player Home board \n" +gui.data.gameState.playerHomeGrid.toString());
		if(gui.data.gameState.playerHomeGrid.checkMineSunk()&& !gui.getPaintMineSunk())
		{
				for (int i = 0; i < 10; i++) //change these to ROWS to use the default
				{
					for (int j = 0; j < 10; j++)//change this to CoLumns for default
					{
						if(gui.data.gameState.playerHomeGrid.getGridVal(i,j) ==-6)
						{
							smith.setSunk(i,j);
							gui.setPaintMineSunk();
						}
					}
				}
		}
		
		if(gui.data.gameState.playerHomeGrid.checkDestSunk() && !gui.getPaintDestSunk())
		{
				for (int i = 0; i < 10; i++) //change these to ROWS to use the default
				{
					for (int j = 0; j < 10; j++)//change this to CoLumns for default
					{
						if(gui.data.gameState.playerHomeGrid.getGridVal(i,j) ==-1)
						{
							smith.setSunk(i,j);
							gui.setPaintDestSunk();
						}
					}
				}
		}
		
		if(gui.data.gameState.playerHomeGrid.checkSubSunk() && !gui.getPaintSubSunk())
		{
				for (int i = 0; i < 10; i++) //change these to ROWS to use the default
				{
					for (int j = 0; j < 10; j++)//change this to CoLumns for default
					{
						if(gui.data.gameState.playerHomeGrid.getGridVal(i,j) ==-5)
						{
							smith.setSunk(i,j);
							gui.setPaintSubSunk();
						}
					}
				}
		}
		
		if(gui.data.gameState.playerHomeGrid.checkBattleSunk() && !gui.getPaintBattleSunk())
		{
				for (int i = 0; i < 10; i++) //change these to ROWS to use the default
				{
					for (int j = 0; j < 10; j++)//change this to CoLumns for default
					{
						if(gui.data.gameState.playerHomeGrid.getGridVal(i,j) ==-4)
						{
							smith.setSunk(i,j);
							gui.setPaintBattleSunk();
						}
					}
				}
		}
		
		if(gui.data.gameState.playerHomeGrid.checkAirSunk() && !gui.getPaintAirSunk())
		{
				for (int i = 0; i < 10; i++) //change these to ROWS to use the default
				{
					for (int j = 0; j < 10; j++)//change this to CoLumns for default
					{
						if(gui.data.gameState.playerHomeGrid.getGridVal(i,j) ==-3)
						{
							smith.setSunk(i,j);
							gui.setPaintAirSunk();
						}
					}
				}
		}
	}
	
}