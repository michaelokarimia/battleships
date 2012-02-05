/*
 * Author: Michael
 * Created: 07 December 2004 15:52:31
 * Modified: 07 December 2004 15:52:31
 */

import java.io.Serializable;


public abstract class Ship implements Serializable
{
	public Grid board = null;
	private int segments;
	
	
	/**
		Abstract constructor for ship
	*/
	public void Ship()
	{}
	
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
		
	
	
	public void scoreHit()
	{
		segments = segments -1;
		
		if (segments < 0 )
			throw new IllegalArgumentException("Segments var is less than 0"); 		
			
	}
	*/
}
