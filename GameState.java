public class GameState {

	private static final int WidthOfGrid = 10;
	private static final int HeightOfGrid = 10;
	private boolean gameOver;
	private boolean playerAircraftCarrierSunk;
	public Grid playerHome;

	public GameState ()
	{
		gameOver = false;
		playerAircraftCarrierSunk = false;
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

	public void playerAirSunk() {
		playerAircraftCarrierSunk = true;
		
	}

	public boolean IsplayerAircraftCarrierSunk() {
		return playerAircraftCarrierSunk;
	}
}