package Battleships;
/*
 * Author: Michael
 * Created: 07 December 2004 15:37:59
 * Modified: 07 December 2004 15:37:59
 */

/**
		Fills 3 sequencial elements in the two dimensional array in either the same row or column with the a value.
		The value entered represents a Submarine on the grid.
		The elements will either be filled in row from left to right or a column from top to bottom
				
		@param i the row index to postion the values
		@param j the column postition to start placing the values from left to right
		@param s if this is an 0 a horizonal ship will be entered in the grid, if this parameter equals a 1 a vertical ship will be entered in the grid
		
		@throws InitialPositionOccupiedException if the inital poition is already occupied with a ship
		@throws PositionExceedsBoardException if the ship cannot fit onto the board 
		@throws PositionOccupiedException if any of the 3 elements about to be filled are already filled
	*/


import java.io.Serializable;

import Battleships.exception.InitialPositionOccupiedException;
import Battleships.exception.PositionExceedsBoardException;
import Battleships.exception.PositionOccupiedException;

public class Sub extends Ship implements Serializable
{
	//public Grid board = null;
	private int segments = 3;	
	
	public Sub(Grid board, int i, int j, int s)
	{
		
		int userColumn = board.getWidth();
		int userRow = board.getLength();	
		
		boolean subPlaced = board.checkSubPlaced();
	
		if (subPlaced == true)
			System.out.println("Submarine already placed\n");
		
		if (s < 0 || s > 1)
			throw new IllegalArgumentException();
		
		
		if (s < 0 || s > 1)
			throw new IllegalArgumentException();
				
		if (subPlaced == true)
			System.out.println("Submarine already placed\n");
		
		if(subPlaced == false && s ==0)
		
		try
		{
		if(board.getGridVal(i,j) != 0)
			throw new InitialPositionOccupiedException();
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
				board.update(i,c,3);
				board.setSubPlacedTrue();
			}
		}
		
		catch (PositionOccupiedException Exception)
		{
			System.out.println("Cannot place horizontal submarine here, position is occupied \n");
		}
		
		catch (PositionExceedsBoardException Exception)
		{
			System.out.println("Cannot place horizontal submarine here, ship will not fit on grid \n");
		}
		
		catch (InitialPositionOccupiedException Exception)
		{
			System.out.println("Cannot place horizontal submarine here, initial point is already occupied \n");
		}
		
		else if(subPlaced == false && s ==1)
			try
		{
		
		if(board.getGridVal(i,j) != 0)
			throw new PositionOccupiedException();
		if(i+3>userRow)
			throw new PositionExceedsBoardException();
		
		for(int r =i; r < i+3 ; r++)
			while(board.getGridVal(r,j) != 0)
			{
				throw new PositionOccupiedException();
			}
		
		for(int r =i; r < i+3 ; r++)
			if(board.getGridVal(r,j) == 0)
			{
				board.update(r,j,3);
				board.setSubPlacedTrue();
			}
		}
		
		catch (PositionOccupiedException Exception)
		{
			System.out.println("Cannot place vertical submarine here, position is occupied \n");
		}
		
		catch (PositionExceedsBoardException Exception)
		{
			System.out.println("Cannot place vertical submarine here, ship will not fit on grid \n");
		}
		
		catch (InitialPositionOccupiedException Exception)
		{
			System.out.println("Cannot place vertical submarine here, initial point is already occupied \n");
		}
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
	
	
	/**
		Reduces the number of undamaged segments of the ship by one when called.
		
	
	*/
	public void scoreHit()
	{
		segments = segments -1;
		
		if (segments < 0 )
			throw new IllegalArgumentException("Segments var is less than 0"); 		
			
	}
	
}
