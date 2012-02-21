package Battleships.Ships;
/*
 * Author: Michael
 * Created: 08 December 2004 09:37:10
 * Modified: 08 December 2004 09:37:10
 */

import java.io.Serializable;
import Battleships.Grid;

public class AircraftCarrier extends Ship implements Serializable
{
	
	private int intactSegments = 5;	

	public AircraftCarrier(Grid board, int i, int j, boolean isHorizontal)
	{
		super.placeShipOnGrid(board, i, j, isHorizontal, intactSegments);
	}


	public boolean isSunk()
	{
		return (intactSegments == 0);
	}
	
	
	/**
		Reduces the number of undamaged segments of the ship by one when called	
	*/
	public void scoreHit()
	{
		intactSegments--;
		
		if (intactSegments < 0 )
			throw new IllegalArgumentException("Segments var is less than 0"); 		
			
	}


}
