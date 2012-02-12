package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Battleships.GameState;

public class WhenGameStateIsInitialised {
	
	private GameState state;
	
	@Before
	public void setupfixture()
	{
		state = new GameState();
	}
	
	@Test
	public void IsNotGameOver() {
		
		assertFalse(state.IsGameOver());
	}

	@Test
	public void NoShipsAreDeployed() {
		assertFalse(state.isBothPlayerAndAgentShipsDeployed());
	}
	
	@Test
	public void isPlayerTurn()
	{
		assertTrue(state.isPlayerTurn());
	}
	
	@Test
	public void notAgentTurn()
	{
		assertFalse(state.agentTurn);
	}
	
 
}
