package Battleships.Ships;
/*
 * Author: Michael
 * Created: 07 December 2004 16:50:18
 * Modified: 07 December 2004 16:50:18
 */

import java.io.Serializable;

import Battleships.Grid;

public class Destroyer extends Ship implements Serializable
{
	private int remainingIntactCells = 3;
	
	public Destroyer(Grid board, int i, int j, boolean isHorizontal)
	{
		super.placeShipOnGrid(board, i, j, isHorizontal, remainingIntactCells);
	}
	
	/**
		Reduces the number of undamaged segments of the ship by one
	*/
	public void scoreHit()
	{
		remainingIntactCells--;
		
		if (remainingIntactCells < 0 )
			throw new IllegalArgumentException("remainingIntactCells is less than 0"); 		
			
	}
	
	public boolean isSunk()
	{
		return (remainingIntactCells == 0);
	}
}
