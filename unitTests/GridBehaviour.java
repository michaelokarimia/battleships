package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Battleships.Grid;
import Battleships.Ships.*;;

public class GridBehaviour {

	private Grid grid;

	@Before
	public void setUp() throws Exception {
		grid = new Grid(10, 10);	
	}

	@Test
	public void NoShipsArePlacedOnNewBoard()
	{
		Grid secondgrid = new Grid(10,10);		
		AircraftCarrier ac = new AircraftCarrier(secondgrid, 0,0, true);
		Battleship battle = new Battleship(secondgrid, 1,1, true);
		Destroyer dest = new Destroyer(secondgrid, 2,2, true);
		Submarine sub = new Submarine(secondgrid, 3,3, true);
		Minesweeper sweeper = new Minesweeper(secondgrid, 4,4, true);
		assertFalse("AircraftCarrier not yet placed, but returns true", grid.checkIsShipPlaced(ac));
		assertFalse("Battleship not yet placed, but returns true", grid.checkIsShipPlaced(battle));
		assertFalse("Destroyer not yet placed, but returns true", grid.checkIsShipPlaced(dest));
		assertFalse("Submarine not yet placed, but returns true", grid.checkIsShipPlaced(sub));
		assertFalse("Minesweeper not yet placed, but returns true", grid.checkIsShipPlaced(sweeper));		
	}
	@Test
	public void checkIsShipPlacedisTrueAfterAllShipsArePlaced()
	{
		AircraftCarrier ac = new AircraftCarrier(grid, 0,0, true);
		Battleship battle = new Battleship(grid, 1,1, true);
		Destroyer dest = new Destroyer(grid, 2,2, true);
		Submarine sub = new Submarine(grid, 3,3, true);
		Minesweeper sweeper = new Minesweeper(grid, 4,4, true);
		assertTrue("AircraftCarrier placed, but returns false", grid.checkIsShipPlaced(ac));
		assertTrue("Battleship placed, but returns false", grid.checkIsShipPlaced(battle));
		assertTrue("Destroyer placed, but returns false", grid.checkIsShipPlaced(dest));
		assertTrue("Submarine placed, but returns false", grid.checkIsShipPlaced(sub));
		assertTrue("Minesweeper placed, but returns false", grid.checkIsShipPlaced(sweeper));		
	}
	
	@Test
	public void returnTrueSecondCheckIsShipPlacedAfterSubIsPlaced() {
		Submarine submarine = new Submarine(grid, 0, 0, true);
		boolean isShipPlaced = grid.checkIsShipPlaced(submarine);
		assertTrue("Submarine is already placed, but is returning false",isShipPlaced);
	}
	
	@Test
	public void returnFalseWhenCheckIsShipPlacedBeforeSubIsPlaced() {
		Grid secondgrid = new Grid(6,6);		
		boolean isShipPlaced = grid.checkIsShipPlaced(new Submarine(secondgrid, 0,0, true));
		assertFalse("Submarine has not been placed, but is returning trie",isShipPlaced);
	}
	
	@Test
	public void returnTrueSecondCheckIsShipPlacedAfterAircraftCarrierIsPlaced() {
		AircraftCarrier ac = new AircraftCarrier(grid, 0, 0, true);
		boolean isShipPlaced = grid.checkIsShipPlaced(ac);
		assertTrue("AircraftCarrier is already placed, but is returning false",isShipPlaced);
	}
	
	@Test
	public void returnFalseWhenCheckIsShipPlacedBeforeAircraftCarrierIsPlaced() {
		Grid secondgrid = new Grid(6,6);		
		boolean isShipPlaced = grid.checkIsShipPlaced(new AircraftCarrier(secondgrid, 0,0, true));
		assertFalse("AircraftCarrier has not been placed, but is returning trie",isShipPlaced);
	}

}
