package Battleships.Ships;
/*
 * Author: Michael
 * Created: 07 December 2004 15:52:31
 * Modified: 07 December 2004 15:52:31
 */

import java.io.Serializable;

import Battleships.Grid;
import Battleships.exception.PositionExceedsBoardException;
import Battleships.exception.PositionOccupiedException;


public abstract class Ship implements Serializable
{
	public Grid board = null;
	
	
	/**
		Abstract constructor for ship
	*/
	public void Ship()
	{}
	
	/**
		Checks if the ship is sunk. 
		
		@returns a boolean true if it is sunk and false if it is not sunk
	*/

	protected void placeShipOnGrid(Grid board, int i, int j,
			boolean isHorizontal, int segments) {
				int userColumn = board.getWidth();
				int userRow = board.getLength();
			
				if (board.checkIsShipPlaced(this))
				{	
						System.out.println(this.getClass().getName() + " already placed\n");
						return;
				}
				if (isHorizontal) {
					placeHorizontalShipOnGrid(board, i, j, segments, userColumn);
				}
				else 
				{
					placeVerticalShipOnGrid(board, i, j, segments, userRow);
				}
			}

	private void placeVerticalShipOnGrid(Grid board, int i, int j,
			int segments, int userRow) {
		if (board.getGridVal(i, j) != 0)
			throw new PositionOccupiedException();
		if (i + segments > userRow)
			throw new PositionExceedsBoardException();

		for (int r = i; r < i + segments; r++)
			while (board.getGridVal(r, j) != 0) {
				throw new PositionOccupiedException();
			}

		for (int r = i; r < i + segments; r++)
		{
			board.update(r, j, shipGridValue(this));
		}
		board.setShipAsPlaced(this);
	}

	private void placeHorizontalShipOnGrid(Grid board, int i, int j, int segments,
			int userColumn) {
		if (j + segments > userColumn)
			throw new PositionExceedsBoardException();

		for (int c = j; c < j + segments; c++)
			while (board.getGridVal(i, c) != 0) {
				throw new PositionOccupiedException();
			}

		for (int c = j; c < j + segments; c++)
		{
			board.update(i, c, shipGridValue(this));
		}
		board.setShipAsPlaced(this);
	}

	private int shipGridValue(Ship ship) {
		Class<? extends Ship> shipclass = ship.getClass();
		if(shipclass.equals(AircraftCarrier.class))
			return 5;
		if(shipclass.equals(Battleship.class))
			return 4;
		if(shipclass.equals(Destroyer.class))
			return 7;
		if(shipclass.equals(Submarine.class))
			return 3;
		if(shipclass.equals(Minesweeper.class))
			return 3;
		return 9;
	}
}
