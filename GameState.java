public class GameState {

	private boolean gameOver;

	public GameState ()
	{
		gameOver = false;
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
}