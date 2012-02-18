package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Battleships.Grid;
import Battleships.Ships.AircraftCarrier;
import Battleships.Ships.Battleship;
import Battleships.exception.PositionExceedsBoardException;
import Battleships.exception.PositionOccupiedException;

public class WhenBattleshipIsDeployed {

	Grid grid = new Grid(10, 10);
	private boolean isHorizontal;
	
	@Before
	public void setUp() throws Exception {
		isHorizontal = true;
		AircraftCarrier carrier = new AircraftCarrier( grid , 5, 5, isHorizontal);
		
	}
		
	@Test
	public void CanBePlacedOnValidPositionOnGrid() {
		Battleship battleship = new Battleship( grid , 1, 1, isHorizontal);
		assertNotNull(battleship);
	}

	@Test
	public void isNotSunkAfterBeingCreated() {
		Battleship battleship = new Battleship( grid , 1, 1, isHorizontal);
		assertFalse(battleship.isSunk());
	}

	@Test
	public void isNotSunkAfterASingleHit() {
		Battleship battleship = new Battleship( grid , 1, 1, isHorizontal);
		battleship.scoreHit();
		assertFalse(battleship.isSunk());
	}
	
	@Test
	public void isNotSunkAfterOneHit() {
		Battleship battleship = new Battleship( grid , 1, 1, isHorizontal);
		battleship.scoreHit();
		assertFalse(battleship.isSunk());
	}
	
	@Test
	public void isSunkAfterfourHits() {
		Battleship battleship = new Battleship( grid , 1, 1, isHorizontal);
		battleship.scoreHit();
		battleship.scoreHit();
		battleship.scoreHit();
		battleship.scoreHit();
		assertTrue(battleship.isSunk());
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenPlacementCoordinatesAreLargerThanTheGrid()
	{
		Battleship battleship = new Battleship( grid , 11, 11, isHorizontal);
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenHorizontalPlacedOffTheGrid()
	{
		Battleship battleship = new Battleship( grid , 9, 9, isHorizontal);
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenVerticalPlacedOffTheGrid()
	{
		Battleship battleship = new Battleship( grid , 9, 9, !isHorizontal);
	}
	
	@Test(expected = PositionOccupiedException.class)
	public void throwsExceptionWhenVerticalOverOtherShipTheGrid()
	{
		Battleship battleship = new Battleship( grid , 3, 6, !isHorizontal);
	}
	
	@Test(expected = PositionOccupiedException.class)
	public void throwsExceptionWhenHorizontalOverOtherShipTheGrid()
	{
		Battleship battleship = new Battleship( grid , 5, 4, isHorizontal);
	}


}
