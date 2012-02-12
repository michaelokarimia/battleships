package Battleships.exception;
/*
 * Author: Michael Okarimia
 * Created: 11 November 2004 19:47:33
 * Modified: 11 November 2004 19:47:33
 */


public class InitialPositionOccupiedException extends RuntimeException

{
	public InitialPositionOccupiedException()
	{
	}
	
	public InitialPositionOccupiedException(String reason)
	{
		super(reason);
	}
	

}
