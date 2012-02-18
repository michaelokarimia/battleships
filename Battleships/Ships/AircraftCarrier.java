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
		Fills 5 sequencial elements in the two dimensional array in either the same row or column with the a value.
		The value entered represents an Aircraft Carrier on the grid.
		The elements will either be filled in row from left to right or a column from top to bottom
				
		@param i the row index to position the values
		@param j the column position to start placing the values from left to right
		@param isHorizontal ship orientation
		
		@throws InitialPositionOccupiedException if the initial position is already occupied with a ship
		@throws PositionExceedsBoardException if the ship cannot fit onto the board 
		@throws PositionOccupiedException if any of the 5 elements about to be filled are already filled
	*/
		public AircraftCarrier(Grid board, int i, int j, boolean isHorizontal)
		{
		
			int userColumn = board.getWidth();
			int userRow = board.getLength();	
			
			boolean airPlaced = board.checkAirPlaced();
			if (airPlaced)
				return;
		
			if(isHorizontal)
			{
				if(j+5>userColumn)
					throw new PositionExceedsBoardException();
			
				for(int c =j; c < j+5 ; c++)
					while(board.getGridVal(i,c) != 0)
					{
						throw new PositionOccupiedException();
					}
				
					
				for(int c =j; c < j+5 ; c++)
					if(board.getGridVal(i,c) == 0)
					{
						board.update(i,c,5);
						board.setAirPlacedTrue();
					}
			}
			else 
			{
					if(board.getGridVal(i,j) != 0)
						throw new PositionOccupiedException();
					if(i+5>userRow)
						throw new PositionExceedsBoardException();
				
					for(int r =i; r < i+5 ; r++)
						while(board.getGridVal(r,j) != 0)
						{
							throw new PositionOccupiedException();
						}
						
					for(int r =i; r < i+5 ; r++)
						if(board.getGridVal(r,j) == 0)
						{
							board.update(r,j,5);
							board.setAirPlacedTrue();
						}
			}
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
		Reduces the number of undamaged segments of the ship by one when called.
		
	
	*/
	public void scoreHit()
	{
		remainingIntactCells = remainingIntactCells -1;
		
		if (remainingIntactCells < 0 )
			throw new IllegalArgumentException("Segments var is less than 0"); 		
			
	}


}
