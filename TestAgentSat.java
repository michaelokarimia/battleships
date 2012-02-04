/*
 * Author: Michael
 * Created: 14 February 2005 14:11:27
 * Modified: 14 February 2005 14:11:27
 * This file test the interaction between the computer agent's attackBoard and it's influence map
 * it will be used to develop methods for the AI agent class later.

 */

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class TestAgentSat 
{

	public static void main (String args[])
		throws IOException , ClassNotFoundException
	{
		System.out.println("tests the agent and influence map interaction");

		boolean acSunk = false;
		boolean bSunk = false;
		boolean dSunk = false;
		boolean sSunk = false;
		boolean mSunk = false;
		
		
//create player grid and place ships. also create computer attack board and the corresponding influence map		
		Grid playerHomeBoard = new Grid(10,10);
		
		Grid computerAttackBoard = new Grid(10,10);
		
		MapStore Store = new MapStore();

		MapStore myStore =null;  //new MapStore();

		InfluenceMap myMap = new InfluenceMap();
		
		InfluenceMap m = new InfluenceMap();
		//files to save Influence maps in
	/*	File f = new File("mapStore.dat");
		
		if(f.exists())
		{
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			
			System.out.println("file exists");
					
			Store = (MapStore)in.readObject();
			
			System.out.println("size is " + Store.size());
		//	if (Store.size()> 1)
			//m = (InfluenceMap)Store.getBestMap();
			//else 
			//	m = Store.getMap(0);
			if (m ==null)
				System.out.println("m is null");
			
			//m =myStore.getMap((myStore.size()-1));
			/*
			//sums the contents of all the previous maps into one map
			for(int l = 0; l <Store.size(); l++)
			{
				myMap = (InfluenceMap)Store.getMap(l);
				
				System.out.println(myMap);
				
				m.addMap(myMap); //
			
				System.out.println("The stored map is \n" +myMap.toString());	
			}
			*//*
					
			System.out.println("The map to play on is \n" +m.toString());		
			
		}*/
		/*  Configuration 4 *//*
		playerHomeBoard.addAir(5,0, 1);
		playerHomeBoard.addBattle(6,3, 1);
		playerHomeBoard.addSub(7,5, 1);
		playerHomeBoard.addMine(8,7,1);
		playerHomeBoard.addDest(7,9, 1);
		/**/
		
		/*  Configuration 3 *
		playerHomeBoard.addAir(0,0, 1);
		playerHomeBoard.addBattle(0,3, 1);
		playerHomeBoard.addSub(0,5, 1);
		playerHomeBoard.addMine(0,7,1);
		playerHomeBoard.addDest(0,9, 1);
		/**/
		
		/* Configuration 1/*
		playerHomeBoard.addAir(0,0, 1);
		playerHomeBoard.addBattle(0,1, 1);
		playerHomeBoard.addSub(0,2, 1);
		playerHomeBoard.addMine(0,3,1);
		playerHomeBoard.addDest(0,4, 1);
		/**/
		/*Configuration 2/*
		playerHomeBoard.addAir(0,0, 0);
		playerHomeBoard.addBattle(1,0, 0);
		playerHomeBoard.addSub(2,0, 0);
		playerHomeBoard.addDest(3,0, 0);
		playerHomeBoard.addMine(4,0,0);
		/**/
		/*Random*
		playerHomeBoard.addAir(3,5, 1);
		playerHomeBoard.addBattle(0,3, 1);
		playerHomeBoard.addSub(1,5, 0);
		playerHomeBoard.addMine(4,6,1);
		playerHomeBoard.addDest(8,0, 0);
		/**/
		
		while(!playerHomeBoard.allShipsPlaced())
		{
		NumberGenerator gen = new NumberGenerator();
		int x = gen.rand(10);
		int y = gen.rand(10);
		int o = gen.rand(1);
				
		x = gen.rand(10);
		y = gen.rand(10);
		o = gen.rand(2);		
		//System.out.println("vertical sub x = " + x + "\n");
		//System.out.println("vertical sub y = " + y + "\n");
		playerHomeBoard.addSub(x,y, o);
		
		x = gen.rand(10);
		y = gen.rand(10);
		o = gen.rand(2);		
		//System.out.println("vertical battle x = " + x + "\n");
		//System.out.println("vertical battle y = " + y + "\n");
		playerHomeBoard.addBattle(x,y, o);	
	
		x = gen.rand(10);
		y = gen.rand(10);
		o = gen.rand(2);				
		//System.out.println("vertical air x = " + x + "\n");
		//System.out.println("vertical air y = " + y + "\n");
		playerHomeBoard.addAir(x,y, o);
		
		x = gen.rand(10);
		y = gen.rand(10);
		o = gen.rand(2);				
		//System.out.println("vertical mine x = " + x + "\n");
		//System.out.println("vertical mine y = " + y + "\n");
		playerHomeBoard.addMine(x,y, o);

		x = gen.rand(10);
		y = gen.rand(10);
		o = gen.rand(2);
		//System.out.println("horizontal dest x = " + x + "\n");
		//System.out.println("horizontal dest y = " + y + "\n");
		playerHomeBoard.addDest(x,y, o);

	}
		
		System.out.println("Player grid");
		System.out.println(playerHomeBoard.toString());

		
		
//=================== AI Logic ==================================================
		
		boolean agentTurn= true;
		boolean running= true;
		NumberGenerator gen = new NumberGenerator();
		int turns = 0;
		int turns2 = 0;
		int i = -1;
		int j = -1;
		int lasti = -1;
		int lastj = -1;
		int hits = 0;
		int misses = 0;
		while (!playerHomeBoard.allShipsSunk())
			
		{
			while (agentTurn&&(!playerHomeBoard.allShipsSunk()))
						
			{
				System.out.println("Computer turn");

				//this section decides if there are any hotspots, if there are it will set i and j to them
				//otherwise it will pick numbers at random.
				//int maxVal = m.getMaxHotspotVal();
				//do random search
				
				System.out.println("Value of highest hs is " + m.getMaxHotspotVal());
				System.out.println("Number of hs is " + m.getNumberOfHotspots());
																								
					//if there is only one hotspot, and it has not already been shot at
					if (m.getNumberOfHotspots()==1 )
					{
						int checki = m.getHotspotI();
						int checkj = m.getHotspotJ();
						
						if(computerAttackBoard.getGridVal(checki,checkj)==0)
						{				
							i=m.getHotspotI();
							j=m.getHotspotJ();
							System.out.println("Target single hotspot at " + i + " " +j);
						}
						
						else if(computerAttackBoard.getGridVal(checki,checkj)==0)
							m.set(i,j,-5);
							
						
						
						//else 
							//generate a random co-ord that has not already been taken
							/*i=m.getHotspotI();
							j=m.getHotspotJ();
					
							System.out.println("Targeting single hotspot");
						
						while(computerAttackBoard.getGridVal(i,j) == 8 || computerAttackBoard.getGridVal(i,j) == 1)
							{	
								System.out.println("i = "+ i + " j=" + j);
								i = gen.rand(10);
								j = gen.rand(10);
							}*/
					}
				
				
				//code to choose hotspots	
				//pulls the first pair of co-ords from an array
					if (m.getNumberOfHotspots()>1)
					{	
						boolean noneFound = false;
						System.out.println("Target multiple hotspots");
						int[] refs = m.getIntHotspots();
					
						if(computerAttackBoard.getGridVal(refs[0],refs[1]) == 0)	
							{
								i=refs[0];
								j=refs[1];
							}
						
						else 
						{
							int loop =0;
							while(computerAttackBoard.checkGrid(i,j) && !noneFound)
							{
								if (loop ==100)
									noneFound = true;
								for (int q= 2; q < refs.length-1; q++)
								{
									i=refs[q];
									j=refs[q+1];
									
								}
								loop++;
							}
							
						}

					
						
						
						int length = refs.length-2;
					
						for (int z= 0; z < length; z++)
						{
							refs[z] = refs[z+2];
							//refs[z+1] = z+2;
						}
					
					}
				
				if(m.getNumberOfHotspots()==0)
				{
					System.out.println("Random mode");
					
					if(turns == 0)
					{
						i = gen.rand(10);
						j = gen.rand(10);
					}
					else
						
					
					{
						while(computerAttackBoard.getGridVal(i,j) != 0 && i<10 && i>-1 && j<10 && j>-1 )
						{
								//select a downward right diagonal
								if(lasti+1 != 10  && (lastj+1) != 10)
								{
									System.out.println("right diagonal");
									i = lasti+1;
									j = lastj+1;
								}
								else
								System.out.println("random mode");
								i = gen.rand(10);
								j = gen.rand(10);
							}
					}
				}
				
				//shot code
				int sqrVal = playerHomeBoard.getGridVal(i,j);
						
				
						if(sqrVal<0)
						{
							System.out.println("Ship is sunk here! End of turn"); 
							agentTurn = false;
						}
							
						if(sqrVal==1)
						{
							System.out.println("Miss! End of turn"); 
							/*
							while(computerAttackBoard.getGridVal(i,j) !=0)
							{
								
								//select a downward right diagonal
								if(lasti+1 != 10  && (lastj+1) != 10)
								{
									System.out.println("right diagonal");
									i = lasti+1;
									j = lastj+1;
								}
								else
									
								System.out.println("random gen");	
								i = gen.rand(10);
								j = gen.rand(10);
							}*/
							//agentTurn = false;
							m.miss(i,j);
							agentTurn = false;
						}
						
						else
							if(sqrVal == 0)
							{
								System.out.println(playerHomeBoard.shot(i,j));
								computerAttackBoard.update(i,j,1);
								m.miss(i,j);
								misses++;
								System.out.println("Influence Map");
								System.out.println(m.toString());
							}
						
							if(sqrVal > 1)
							{
								System.out.println(playerHomeBoard.shot(i,j));
								computerAttackBoard.update(i,j,8);
								m.hit(i,j);
								hits++;
								System.out.println("Influence Map");
								System.out.println(m.toString());
								
								/*displays sunk ship on computer attack grid*/
								if(playerHomeBoard.checkAirSunk())
								{
									System.out.println("Aircraft carrier sunk");
									for(int x = 0; x <10; x++)
									{
										for(int y = 0; y <10; y++)
										{
											if(playerHomeBoard.getGridVal(x,y)==-3)
											{
												//m.set(x,y,-3);
												computerAttackBoard.update(x,y,-3);
												m.sunk(i,j);
											}
																	
										}
									}
									
								}
								
								if(playerHomeBoard.checkBattleSunk())
								{
									System.out.println("Battleship sunk");
									for(int x = 0; x <10; x++)
									{
										for(int y = 0; y <10; y++)
										{
											if(playerHomeBoard.getGridVal(x,y)==-4)
											{
												computerAttackBoard.update(x,y,-4);
												m.sunk(i,j);
											}
																	
										}
									}
									
								}
								
								if(playerHomeBoard.checkDestSunk())
								{
									System.out.println("Destroyer sunk");
									for(int x = 0; x <10; x++)
									{
										for(int y = 0; y <10; y++)
										{
											if(playerHomeBoard.getGridVal(x,y)==-1)
											{
												computerAttackBoard.update(x,y,-1);
												m.sunk(i,j);
											}
																	
										}
									}
									
								}
								
								if(playerHomeBoard.checkSubSunk())
								{
									System.out.println("Sub sunk");
									for(int x = 0; x <10; x++)
									{
										for(int y = 0; y <10; y++)
										{
											if(playerHomeBoard.getGridVal(x,y)==-5)
											{
												computerAttackBoard.update(x,y,-5);
												m.sunk(i,j);
											}
																	
										}
									}
									
								}
								
								if(playerHomeBoard.checkMineSunk())
								{
									System.out.println("Minesweeper sunk");
									for(int x = 0; x <10; x++)
									{
										for(int y = 0; y <10; y++)
										{
											if(playerHomeBoard.getGridVal(x,y)==-6)
											{
												computerAttackBoard.update(x,y,-6);
												m.sunk(i,j);
											}
																	
										}
									}
									
								}
								
								System.out.println("PlayerHomeBoard Map");
								System.out.println(playerHomeBoard.toString());
							}
						
						m.searchDeadends();
						System.out.println("computerAttackBoard");						
						System.out.println(computerAttackBoard.toString());
						
						lasti = i;
						lastj = j;
						
						if(sqrVal==0)
							agentTurn = false;
				
						/*
						for(int c = 0; c<100000;c++)
						{//waste time
						}*/
			}
			turns++;
			turns2++;
			System.out.println("Turn over, number of turns is " + turns);
			
			if (turns2 >= 20 && hits == 0)
			{
				m.clearAll();
				System.out.println("20 or more turns without a hit, clearing Influence map");
				turns2 = 0;
			}
			/*
			if (turns >= 30 && misses == 15)
			{
				m.clearAll();
			}
			*/
			
			agentTurn= true;
		}
		
		InfluenceMap moderatingMap = new InfluenceMap();
		//moderating the map reduces it's 888 hit values to smaller that are incremented ones
		moderatingMap.addMap(m);
		//m.addMap(moderatingMap);

		
			System.out.println("Game over man, number of turns was " + turns);
			System.out.println("m Map is");
		/*	System.out.println(m.toString());
			//store.add(m);
		
			
			System.out.println("Summed moderating map");
			System.out.println(moderatingMap.toString());
			
			//	moderatingMap.addMap(m);
				//	moderatingMap.addMap(m);
						//moderatingMap.addMap(m);
		/*
			System.out.println("Summed moderating map2");
			System.out.println(moderatingMap.toString());
			*
		//Initialise a newMapstore object
		
		//Initialise a new Map object
		//InfluenceMap myMap = new InfluenceMap();
		//InfluenceMap currentMap = null;
		
		
		//checks if datastore file exists
		if(f.exists())
		{
			InfluenceMap blankMap = new InfluenceMap();
				
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			
			System.out.println("file exists");
			
			myStore = (MapStore)in.readObject();
			//currentMap = new InfluenceMap();
			
			
			
			//System.out.println("myMap map");
			//System.out.println(myMap.toString());
			
		//	System.out.println("Moderating Saved map");
		//	System.out.println(moderatingMap.toString());
			/*
			//m.addMap(blankMap);
			blankMap.addMap(m);
			System.out.println("Summed m + blank map \n" + m.toString());
			System.out.println("Summed m + blank map \n" + blankMap.toString());
		//	System.out.println(m.toString());
			
		blankMap.addMap(m);
			System.out.println("Summed m + blank map again \n" + blankMap.toString());	
		*
			
			System.out.println("Saving this map \n" + moderatingMap.toString() +"\n with " +turns + " Turns");	
			moderatingMap.setTurns(turns);
			myStore.add(moderatingMap);
			
			in.close();
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(myStore);
			out.close();
		}
		
		else if(!f.exists()) 
		{
			myStore = new MapStore();
		
		//myGrid2.get(1,2);
		
		
		myStore.add(moderatingMap);
		
		//myGrid2.add(board);
		
		//Grid Dave = myStore.getGrid(1);
		
		//System.out.println("Grid 4");
		//System.out.println(myStore.getGrid(3));
		
		System.out.println("New file created the number of maps stored is = " + myStore.size());
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		System.out.println("The map stored is \n" + moderatingMap.toString());
		out.writeObject(myStore);
		out.close(); 
	}*/
	
		//	System.out.println("The number of maps stored is = " + myStore.size());
			System.out.println("Game over man, number of turns was " + turns);


	}
}
/*

	*/