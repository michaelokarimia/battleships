package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Battleships.Grid;
import Battleships.Ships.AircraftCarrier;
import Battleships.Ships.Minesweeper;
import Battleships.exception.*;

public class WhenAMinesweeperIsDeployed {

	private Grid grid;
	private boolean isHorizontal;

	@Before
	public void setup()
	{
		grid = new Grid(10, 10);
		AircraftCarrier ac = new AircraftCarrier(grid, 5,5,true);
		isHorizontal = true;
	}
	
	@Test
	public void CanBePlacedOnValidPositionOnGrid() {
		Minesweeper sweeper = new Minesweeper( grid , 1, 1, isHorizontal);
		assertNotNull(sweeper);
	}

	@Test
	public void isNotSunkAfterBeingCreated() {
		Minesweeper sweeper = new Minesweeper( grid , 1, 1, isHorizontal);
		assertFalse(sweeper.isSunk());
	}

	@Test
	public void isNotSunkAfterASingleHit() {
		Minesweeper sweeper = new Minesweeper( grid , 1, 1, isHorizontal);
		sweeper.scoreHit();
		assertFalse(sweeper.isSunk());
	}
	
	@Test
	public void isSunkAftertwoHits() {
		Minesweeper sweeper = new Minesweeper( grid , 1, 1, isHorizontal);
		sweeper.scoreHit();
		sweeper.scoreHit();
		assertTrue(sweeper.isSunk());
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenPlacementCoordinatesAreLargerThanTheGrid()
	{
		Minesweeper sweeper = new Minesweeper( grid , 11, 11, isHorizontal);
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenHorizontalPlacedOffTheGrid()
	{
		Minesweeper sweeper = new Minesweeper( grid , 9, 9, isHorizontal);
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenVerticalPlacedOffTheGrid()
	{
		Minesweeper sweeper = new Minesweeper( grid , 9, 9, !isHorizontal);
	}
	
	@Test(expected = PositionOccupiedException.class)
	public void throwsExceptionWhenVerticalOverOtherShipTheGrid()
	{
		Minesweeper sweeper = new Minesweeper( grid , 4, 7, !isHorizontal);
	}
	
	@Test(expected = PositionOccupiedException.class)
	public void throwsExceptionWhenHorizontalOverOtherShipTheGrid()
	{
		Minesweeper sweeper = new Minesweeper( grid , 5, 4, isHorizontal);
	}

	
	

}
