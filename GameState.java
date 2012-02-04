public class GameState {

	private static final int WidthOfGrid = 10;
	private static final int HeightOfGrid = 10;
	private boolean gameOver;
	private boolean playerAircraftCarrierSunk;
	public Grid playerHome;
	private boolean playerBattleSunk;
	private boolean allAgentShipsSunk;
	private boolean allPlayerShipsSunk;

	public GameState ()
	{
		gameOver = false;
		playerAircraftCarrierSunk = false;
		playerBattleSunk = false;
		allAgentShipsSunk = false;
		allPlayerShipsSunk = false;
		playerHome = new Grid(WidthOfGrid,HeightOfGrid);
	}

	public boolean IsGameOver() {
		return gameOver;
	}

	public void gameNotOver() {
		gameOver = false;
		
	}

	public void SetGameOver() {
		gameOver = false;
		
	}


	public void isAShipSunk(GUI gui)
	{
		if(playerHome.checkAirSunk())
		{
			playerAircraftCarrierSunk = true;			
		}
		if(playerHome.checkBattleSunk())
		{
			playerBattleSunk = true;
		}
		if(playerHome.checkDestSunk())
		{
			gui.playerDestSunk = true;
		}
		if(playerHome.checkSubSunk())
		{
			gui.playerSubSunk = true;
		}
		if(playerHome.checkMineSunk())
		{
			gui.playerMineSunk = true;
		}
	
		if(gui.compHome.checkAirSunk())
		{
			gui.agentAirSunk = true;
	//		outText.setText("You Have sunk the Agent's Aircraft Carrier");
		}
		if(gui.compHome.checkBattleSunk())
		{
			gui.agentBattleSunk = true;
		//	outText.setText("You Have sunk the Agent's Battleship");
		}
		if(gui.compHome.checkDestSunk())
		{
			gui.agentDestSunk = true;
		//	outText.setText("You Have sunk the Agent's Destroyer");
		}
		if(gui.compHome.checkSubSunk())
		{
			gui.agentSubSunk = true;
			//outText.setText("You Have sunk the Agent's Submarine");
		}
		if(gui.compHome.checkMineSunk())
		{
			gui.agentMineSunk = true;
			
		}
		
		if(gui.agentAirSunk&&gui.agentBattleSunk&&gui.agentDestSunk&&gui.agentSubSunk&&gui.agentMineSunk)
			allAgentShipsSunk = true;
		
		if(playerAircraftCarrierSunk&&playerBattleSunk&&gui.playerDestSunk&&gui.playerSubSunk&&gui.playerMineSunk)
			allPlayerShipsSunk = true;
	
	}

	
	
	public boolean areAllAgentShipsSunk() {
		return allAgentShipsSunk;
	}

	public boolean getPlayerShipsSunk() {
		return allPlayerShipsSunk;
	}
}