package Battleships.Ships;
/*
 * Author: Michael
 * Created: 05 December 2004 18:57:44
 * Modified: 05 December 2004 18:57:44
 */
import java.io.Serializable;
import Battleships.Grid;

public class Minesweeper extends Ship implements Serializable
{
	private int intactSegments = 2;
	
	public Minesweeper(Grid board, int i, int j, boolean isHorizontal)
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
