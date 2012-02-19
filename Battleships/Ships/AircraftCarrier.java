package Battleships.Ships;
/*
 * Author: Michael
 * Created: 08 December 2004 09:37:10
 * Modified: 08 December 2004 09:37:10
 */

import java.io.Serializable;

import Battleships.Grid;
import Battleships.exception.InitialPositionOccupiedException;
import Battleships.exception.PositionExceedsBoardException;
import Battleships.exception.PositionOccupiedException;


public class AircraftCarrier extends Ship implements Serializable
{
	
		private int remainingIntactCells = 5;	

		/**
		Fills 5 sequential elements in the two dimensional array in either the same row or column with the a value.
		The value entered represents an Aircraft Carrier on the grid.
		The elements will either be filled in row from left to right or a column from top to bottom
				
		@param i the row index to position the values
		@param j the column position to start placing the values from left to right
		@param isHorizontal ship orientation

		@throws PositionExceedsBoardException if the ship cannot fit onto the board 
		@throws PositionOccupiedException if any of the 5 elements about to be filled are already filled
	*/
		public AircraftCarrier(Grid board, int i, int j, boolean isHorizontal)
		{
			super.placeShipOnGrid(board, i, j, isHorizontal, remainingIntactCells);
		}


/**
		Checks if the ship is sunk. 
		
		@returns a boolean true if it is sunk and false if it is not sunk
	*/
	public boolean isSunk()
	{
		return (remainingIntactCells == 0);
	}
	
	
	/**
		Reduces the number of undamaged segments of the ship by one when called	
	*/
	public void scoreHit()
	{
		remainingIntactCells--;
		
		if (remainingIntactCells < 0 )
			throw new IllegalArgumentException("Segments var is less than 0"); 		
			
	}


}
