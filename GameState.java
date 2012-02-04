public class GameState {

	private static final int WidthOfGrid = 10;
	private static final int HeightOfGrid = 10;
	private boolean gameOver;
	private boolean playerAircraftCarrierSunk;
	public Grid playerHome;
	private boolean playerBattleSunk;
	private boolean allAgentShipsSunk;
	private boolean allPlayerShipsSunk;
	boolean playerSubSunk;
	boolean playerDestSunk;
	boolean agentBattleSunk;
	boolean agentAirSunk;

	public GameState ()
	{
		gameOver = false;
		playerAircraftCarrierSunk = false;
		playerBattleSunk = false;
		allAgentShipsSunk = false;
		allPlayerShipsSunk = false;
		playerSubSunk = false;
		agentAirSunk = false;
		agentBattleSunk =false;
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


	public void setShipSunkStates(GUI gui)
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
			playerDestSunk = true;
		}
		if(playerHome.checkSubSunk())
		{
			playerSubSunk = true;
		}
		if(playerHome.checkMineSunk())
		{
			gui.playerMineSunk = true;
		}
		if(gui.compHome.checkAirSunk())
		{
			gui.agentAirSunk = true;
		}
		if(gui.compHome.checkBattleSunk())
		{
			agentBattleSunk = true;
		}
		if(gui.compHome.checkDestSunk())
		{
			gui.agentDestSunk = true;
		}
		if(gui.compHome.checkSubSunk())
		{
			gui.agentSubSunk = true;
		}
		if(gui.compHome.checkMineSunk())
		{
			gui.agentMineSunk = true;
			
		}
		
		if(gui.agentAirSunk&&agentBattleSunk&&gui.agentDestSunk&&gui.agentSubSunk&&gui.agentMineSunk)
			allAgentShipsSunk = true;
		
		if(playerAircraftCarrierSunk&&playerBattleSunk&&playerDestSunk&&playerSubSunk&&gui.playerMineSunk)
			allPlayerShipsSunk = true;
	
	}

	
	
	public boolean areAllAgentShipsSunk() {
		return allAgentShipsSunk;
	}

	public boolean getPlayerShipsSunk() {
		return allPlayerShipsSunk;
	}
}