package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Battleships.Grid;
import Battleships.Ships.AircraftCarrier;
import Battleships.Ships.Destroyer;
import Battleships.exception.PositionExceedsBoardException;
import Battleships.exception.PositionOccupiedException;

public class WhenDestroyerIsDeployed {

	Grid grid = new Grid(10, 10);
	private boolean isHorizontal;
	
	@Before
	public void setUp() throws Exception {
		isHorizontal = true;
		AircraftCarrier carrier = new AircraftCarrier( grid , 5, 5, isHorizontal);
	}
		
	@Test
	public void CanBePlacedOnValidPositionOnGrid() {
		Destroyer destroyer = new Destroyer( grid , 1, 1, isHorizontal);
		assertNotNull(destroyer);
	}
	@Test
	public void isNotSunkAfterBeingCreated() {
		Destroyer destroyer = new Destroyer( grid , 1, 1, isHorizontal);
		assertFalse(destroyer.isSunk());
	}

	@Test
	public void isNotSunkAfterASingleHit() {
		Destroyer destroyer = new Destroyer( grid , 1, 1, isHorizontal);
		destroyer.scoreHit();
		assertFalse(destroyer.isSunk());
	}
	
	@Test
	public void isNotSunkAfterOneHit() {
		Destroyer destroyer = new Destroyer( grid , 1, 1, isHorizontal);
		destroyer.scoreHit();
		assertFalse(destroyer.isSunk());
	}
	
	@Test
	public void isSunkAfterThreeHits() {
		Destroyer destroyer = new Destroyer( grid , 1, 1, isHorizontal);
		destroyer.scoreHit();
		destroyer.scoreHit();
		destroyer.scoreHit();
		assertTrue(destroyer.isSunk());
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenPlacementCoordinatesAreLargerThanTheGrid()
	{
		Destroyer destroyer = new Destroyer( grid , 11, 11, isHorizontal);
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenHorizontalPlacedOffTheGrid()
	{
		Destroyer destroyer = new Destroyer( grid , 9, 9, isHorizontal);
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenVerticalPlacedOffTheGrid()
	{
		Destroyer destroyer = new Destroyer( grid , 9, 9, !isHorizontal);
	}
	
	@Test(expected = PositionOccupiedException.class)
	public void throwsExceptionWhenVerticalOverOtherShipTheGrid()
	{
		Destroyer destroyer = new Destroyer( grid , 3, 6, !isHorizontal);
	}
	
	@Test(expected = PositionOccupiedException.class)
	public void throwsExceptionWhenHorizontalOverOtherShipTheGrid()
	{
		Destroyer destroyer = new Destroyer( grid , 5, 4, isHorizontal);
	}


}
