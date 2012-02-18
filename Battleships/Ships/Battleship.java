package Battleships.Ships;
/*
 * Author: Michael
 * Created: 07 December 2004 23:01:02
 * Modified: 07 December 2004 23:01:02
 */

import java.io.Serializable;

import Battleships.Grid;
import Battleships.exception.PositionExceedsBoardException;
import Battleships.exception.PositionOccupiedException;

public class Battleship extends Ship implements Serializable
{
	
	private int segments = 4;	
	
	/**
		Fills 4 sequential elements in the two dimensional array in either the same row or column with the a value.
		The value entered represents a Battleship on the grid.
		The elements will either be filled in row from left to right or a column from top to bottom
				
		@param i the row index to position the values
		@param j the column position to start placing the values from left to right
		@param isHorizontal if this is an 0 a horizontal ship will be entered in the grid, if this parameter equals a 1 a vertical ship will be entered in the grid
		
		@throws PositionExceedsBoardException if the ship cannot fit onto the board 
		@throws PositionOccupiedException if any of the 4 elements about to be filled are already filled
	*/
	public Battleship(Grid board ,int i, int j, boolean isHorizontal)
	{
		
		int userColumn = board.getWidth();
		int userRow = board.getLength();	
		
		if (board.checkBattlePlaced())
		{
			System.out.println("Battleship already placed\n");
			return;
		}
		
		if(isHorizontal)
		{
			if(j+4>userColumn)
				throw new PositionExceedsBoardException();
			
			for(int c =j; c < j+4 ; c++)
				while(board.getGridVal(i,c) != 0)
				{
					throw new PositionOccupiedException();
				}
					
			for(int c =j; c < j+4 ; c++)
				if(board.getGridVal(i,c) == 0)
				{
					board.update(i,c,4);
					board.setBattlePlacedTrue();
				}
		
		}
		else
		{		
			if(board.getGridVal(i,j) != 0)
				throw new PositionOccupiedException();
			if(i+4>userRow)
				throw new PositionExceedsBoardException();
			
			for(int r =i; r < i+4 ; r++)
				while(board.getGridVal(r,j) != 0)
				{
					throw new PositionOccupiedException();
				}
			
			for(int r =i; r < i+4 ; r++)
				if(board.getGridVal(r,j) == 0)
				{
					board.update(r,j,4);
					board.setBattlePlacedTrue();
				}
		}
	}
	
	
	/**
		Checks if the ship is sunk. 
	*/
	public boolean isSunk()
	{
		return (segments == 0);		
	}
	
	
	/**
		Reduces the number of undamaged segments of the ship by one when called.
		
	
	*/
	public void scoreHit()
	{
		segments--;
		
		if (segments < 0 )
			throw new IllegalArgumentException("Segments var is less than 0"); 		
			
	}

}
