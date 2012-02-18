package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Battleships.Grid;
import Battleships.Ships.AircraftCarrier;
import Battleships.Ships.Destroyer;
import Battleships.exception.PositionExceedsBoardException;
import Battleships.exception.PositionOccupiedException;

public class WhenAircraftCarrierIsDeployed {

	Grid grid = new Grid(10, 10);
	private boolean isHorizontal;
	
	@Before
	public void setUp() throws Exception {
		isHorizontal = true;
		Destroyer dest = new Destroyer(grid, 5,5,isHorizontal);
		
	}
		
	@Test
	public void CanBePlacedOnValidPositionOnGrid() {
		AircraftCarrier carrier = new AircraftCarrier( grid , 1, 1, isHorizontal);
		assertNotNull(carrier);
	}

	@Test
	public void isNotSunkAfterBeingCreated() {
		AircraftCarrier carrier = new AircraftCarrier( grid , 1, 1, isHorizontal);
		assertFalse(carrier.isSunk());
	}

	@Test
	public void isNotSunkAfterASingleHit() {
		AircraftCarrier carrier = new AircraftCarrier( grid , 1, 1, isHorizontal);
		carrier.scoreHit();
		assertFalse(carrier.isSunk());
	}
	
	@Test
	public void isNotSunkAfterOneHit() {
		AircraftCarrier carrier = new AircraftCarrier( grid , 1, 1, isHorizontal);
		carrier.scoreHit();
		assertFalse(carrier.isSunk());
	}
	
	@Test
	public void isSunkAfterfiveHits() {
		AircraftCarrier carrier = new AircraftCarrier( grid , 1, 1, isHorizontal);
		carrier.scoreHit();
		carrier.scoreHit();
		carrier.scoreHit();
		carrier.scoreHit();
		carrier.scoreHit();
		assertTrue(carrier.isSunk());
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenPlacementCoordinatesAreLargerThanTheGrid()
	{
		AircraftCarrier carrier = new AircraftCarrier( grid , 11, 11, isHorizontal);
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenHorizontalPlacedOffTheGrid()
	{
		AircraftCarrier carrier = new AircraftCarrier( grid , 9, 9, isHorizontal);
	}
	
	@Test(expected = PositionExceedsBoardException.class)
	public void throwsExceptionWhenVerticalPlacedOffTheGrid()
	{
		AircraftCarrier carrier = new AircraftCarrier( grid , 9, 9, !isHorizontal);
	}
	
	@Test(expected = PositionOccupiedException.class)
	public void throwsExceptionWhenVerticalOverOtherShipTheGrid()
	{
		AircraftCarrier carrier = new AircraftCarrier( grid , 3, 6, !isHorizontal);
	}
	
	@Test(expected = PositionOccupiedException.class)
	public void throwsExceptionWhenHorizontalOverOtherShipTheGrid()
	{
		AircraftCarrier carrier = new AircraftCarrier( grid , 5, 4, isHorizontal);
	}


}
