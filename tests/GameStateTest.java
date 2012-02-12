package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Battleships.GameState;

public class GameStateTest {
	
	private GameState gameState;
	
	@Before
	public void setupfixture()
	{
		gameState = new GameState();
	}
	
	@Test
	public void newGameStateIsNotGameOver() {
		
		assertFalse(gameState.IsGameOver());
	}

	@Test
	public void testGameNotOver() {
		assertFalse(gameState.agentTurn);
	}

}
