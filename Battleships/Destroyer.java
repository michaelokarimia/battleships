package Battleships;
/*
 * Author: Michael
 * Created: 07 December 2004 16:50:18
 * Modified: 07 December 2004 16:50:18
 */

import java.io.Serializable;

import Battleships.exception.PositionExceedsBoardException;
import Battleships.exception.PositionOccupiedException;

public class Destroyer extends Ship implements Serializable
{
	private int segments = 3;
	
		/**
		Fills 3 sequential elements in the two dimensional array in either the same row or column with the a value.
		The value entered represents a Destroyer on the grid.
		The elements will either be filled in row from left to right or a column from top to bottom
				
		@param i the row index to position the values
		@param j the column position to start placing the values from left to right
		@param isHorizontal if this is an 0 a horizontal ship will be entered in the grid, if this parameter equals a 1 a vertical ship will be entered in the grid
		
		@throws PositionExceedsBoardException if the ship cannot fit onto the board 
		@throws PositionOccupiedException if any of the 3 elements about to be filled are already filled
	*/
	public Destroyer(Grid board, int i, int j, boolean isHorizontal)
	{
		int userColumn = board.getWidth();
		int userRow = board.getLength();	
						
		if (board.checkDestPlaced())
			{
				System.out.println("Submarine already placed\n");
				return;			
			}
		
		if(isHorizontal)
		{
			if(j+3>userColumn)
				throw new PositionExceedsBoardException();
		
			for(int c =j; c < j+3 ; c++)
				while(board.getGridVal(i,c) != 0)
				{
					throw new PositionOccupiedException();
				}
				
			for(int c =j; c < j+3 ; c++)
				if(board.getGridVal(i,c) == 0)
				{
					board.update(i,c,7);
					board.setDestPlacedTrue();
				}
		}
		else 
		{
			if(i+3>userRow)
				throw new PositionExceedsBoardException();
		
			for(int r =i; r < i+3 ; r++)
			{
				while(board.getGridVal(r,j) != 0)
				{
					throw new PositionOccupiedException();
				}
			}
			for(int r =i; r < i+3 ; r++)
			{
				if(board.getGridVal(r,j) == 0)
				{
					board.update(r,j,7);
					board.setDestPlacedTrue();
				}
			}
		}
	}
	
	
	/**
		Reduces the number of undamaged segments of the ship by one when called.
		
	
	*/
	public void scoreHit()
	{
		segments = segments -1;
		
		if (segments < 0 )
			throw new IllegalArgumentException("Segments var is less than 0"); 		
			
	}
	
		/**
		Checks if the ship is sunk. 
		
		@returns a boolean true if it is sunk and false if it is not sunk
	*/
	public boolean isSunk()
	{
		if (segments == 0)
			return true;
		else
			return false;
	}
	

}
