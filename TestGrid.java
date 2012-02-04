/*
 * Author: Michael
 * Created: 18 April 2005 10:40:42
 * Modified: 18 April 2005 10:40:42
 */


/*
To create your own custom template, create a copy of the Custom 
script in Tools/Eventhandlers/Java file/Templates and then modify 
it to create your own template.
*/
import java.awt.*;

class TestGrid
{

	public static void main (String args[])
	{
		
		Grid g = new Grid(10,10);
			
		System.out.println("Air placed" +g.addAir(9,0,0));	
		System.out.println(g.toString());
		
		
		System.out.println("Air placed" +g.addAir(0,0,1));	
		System.out.println(g.toString());
		
		System.out.println("battle placed" +g.addBattle(9,0,0));	
		System.out.println(g.toString());
		
		System.out.println("dest placed" +g.addDest(5,5,1));	
		System.out.println(g.toString());
		
		System.out.println("sub placed" +g.addSub(0,8,1));	
		System.out.println(g.toString());
		
		System.out.println("mine placed" +g.addMine(3,3,0));	
		System.out.println(g.toString());
		
		boolean b = g.shot(0,0);
		System.out.println(g.toString() + b);
	
		b = g.shot(0,1);
		System.out.println(g.toString() + b);
			
			
		b = g.shot(1,0);
		System.out.println(g.toString() + b);

			
			
			
			
			
		
	}
	
}