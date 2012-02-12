package Battleships;
/*
 * Author: Michael
 * Created: 13 November 2004 13:59:36
 * Modified: 13 November 2004 13:59:36
 */
import java.util.Random;

/** Creates a random number generator object
this object returns a random integer
 */
public class NumberGenerator
{
	private Random pos;
		
	/**Construtor */
	public NumberGenerator()
	{
		pos = new Random();
	}
	/**Generates a random positive int with the given range
	@param range the number from zero to the parameter*/
	
	public int rand(int range)
	{
				
		int x =pos.nextInt(range);
		
		if (x<0)
			x=-x;
					
		return(x);
	}
	
	
}
