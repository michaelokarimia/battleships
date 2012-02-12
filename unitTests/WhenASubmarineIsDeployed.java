package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Battleships.AircraftCarrier;
import Battleships.Grid;
import Battleships.Submarine;
import Battleships.exception.*;

public class WhenASubmarineIsDeployed {

	private Grid grid;
	private boolean isHorizontal;

	@Before
	public void setup()
	{
		grid = new Grid(10, 10);
		AircraftCarrier ac = new AircraftCarrier(grid, 5,5,0);
		isHorizontal = true;
	}
	
	@Test
	public void CanBePlacedOnValidPositionOnGrid() {
		Submarine sub = new Submarine( grid , 1, 1, isHorizontal);
		assertNotNull(sub);
	}

	@Test
	public void isNotSunkAfterBeingCreated() {
		Submarine sub = new Submarine( grid , 1, 1, isHorizontal);
		assertFalse(sub.isSunk());
	}

	@Test
	public void isNotSunkAfterASingleHit() {
		Submarine sub = new Submarine( grid , 1, 1, isHorizontal);
		sub.scoreHit();
		assertFalse(sub.isSunk());
	}
	
	@Test
	public void isSunkAfterThreeHits() {
		Submarine sub = new Submarine( grid , 1, 1, isHorizontal);
		sub.scoreHit();
		sub.scoreHit();
		sub.scoreHit();
		assertTrue(sub.isSunk());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void throwsExceptionWhenPlacementCoordinatesAreLargerThanTheGrid()
	{
		Submarine sub = new Submarine( grid , 11, 11, isHorizontal);
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenHorizontalPlacedOffTheGrid()
	{
		Submarine sub = new Submarine( grid , 9, 9, isHorizontal);
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenVerticalPlacedOffTheGrid()
	{
		Submarine sub = new Submarine( grid , 9, 9, !isHorizontal);
	}
	
	@Test(expected = PositionOccupiedException.class)
	public void throwsExceptionWhenVerticalOverOtherShipTheGrid()
	{
		Submarine sub = new Submarine( grid , 4, 7, !isHorizontal);
	}
	
	@Test(expected = PositionOccupiedException.class)
	public void throwsExceptionWhenHorizontalOverOtherShipTheGrid()
	{
		Submarine sub = new Submarine( grid , 5, 4, isHorizontal);
	}

	
	

}
