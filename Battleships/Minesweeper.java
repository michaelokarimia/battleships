package Battleships;
/*
 * Author: Michael
 * Created: 05 December 2004 18:57:44
 * Modified: 05 December 2004 18:57:44
 */
import java.io.Serializable;

import Battleships.exception.PositionExceedsBoardException;
import Battleships.exception.PositionOccupiedException;

public class Minesweeper extends Ship implements Serializable
{
	public Grid board = null;
	private int remaingUndamagedSegments = 2;
		/**
		Fills 2 sequential elements in the two dimensional array in either the same row or column with the a value.
		The value entered represents an Mine sweeper on the grid.
		The elements will either be filled in row from left to right or a column from top to bottom
				
		@param i the row index to position the values
		@param j the column position to start placing the values from left to right
		@param isHorizontal if this is  a horizontal ship 
		@throws PositionExceedsBoardException if the ship cannot fit onto the board 
		@throws PositionOccupiedException if any of the 2 elements about to be filled are already filled
		*/
	public Minesweeper(Grid board, int i, int j, boolean isHorizontal)
	{
		int userColumn = board.getWidth();
		int userRow = board.getLength();	
		
		if (board.checkMinePlaced())
			{
				System.out.println("Minesweeper already placed\n");
				return;
			}
				
		if (isHorizontal)
		{
			if(j+2>userColumn)
				throw new PositionExceedsBoardException();
		
			for(int c =j; c < j+2 ; c++)
				while(board.getGridVal(i,c) != 0)
				{	
					throw new PositionOccupiedException();
				}
			
			for(int c =j; c < j+2 ; c++)
				if(board.getGridVal(i,c) == 0)
				{
					board.set(i,c,2);
				
					board.setMinePlacedTrue();
				}
			
			}
		else
		{
			if(board.getGridVal(i,j) != 0)
				throw new PositionOccupiedException();
			if(i+2>userRow)
				throw new PositionExceedsBoardException();
	
			for(int r =i; r < i+2 ; r++)
				while(board.getGridVal(r,j) != 0)
				{
					throw new PositionOccupiedException();
				}
	
			for(int r =i; r < i+2 ; r++)
				if(board.getGridVal(r,j) == 0)
				{
					board.set(r,j,2);
				 	board.setMinePlacedTrue();
				}
		}
	}
	
	/**
		Checks if the ship is sunk. 
		
		@returns a boolean true if it is sunk and false if it is not sunk
	*/
	public boolean isSunk()
	{
		return (remaingUndamagedSegments == 0);
	}
	
	
	/**
		Reduces the number of undamaged segments of the ship by one when called.
	*/
	
	public void scoreHit()
	{
		remaingUndamagedSegments--;
		
		if (remaingUndamagedSegments < 0 )
			throw new IllegalArgumentException("Segments var is less than 0"); 			
	}

}
