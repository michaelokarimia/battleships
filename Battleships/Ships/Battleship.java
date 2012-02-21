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
	
	private int intactSegments = 4;	
	
	public Battleship(Grid board ,int i, int j, boolean isHorizontal)
	{
		
		super.placeShipOnGrid(board, i, j, isHorizontal, intactSegments);
	}
	
	public boolean isSunk()
	{
		return (intactSegments == 0);		
	}
	
	
	/**
		Reduces the number of intact segments of the ship by one when called.
	*/
	public void scoreHit()
	{
		intactSegments--;
		
		if (intactSegments < 0 )
			throw new IllegalArgumentException("Segments var is less than 0"); 		
			
	}

}
