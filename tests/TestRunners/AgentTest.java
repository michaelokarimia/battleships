package tests.TestRunners;

import Battleships.Agent;
import Battleships.Grid;
import Battleships.InfluenceMap;

public class AgentTest
{
	
	public static void main (String args[])
	{
		
		Grid compHome = new Grid(10,10);
		Grid compAtt = new Grid(10,10);
		Grid playerHome = new Grid(10,10);
		Grid playerAtt = new Grid(10,10);
		InfluenceMap m = new InfluenceMap();
		
		//g.playerTurn();
			
	
		Agent smith = new Agent();
		compHome = (Grid)smith.placeShips();
		System.out.println("comp home");
		compHome.toString();
		
		m= (InfluenceMap)smith.getMap();
		System.out.println("influence map");
		System.out.println(smith.getMap());
		
		m = new InfluenceMap();
		System.out.println("Get next Shot");
		smith.nextShot(m, compAtt);
		System.out.println(smith.getI() + smith.getJ());
		}
}