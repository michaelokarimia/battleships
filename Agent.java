/*
 * Author: Michael
 * Created: 16 April 2005 12:39:10
 * Modified: 16 April 2005 12:39:10
 */
import java.util.Random;

public class Agent
{
	private InfluenceMap m = null;
	private Grid g = null;
	private int i=-1;
	private int j=-1;
	private Random generator;
	
	public void Agent()
	{
		m = new InfluenceMap();		
		g= new Grid(10,10);
	}
	
	
	public int getI()
	{
		return i;
	}
	
	public int getJ()
	{
		return j;
	}	
	
	
	public InfluenceMap setSunk()
	{
		for (int i = 0; i < 10; i++) //change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)//change this to CoLumns for default
			{
				if(m.getVal(i,j) ==9)
				{
					m.sunk(i,j);
				}
			}
		}
		return m;
	}
	
	public InfluenceMap setSunk(int i, int j)
	{
		m.sunk(i,j);
		return m;
	}
	
	public void nextShot(InfluenceMap m1, Grid Attackgrid)
	{
		m = m1;
		
		g = Attackgrid;
		
		
		if (m.getNumberOfHotspots()==0 )
		{
			NumberGenerator Powergen = new NumberGenerator();
			
			//while(compAtt.getGridVal(i-
			i = Powergen.rand(10);
			j = Powergen.rand(10);
		}
		
		
		//if there is only one HS get it's co-ordinates on the IM
		
				if (m.getNumberOfHotspots()==1 )
				{
					int checki = m.getHotspotI();
					int checkj = m.getHotspotJ();
					
					if(g.getGridVal(checki, checkj) !=0)
					{
						m.set(checki, checkj, 0);
						i= checki;
						j= checkj;
					}
					
					// if the element on the attack grid has not been hit then set i,j to it.
					if(g.getGridVal(checki, checkj) ==0)
					{
						i= checki;
						j= checkj;
					}
					
					
					else //set i, j to a random that has not been hit
					{
						generator = new Random();
						
						boolean empty =false;
						//create random numbers
						while(!empty)
						{
							checki = generator.nextInt(10);
							checkj = generator.nextInt(10);
							//if co-ord is empty then set i,j to them
							if(g.getGridVal(checki, checkj) ==0)
							{
								empty = true;
							}
								
						}
					
						i= checki;
						j= checkj;
					}
						
				}
				
				
				//code to choose hotspots	
				//pulls the first pair of co-ords from an array
					if (m.getNumberOfHotspots()>1)
					{	
						boolean noneFound = false;
						System.out.println("Target multiple hotspots");
						int[] refs = m.getIntHotspots();
					
						if(g.getGridVal(refs[0],refs[1]) == 0)	
							{
								i=refs[0];
								j=refs[1];
							}
						
						else 
						{
							int loop =0;
							while(g.isValidPlaceForAShip(i,j) && !noneFound)
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
		
	}
	
		public Grid placeShips()
	{
		//boolean
		g= new Grid(10,10);
		
		while(!g.allShipsPlaced())
		{
		NumberGenerator gen = new NumberGenerator();
		int x = gen.rand(10);
		int y = gen.rand(10);
		int o = gen.rand(1);
				
		x = gen.rand(10);
		y = gen.rand(10);
		o = gen.rand(2);		
		System.out.println("vertical sub x = " + x + "\n");
		System.out.println("vertical sub y = " + y + "\n");
		g.addSub(x,y, o);
		
		x = gen.rand(10);
		y = gen.rand(10);
		o = gen.rand(2);		
		System.out.println("vertical battle x = " + x + "\n");
		System.out.println("vertical battle y = " + y + "\n");
		g.addBattle(x,y, o);	
	
		x = gen.rand(10);
		y = gen.rand(10);
		o = gen.rand(2);				
		System.out.println("vertical air x = " + x + "\n");
		System.out.println("vertical air y = " + y + "\n");
		g.addAir(x,y, o);
		
		x = gen.rand(10);
		y = gen.rand(10);
		o = gen.rand(2);				
		System.out.println("vertical mine x = " + x + "\n");
		System.out.println("vertical mine y = " + y + "\n");
		g.addMine(x,y, o);

		x = gen.rand(10);
		y = gen.rand(10);
		o = gen.rand(2);
		System.out.println("horizontal dest x = " + x + "\n");
		System.out.println("horizontal dest y = " + y + "\n");
		g.addDest(x,y, o);

	}
		
		System.out.println("agent grid");
		System.out.println(g.toString());
		
	return g;
	}
	
	public InfluenceMap getMap()
	{
		return m;
	}

}
