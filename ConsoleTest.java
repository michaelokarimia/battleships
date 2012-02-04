/*
 * Author: Michael
 * Created: 19 December 2004 16:07:06
 * Modified: 19 December 2004 16:07:06
 */

import java.io.*;
import java.util.*;


public class ConsoleTest
{

	public static void main(String[] args)throws IOException
	{
		boolean running = true;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<->");
		String CommandLine; 
		
		Grid playerHomeBoard = new Grid(10,10);
		Grid playerAttackBoard = new Grid(10,10);
		Grid computerHomeBoard = new Grid(10,10);
		Grid computerAttackBoard = new Grid(10,10);
		/*
		while(running)
		{
			//Grid playerHomeBoard = new Grid(10,10);
			while(!(playerHomeBoard.checkAirPlaced()))
				{
				System.out.println("Enter co-ords for an Aircraft Carrier");
				CommandLine = console.readLine();
				
			try
			{
				if (CommandLine.equals(""))
				{	
					System.out.println("You must enter a value");
					//CommandLine = console.readLine();
				}
			
			
			
				if (!(CommandLine.equals("")))
				{
			
				StringTokenizer strgTok = new StringTokenizer(CommandLine);
		
		//while (strgTok.hasMoreTokens())
		//{
		//String s= ;
				int size = -1;
		  		int acX	= -1;
				int acY = -1;
				int acO = -1;
				
				boolean vldCmd = false;
				
				
					try
					{
						
						
						if (strgTok.hasMoreTokens())
						{
												
						acX	= Integer.parseInt(strgTok.nextToken());
						
						acY = Integer.parseInt(strgTok.nextToken());
						
						acO = Integer.parseInt(strgTok.nextToken());
						
						if (acO>1 || acO<0)
							throw new IncorrectOrientationParameterException();
						
						if (acX>9 || acX<0)
							throw new OutOfGridAreaException();
						
						if (acY>9 || acY<0)
							throw new OutOfGridAreaException();
						
						System.out.println("acX = " + acX);

						System.out.println("acY = " + acY);
						
						System.out.println("acO = " + acO);
						
		
						vldCmd = true;
						}
		
						//int x = strgTok.next();
					
							
			
					}
				
					
					catch (NoSuchElementException e)
					{
					System.out.println("You must enter 3 separate values\n <-> " + e.toString());
					vldCmd=false;
					//running = false;
					}
					
					
				
					catch (NumberFormatException e)
					{
						System.out.println("You must enter three numbers\n <->");
						//vldCmd = false;
					}
					
					catch (IncorrectOrientationParameterException e)
					{
						System.out.println("The final number can only be 0 for horizontal or 1 for vertical \n<->");
						//vldCmd = false;
					}
					
					catch (OutOfGridAreaException e)
					{
						System.out.println("The first two numbers must be from 0 to 9\n<->");
						vldCmd = false;
					}
					
			
				if (vldCmd)
				{
					
					
					
					//System.out.println("size = " +size);

					playerHomeBoard.addAir(acX,acY,acO);
					if (playerHomeBoard.checkAirPlaced())
					{
						System.out.println(playerHomeBoard.toString());
						
						System.out.println("Aircraft Carrier Now Placed");
						//running = false;
					}
					
					else
					{
						vldCmd=false;
					}
					
					
				}
			
				if (!(vldCmd))
				{
					System.out.println("no valid commands");
					
					//CommandLine = console.readLine();
				}
			
				
			}	
	
		

			}	
		
			catch (NumberFormatException e)
			{
				System.out.println("You must enter a number" );
				//running = false;
			}
		
		}	
			
			
			
			
			
			
			
//================================================================--=-==-=--=-=-=-=-=-===================			
			System.out.println("Please enter Co-ordinates for the Battleship");
			//CommandLine = console.readLine();
			while(!(playerHomeBoard.checkBattlePlaced()))
				{
	//	System.out.println("Please enter Co-ordinates for the Battleship");	
		CommandLine = console.readLine();
			
		
			if (CommandLine.equals(""))
				{	
					System.out.println("You must enter a value");
					//CommandLine = console.readLine();
				}
			
			
			
				
			
				StringTokenizer strgTok = new StringTokenizer(CommandLine);
		
		//while (strgTok.hasMoreTokens())
		//{
		//String s= ;
				int size = -1;
		  		int bsX	= -1;
				int bsY = -1;
				int bsO = -1;
				
				boolean vldCmd = false;
			
			
			
			try
					{
						
						
						if (strgTok.hasMoreTokens())
						{
												
						bsX	= Integer.parseInt(strgTok.nextToken());
						
						bsY = Integer.parseInt(strgTok.nextToken());
						
						bsO = Integer.parseInt(strgTok.nextToken());
						
						if (bsO>1 || bsO<0)
							throw new IncorrectOrientationParameterException();
						
						if (bsX>9 || bsX<0)
							throw new OutOfGridAreaException();
						
						if (bsY>9 || bsY<0)
							throw new OutOfGridAreaException();
						
											
						
						System.out.println("bsX = " + bsX);

						System.out.println("bsY = " + bsY);
						
						System.out.println("bsO = " + bsO);
						
		
						vldCmd = true;
						}
		
						//int x = strgTok.next();
					
							
			
					}
					
					
					catch (OutOfGridAreaException e)
					{
						System.out.println("The first two numbers must be from 0 to 9\n<->");
						vldCmd = false;
					}
					
					catch (IncorrectOrientationParameterException e)
					{
						System.out.println("The final number can only be 0 for horizontal or 1 for vertical");
						//vldCmd = false;
					}
					
					catch (NoSuchElementException e)
					{
					System.out.println("You must enter 3 separate values " + e.toString());
					vldCmd=false;
					//running = false;
					}
					
					
				
					catch (NumberFormatException e)
					{
						System.out.println("You must enter three numbers");
						//vldCmd = false;
					}
					
					
			
				if (vldCmd)
				{
					//Grid playerHomeBoard = new Grid(10,10);
					
					
					//System.out.println("size = " +size);

					playerHomeBoard.addBattle(bsX,bsY,bsO);
					if (playerHomeBoard.checkBattlePlaced())
					{
						System.out.println(playerHomeBoard.toString());
						
						System.out.println("Battleship now Placed");
						running = false;
					}
					
					else
					{
						vldCmd=false;
					}
					
					
				}
			
				if (!(vldCmd))
				{
					System.out.println("no valid commands");
					
					//CommandLine = console.readLine();
				}
				
				
			}
		
//===================================================================================			
			
		while(!(playerHomeBoard.checkDestPlaced()))	
		{
			System.out.println("Please enter Co-ordinates for the Destroyer");
		
			CommandLine = console.readLine();
		
			if (CommandLine.equals(""))
				{	
					System.out.println("You must enter a value");
					//CommandLine = console.readLine();
				}
			
			
			
				
			
				StringTokenizer strgTok = new StringTokenizer(CommandLine);
		
		//while (strgTok.hasMoreTokens())
		//{
		//String s= ;
				//int size = -1;
		  		int dsX	= -1;
				int dsY = -1;
				int dsO = -1;
				
				boolean vldCmd = false;
			
			
			
			try
					{
						
						
						if (strgTok.hasMoreTokens())
						{
												
						dsX	= Integer.parseInt(strgTok.nextToken());
						
						dsY = Integer.parseInt(strgTok.nextToken());
						
						dsO = Integer.parseInt(strgTok.nextToken());
						
						if (dsO>1 || dsO<0)
							throw new IncorrectOrientationParameterException();
						
						if (dsX>9 || dsX<0)
							throw new OutOfGridAreaException();
						
						if (dsY>9 || dsY<0)
							throw new OutOfGridAreaException();
						
						
						System.out.println("dsX = " + dsX);

						System.out.println("dsY = " + dsY);
						
						System.out.println("dsO = " + dsO);
						
		
						vldCmd = true;
						}
		
						//int x = strgTok.next();
					
							
			
					}
				
					
					catch (NoSuchElementException e)
					{
					System.out.println("You must enter 3 separate values " + e.toString());
					vldCmd=false;
					//running = false;
					}
					
					
				
					catch (NumberFormatException e)
					{
						System.out.println("You must enter three numbers");
						//vldCmd = false;
					}
					
					catch (IncorrectOrientationParameterException e)
					{
						System.out.println("The final number can only be 0 for horizontal or 1 for vertical");
						//vldCmd = false;
					}
					
					catch (OutOfGridAreaException e)
					{
						System.out.println("The first two numbers must be from 0 to 9\n<->");
						vldCmd = false;
					}
			
				if (vldCmd)
				{
					//Grid playerHomeBoard = new Grid(10,10);
					
					
					//System.out.println("size = " +size);

					playerHomeBoard.addDest(dsX,dsY,dsO);
					if (playerHomeBoard.checkDestPlaced())
					{
						System.out.println(playerHomeBoard.toString());
						
						System.out.println("Destroyer now Placed");
						running = false;
					}
					
					else
					{
						vldCmd=false;
					}
					
					
				}
			
				if (!(vldCmd))
				{
					System.out.println("no valid commands");
					
					//CommandLine = console.readLine();
				}
			}
//==================================================================================================				
								


			while(!(playerHomeBoard.checkSubPlaced()))
				{
			System.out.println("Enter co-ordinates for the submarine");	
			
			CommandLine = console.readLine();
			try
			{
				if (CommandLine.equals(""))
				{	
					System.out.println("You must enter a value");
					//CommandLine = console.readLine();
				}
			
			
			
				if (!(CommandLine.equals("")))
				{
			
				StringTokenizer strgTok = new StringTokenizer(CommandLine);
		
		//while (strgTok.hasMoreTokens())
		//{
		//String s= ;
				
		  		int subX = -1;
				int subY = -1;
				int subO = -1;
				
				boolean vldCmd = false;
				
				
					try
					{
						
						
						if (strgTok.hasMoreTokens())
						{
												
						subX	= Integer.parseInt(strgTok.nextToken());
						
						subY = Integer.parseInt(strgTok.nextToken());
						
						subO = Integer.parseInt(strgTok.nextToken());
						
						if (subO>1 || subO<0)
							throw new IncorrectOrientationParameterException();
						
						if (subX>9 || subX<0)
							throw new OutOfGridAreaException();
						
						if (subY>9 || subY<0)
							throw new OutOfGridAreaException();
						
						System.out.println("subX = " + subX);

						System.out.println("subY = " + subY);
						
						System.out.println("subO = " + subO);
						
		
						vldCmd = true;
						}
		
						//int x = strgTok.next();
					
							
			
					}
				
					
					catch (NoSuchElementException e)
					{
					System.out.println("You must enter 3 separate values\n <-> " + e.toString());
					vldCmd=false;
					//running = false;
					}
					
					
				
					catch (NumberFormatException e)
					{
						System.out.println("You must enter three numbers\n <->");
						//vldCmd = false;
					}
					
					catch (IncorrectOrientationParameterException e)
					{
						System.out.println("The final number can only be 0 for horizontal or 1 for vertical \n<->");
						//vldCmd = false;
					}
					
					catch (OutOfGridAreaException e)
					{
						System.out.println("The first two numbers must be from 0 to 9\n<->");
						vldCmd = false;
					}
					
			
				if (vldCmd)
				{
					
					
					
					//System.out.println("size = " +size);

					playerHomeBoard.addSub(subX,subY,subO);
					if (playerHomeBoard.checkSubPlaced())
					{
						System.out.println(playerHomeBoard.toString());
						
						System.out.println("Submarine Now Placed");
						//running = false;
					}
					
					else
					{
						vldCmd=false;
					}
					
					
				}
			
				if (!(vldCmd))
				{
					System.out.println("no valid commands");
					
					//CommandLine = console.readLine();
				}
			
				
			}	
	
		

			}	
		
			catch (NumberFormatException e)
			{
				System.out.println("You must enter a number" );
				//running = false;
			}	
				
				
				
			}			
			
			
			
//===========================================================================================



			while(!(playerHomeBoard.checkMinePlaced()))
				{
			System.out.println("Enter co-ordinates for the Minesweeper");	
			
			CommandLine = console.readLine();
			try
			{
				if (CommandLine.equals(""))
				{	
					System.out.println("You must enter a value");
					//CommandLine = console.readLine();
				}
			
			
			
				if (!(CommandLine.equals("")))
				{
			
				StringTokenizer strgTok = new StringTokenizer(CommandLine);
		
		//while (strgTok.hasMoreTokens())
		//{
		//String s= ;
				
		  		int mineX = -1;
				int mineY = -1;
				int mineO = -1;
				
				boolean vldCmd = false;
				
				
					try
					{
						
						
						if (strgTok.hasMoreTokens())
						{
												
						mineX	= Integer.parseInt(strgTok.nextToken());
						
						mineY = Integer.parseInt(strgTok.nextToken());
						
						mineO = Integer.parseInt(strgTok.nextToken());
						
						if (mineO>1 || mineO<0)
							throw new IncorrectOrientationParameterException();
						
						if (mineX>9 || mineX<0)
							throw new OutOfGridAreaException();
						
						if (mineY>9 || mineY<0)
							throw new OutOfGridAreaException();
						
						System.out.println("mineX = " + mineX);

						System.out.println("mineY = " + mineY);
						
						System.out.println("mineO = " + mineO);
						
		
						vldCmd = true;
						}
		
						//int x = strgTok.next();
					
							
			
					}
				
					
					catch (NoSuchElementException e)
					{
					System.out.println("You must enter 3 separate values\n <-> " + e.toString());
					vldCmd=false;
					//running = false;
					}
					
					
				
					catch (NumberFormatException e)
					{
						System.out.println("You must enter three numbers\n <->");
						//vldCmd = false;
					}
					
					catch (IncorrectOrientationParameterException e)
					{
						System.out.println("The final number can only be 0 for horizontal or 1 for vertical \n<->");
						//vldCmd = false;
					}
					
					catch (OutOfGridAreaException e)
					{
						System.out.println("The first two numbers must be from 0 to 9\n<->");
						vldCmd = false;
					}
					
			
				if (vldCmd)
				{
					
					
					
					//System.out.println("size = " +size);

					playerHomeBoard.addMine(mineX,mineY,mineO);
					if (playerHomeBoard.checkMinePlaced())
					{
						System.out.println(playerHomeBoard.toString());
						
						System.out.println("Submarine Now Placed");
						//running = false;
					}
					
					else
					{
						vldCmd=false;
					}
					
					
				}
			
				if (!(vldCmd))
				{
					System.out.println("no valid commands");
					
					//CommandLine = console.readLine();
				}
			
				
			}	
	
		

			}	
		
			catch (NumberFormatException e)
			{
				System.out.println("You must enter a number" );
				//running = false;
			}	
				
				
				
			}
			
			
			
		running = false;
		}//While running loop
		
		*/
	

		int x = 0;
		int y = 0;
		int size =10;
		

		playerHomeBoard.addAir(0,0, 1);
				
		playerHomeBoard.addBattle(0,1, 1);
		
		playerHomeBoard.addSub(0,2, 1);
		
		playerHomeBoard.addMine(0,3,1);
		
		playerHomeBoard.addDest(0,4, 1);

		System.out.println("Your grid");
		System.out.println(playerHomeBoard.toString());
	

//=================== Player Attack Board ================================		
		
			
		System.out.println("Player Attack grid");
		System.out.println(playerAttackBoard.toString());

		
//=================== computer home board ================================		
		int XCompHomeBoard = 0;
		int YCompHomeBoard = 0;
		
	
		computerHomeBoard.addAir(9,0, 0);
		
		computerHomeBoard.addBattle(8,0, 0);
				
		computerHomeBoard.addSub(7,0, 0);
			
		computerHomeBoard.addDest(6,0, 0);
	
		computerHomeBoard.addMine(5,0,0);

		System.out.println(computerHomeBoard.printIsPlaced());
		
		System.out.println("computer grid");
		System.out.println(computerHomeBoard.toString());
		
		
		
		
		
// ====================Game logic=======================================

//=====================Game logic=======================================
		
		boolean playerTurn = true;
		boolean GameOverMan = false;
		boolean playerWins = false;
		boolean computerWins = false;
		
		while (!(GameOverMan))
		{
			while (playerTurn)
			{
		
			System.out.println("Player Turn");
					
			System.out.println("Enter two co-ordinates separated by a space to fire a shot");	
			
			CommandLine = console.readLine();
			try
			{
				if (CommandLine.equals(""))
				{	
					System.out.println("You must enter a value");
					//CommandLine = console.readLine();
				}
							
				if (!(CommandLine.equals("")))
				{
			
				StringTokenizer strgTok = new StringTokenizer(CommandLine);
		
		//while (strgTok.hasMoreTokens())
		//{
		//String s= ;
				
		  		int X = -1;
				int Y = -1;
				//int mineO = -1;
				
				boolean vldCmd = false;
				
				
					try
					{
						
						if (strgTok.hasMoreTokens())
						{
												
						X	= Integer.parseInt(strgTok.nextToken());
						
						Y = Integer.parseInt(strgTok.nextToken());
						
					
					
						if (X>9 || X<0)
							throw new OutOfGridAreaException();
						
						if (Y>9 || Y<0)
							throw new OutOfGridAreaException();
						
						System.out.println("X = " + X);

						System.out.println("Y = " + Y);
													
						vldCmd = true;
						}
					}
								
					catch (NoSuchElementException e)
					{
						System.out.println("You must enter 2 separate values\n <-> ");
						vldCmd=false;
					}
									
					catch (NumberFormatException e)
					{
						System.out.println("You must enter three numbers\n <->");
					}
															
					catch (OutOfGridAreaException e)
					{
						System.out.println("The first two numbers must be from 0 to 9\n<->");
						vldCmd = false;
					}
					//*********Shot code****************
				if (vldCmd)
				{
				 		int sqrVal = computerHomeBoard.getGridVal(X,Y);
						
						if(sqrVal < 0|| sqrVal==1)
						{
							System.out.println("Shot already taken! Have another go"); 
						}
							
						if(sqrVal == 0)
						{
							System.out.println(computerHomeBoard.shot(X,Y));
							playerAttackBoard.update(X,Y,1);
						}
						
						if(sqrVal > 1)
						{
							System.out.println(computerHomeBoard.shot(X,Y));
							playerAttackBoard.update(X,Y,8);
						}
						
												
						System.out.println(playerAttackBoard.toString());
						
						
						
						
						if(sqrVal==0)
							playerTurn = false;
				}
			
				
				
			}	
	
			}	
		
			catch (NumberFormatException e)
			{
				System.out.println("You must enter a number" );
				//running = false;
			}	

			//System.out.println("ships sunk" + playerHomeBoard.allShipsSunk());
				
			if(playerHomeBoard.allShipsSunk())
			{
				GameOverMan = true;
				playerWins= true;
				playerTurn=false;
			}
			
			if(computerHomeBoard.allShipsSunk())
			{
				GameOverMan = true;
				playerWins= false;
				playerTurn=false;
			}
			
			
				//playerTurn = false;
			}

//=================== AI Logic ==================================================


			while (!(playerTurn))
						
			{
				System.out.println("Computer turn");

				NumberGenerator gen = new NumberGenerator();

				int X;
				int Y;
				
				X = gen.rand(10);
		
				Y = gen.rand(10);
				
				
				int sqrVal = playerHomeBoard.getGridVal(X,Y);
						
						if(sqrVal < 0 || sqrVal==1)
						{
							System.out.println("Shot already taken! Have another go"); 
						}
							
						if(sqrVal == 0)
						{
							System.out.println(playerHomeBoard.shot(X,Y));
							computerAttackBoard.update(X,Y,1);
						}
						
						if(sqrVal > 1)
						{
							System.out.println(playerHomeBoard.shot(X,Y));
							computerAttackBoard.update(X,Y,8);
						}
						
						System.out.println("computerAttackBoard");						
						System.out.println(computerAttackBoard.toString());
						
						if(sqrVal==0)
							playerTurn = true;
				
				
			}
			
			
			
		}
		
		System.out.println("Game Over Man");
		if (playerWins)
			System.out.println("Player Wins");
		else if (computerWins)
			System.out.println("Computer Wins");
	
	
	
	
	
	
	}
}
			
















		/*		
				
		int x = 0;
		int y = 0;
				
		System.out.println("vertical aircraft carrier x = " + x + "\n");
		
		System.out.println("vertical aircraft carrier y = " + y + "\n");
		
		board.addAir(x,y, 1);
				
				
		
		
		System.out.println("horizontal Battleship x = " + 0 + "\n");
		
		System.out.println("horizontal Battleship y = " + 1 + "\n");

		board.addBattle(0,1, 0);
		
				
			
		
			
		
				
		
				
		System.out.println("Vertical sub x = " + 1 + "\n");
		
		System.out.println("Vertical sub y = " + 4 + "\n");
		
		board.addSub(1,4, 1);
				
		
		
		
		x = gen.rand(size);
		
		y = gen.rand(size);
				
		System.out.println("horizontal  mine x = " + 4 + "\n");
		
		System.out.println("horizontal  mine y = " + 1 + "\n");
		
		board.addMine(4,1, 0);
	
		
				
		System.out.println("horizontal dest x = " + 2 + "\n");
		
		System.out.println("horizontal  dest y = " + 1 + "\n");
		
		board.addDest(2,1, 0);
		
		System.out.println(board.toString());
		
		System.out.println(board.printIsPlaced());
		
		
		
		System.out.println(board.toString());
		
		System.out.println(board.shot(0,0));
		System.out.println(board.shot(1,1));
		
		System.out.println(board.toString());
		
		System.out.println(board.printIsSunk());
		
		System.out.println(board.shot(1,0));
		System.out.println(board.shot(2,0));
		System.out.println(board.shot(3,0));
		System.out.println(board.shot(4,0));
		
		System.out.println(board.toString());
		
		System.out.println(board.printIsSunk());
		*/
	


