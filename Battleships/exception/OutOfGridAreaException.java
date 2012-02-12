package Battleships.exception;
/*
 * Author: Michael
 * Created: 04 January 2005 18:55:03
 * Modified: 04 January 2005 18:55:03
 */


public class OutOfGridAreaException extends RuntimeException
{
	
	public OutOfGridAreaException()
	{
	} 
	
	public OutOfGridAreaException(String reason)
	{
		super(reason);
	}
	

}


