public class GameState {

	private static final int WidthOfGrid = 10;
	private static final int HeightOfGrid = 10;
	private boolean gameOver;
	private boolean playerAircraftCarrierSunk;
	public Grid playerHomeGrid;
	private boolean playerBattleSunk;
	private boolean allAgentShipsSunk;
	private boolean allPlayerShipsSunk;
	boolean playerSubSunk;
	boolean playerDestSunk;
	boolean agentBattleSunk;
	boolean agentAirSunk;
	public Grid compHomeGrid;
	public Grid compAtt;
	public Grid playerAtt;
	public InfluenceMap influenceMap;
	private boolean playerMineSunk;
	private boolean agentDestSunk;
	private boolean agentSubSunk;
	private boolean agentMineSunk;

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
		playerHomeGrid = new Grid(WidthOfGrid,HeightOfGrid);
		compHomeGrid = new Grid(WidthOfGrid, HeightOfGrid);
		compAtt = new Grid(WidthOfGrid, HeightOfGrid);
		playerAtt = new Grid(WidthOfGrid, HeightOfGrid);
		influenceMap = new InfluenceMap();
				
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


	public void setShipSunkStates()
	{
		if(playerHomeGrid.checkAirSunk())
		{
			playerAircraftCarrierSunk = true;			
		}
		if(playerHomeGrid.checkBattleSunk())
		{
			playerBattleSunk = true;
		}
		if(playerHomeGrid.checkDestSunk())
		{
			playerDestSunk = true;
		}
		if(playerHomeGrid.checkSubSunk())
		{
			playerSubSunk = true;
		}
		if(playerHomeGrid.checkMineSunk())
		{
			playerMineSunk = true;
		}
		if(compHomeGrid.checkAirSunk())
		{
			agentAirSunk = true;
		}
		if(compHomeGrid.checkBattleSunk())
		{
			agentBattleSunk = true;
		}
		if(compHomeGrid.checkDestSunk())
		{
			agentDestSunk = true;
		}
		if(compHomeGrid.checkSubSunk())
		{
			agentSubSunk = true;
		}
		if(compHomeGrid.checkMineSunk())
		{
			agentMineSunk = true;
			
		}
		
		if(agentAirSunk&&agentBattleSunk&&agentDestSunk&&agentSubSunk&&agentMineSunk)
			allAgentShipsSunk = true;
		
		if(playerAircraftCarrierSunk&&playerBattleSunk&&playerDestSunk&&playerSubSunk&&playerMineSunk)
			allPlayerShipsSunk = true;
	
	}

	
	
	public boolean areAllAgentShipsSunk() {
		return allAgentShipsSunk;
	}

	public boolean getPlayerShipsSunk() {
		return allPlayerShipsSunk;
	}
}