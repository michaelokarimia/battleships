/*
 * Author: Michael Okarimia
 * Created: 10 November 2004 15:43:46
 * Modified: 10 November 2004 15:43:46
 * This program creates a grid that a game of 
 * Battleships can be played on
 * Improvements from code1 are:
 * 1: Destroyer ship now added
 * 2: Horizontal and vertical positioning is determined by int not char
 * 3: Grid is now Serializable
 */

import java.io.Serializable;
	
	
public class Grid implements Serializable 
{	
	private int[][] board;// two dimensional array to hold the board data
	
	private int userRow;
	private int userColumn;
	
	private boolean minePlaced = false;
	private boolean subPlaced = false;
	private boolean destPlaced = false;
	private boolean battlePlaced = false;
	private boolean airPlaced = false;
	private boolean allShipsSunk = false;
	
	private Mine minesweeper;
	private Sub submarine;
	private Dest destroyer;
	private Battle battleship;
	private Air aircraftCarrier;
	
	
		/**
		Constructs a two dimensional array which represent the game board. 
		All elements in the two dimensional array on the grid are set to (zero) 0, which represents an empty grid
		The board's dimensions are determined by the parameters i and j
		
		@param i the number of rows of the grid
		@param j the number of columns of the grid
	*/	
	public Grid(int i, int j)
	{
		userRow = i;
		userColumn = j;
		
		board = new int[userRow][userColumn];
		
		for (int a = 0; i< userRow; i++)
			for (int b = 0; j < userColumn; j++)
				board[a][b] = 0;
	}
	/**
		Returns the number of columns in the grid
	*/
	public int getWidth()
	{
		return userColumn;
	}
	
	/**
		Returns the number of rows in the grid
	*/
	
	public int getLength()
	{
		return userRow;
	}
	
	/**
		Checks the grid references and returns a boolean value if there is a ship on that spot
		
		@param i the column of the grid reference
		@param j the row of the grid reference
		
		@return a boolean value, true if the grid contains a ship and false if it contains either a miss or empty		
	*/
	public boolean isValidPlaceForAShip(int i, int j)
	{
		int index;
		index = this.getGridVal(i,j);

		if (index >1 && index <8 ) 
			return true;
		
		else return false;
		
	}
	
	/**
		Checks if all ships are sunk
	*/	
	
	public boolean allShipsSunk()
	{
		
		if((minesweeper.isSunk()&& submarine.isSunk()&& destroyer.isSunk()&& battleship.isSunk()&& aircraftCarrier.isSunk() ))
			allShipsSunk = true;
		
		return allShipsSunk;
	}		
	
	public boolean checkMineSunk()
	{
		
		return minesweeper.isSunk();		
	}
	
	public boolean checkSubSunk()
	{
		return submarine.isSunk();
	}
	
	public boolean checkDestSunk()
	{
		
		return destroyer.isSunk();
	}
	
	public boolean checkBattleSunk()
	{
		
		return battleship.isSunk();
	}
	
	public boolean checkAirSunk()
	{		
		//System.out.print(this.aircraftCarrier.toString()); 

		return aircraftCarrier.isSunk();
	}
	
	
	
	/**
		Checks if the minesweeper has been placed
	*/
	
	public boolean checkMinePlaced()
	{
		if (minePlaced == true)
			return true;
		
		else return false;
	}
	/**
		Sets minePlaced flag to true
	*/
	
	public void setMinePlacedTrue()
	{
		minePlaced=true;
	}
	
	public boolean addMine(int i, int j, int s)
	{
		minesweeper = new Mine(this, i, j, s);
		return checkMinePlaced();
	}
	
	
	
	/**
		Checks if the Sub has been placed
	*/
	
	public boolean checkSubPlaced()
	{
		if (subPlaced == true)
			return true;
		
		else return false;
	}
	/**
		Sets subPlaced flag to true
	*/
	
	public void setSubPlacedTrue()
	{
		subPlaced=true;
	}
	
	/**
		Adds a Submarine object to the grid
	*/
	
	public boolean addSub(int i, int j, int s)
	{
		 submarine = new Sub(this, i, j, s);
			return checkSubPlaced();
	}
	

	/**
		Checks if the Destroyer has been placed
	*/
	
	public boolean checkDestPlaced()
	{
		if (destPlaced == true)
			return true;
		
		else return false;
	}
	/**
		Sets destPlaced flag to true
	*/
	
	public void setDestPlacedTrue()
	{
		destPlaced=true;
	}
	
	/**
		Adds a Destroyer object to the grid
	*/
	
	public boolean addDest(int i, int j, int s)
	{
		 destroyer = new Dest(this, i, j, s);
			return checkDestPlaced();
	}
		
	
	/**
		Checks if the Battleship has been placed
	*/
		public boolean checkBattlePlaced()
	{
		if (battlePlaced == true)
			return true;
		
		else return false;
	}
	/**
		Sets battlePlaced flag to true
	*/
	
	public void setBattlePlacedTrue()
	{
		battlePlaced=true;
	}
	
	/**
		Adds a Battle object to the grid
	*/
	
	public boolean addBattle(int i, int j, int s)
	{
		 battleship = new Battle(this, i, j, s);
			return checkBattlePlaced();
	}
	
	
	/**
		Checks if the aircraftCarrier has been placed
	*/
		public boolean checkAirPlaced()
	{
		if (airPlaced == true)
			return true;
		
		else return false;
	}
	/**
		Sets airPlaced flag to true
	*/
	
	public void setAirPlacedTrue()
	{
		airPlaced=true;
	}
	
	/**Checks if all ships have been placed*/
	public boolean allShipsPlaced()
	{
		
		if((checkMinePlaced()&& checkSubPlaced()&& checkDestPlaced()&& checkBattlePlaced()&& checkAirPlaced() ))
		{return true;}
		else
			return false;
	}	
	
	
	
	
	/**
		Adds an Air object to the grid
	*/
	
	public boolean addAir(int i, int j, int s)
	{
		 aircraftCarrier = new Air(this, i, j, s);
		 return checkAirPlaced();
			
	}
	
	/**
		This method is used by the ship classes to add the ships to the grid.
		Sets the value of a grid location to a specified integer. The grid location must be set to (zero) 0.
		@param i the row index
		@param j the column index
		@param value the value of the square 
	*/
	public void set(int i, int j, int value)
	{
		if(i > userRow || j > userColumn)
			throw new IllegalArgumentException("Number is bigger that the grid size");
		if(i < 0 || j < 0 || value < 0) 
			throw new IllegalArgumentException("Number cannot be negative");
		if(board[i][j] != 0)
			throw new IllegalArgumentException("Initial Position occupied");
		if(value == 0)
			throw new IllegalArgumentException("Number cannot = 0");
		board[i][j] = value;
	}
	
	/**
		This method is used by the shot() method to update the grid.
		Sets the value of a grid location to a specified integer. The grid location must be set to (zero) 0.
		@param i the row index
		@param j the column index
		@param value the value of the square 
	*/
	public void update(int i, int j, int value)
	{
		if(i > userRow || j > userColumn)
			throw new IllegalArgumentException("Number is bigger that the grid size");
		if(i < 0 || j < 0) 
			throw new IllegalArgumentException("Number cannot be negative");
		if(value == 0)
			throw new IllegalArgumentException("Number cannot = 0");
		board[i][j] = value;
	}
	
	
	/**
		Returns the value of the given grid index
		@param i the row index
		@param j the column index
	*/
	public int getGridVal(int i, int j)
	{
		if(i < 0 || j < 0)
			throw new IllegalArgumentException("Number cannot be negative");
		if(i > userRow || j > userColumn)
			throw new IllegalArgumentException("Number is bigger that the grid size");
		return board[i][j];
	}
	
	/**
		Fires a shot on the grid
	*/
	public boolean shot(int i, int j)
	{
		int sqr = this.getGridVal(i,j);
		
		
		String output = ("Shot at " + i + "," +j + " value of square is " + sqr);
		
		boolean hit = false;
		
		
		
		switch (sqr)
		{
		case 0: hit= false; output =("Shot at " + i + "," +j + " MISS" + " value of square is " + sqr); this.update(i,j,1); break;
		case 1: hit= false; output =("Shot at " + i + "," +j + " INVALID shot already taken here" + " value of square is " + sqr); break;
			
		case 2: minesweeper.scoreHit();
			
				if (minesweeper.isSunk()== true)
					output =("Shot at " + i + "," +j + " HIT & SUNK Minesweeper" + " value of square is " + sqr);
								
				else if(minesweeper.isSunk()== false)
				output =("Shot at " + i + "," +j + " HIT " + " value of square is " + sqr);
					this.update(i,j,(sqr - 8)); 
					hit= true;
		break;
		
			
		case 3: submarine.scoreHit(); 
		
				if (submarine.isSunk()== true)
					output =("Shot at " + i + "," +j + " HIT & SUNK Submarine" + " value of square is " + sqr);
			
				else if(submarine.isSunk()== false)
					output =("Shot at " + i + "," +j + " HIT " + " value of square is " + sqr);
					this.update(i,j,(sqr - 8)); 
					hit= true;
		break;		
		
		case 4: battleship.scoreHit(); 
		
				if (battleship.isSunk()== true)
					output =("Shot at " + i + "," +j + " HIT & SUNK Battleship" + " value of square is " + sqr);
			
				else if(battleship.isSunk()== false)
					output =("Shot at " + i + "," +j + " HIT " + " value of square is " + sqr);
					this.update(i,j,(sqr - 8)); 
					hit= true;
			break;
		
		
		case 5: aircraftCarrier.scoreHit(); 
		
				if (aircraftCarrier.isSunk()== true)
					output =("Shot at " + i + "," +j + " HIT & SUNK Aircraft Carrier" + " value of square is " + sqr);
			
				else if(aircraftCarrier.isSunk()== false)
					output =("Shot at " + i + "," +j + " HIT " + " value of square is " + sqr);
					this.update(i,j,(sqr - 8)); 
					hit= true;
		break;
		
		
		
		case 7: destroyer.scoreHit(); 
		
				if (destroyer.isSunk()== true)
					output =("Shot at " + i + "," +j + " HIT & SUNK destroyer" + " value of square is " + sqr);
			
				else if(destroyer.isSunk()== false)
					output =("Shot at " + i + "," +j + " HIT " + " value of square is " + sqr);
					this.update(i,j,(sqr - 8)); 
					hit= true;
		break;
		
		default: output =("Shot at " + i + "," +j + " ERROR shot is either already hit, or incorect" + " value of square is " + sqr); break; 
		}
		
		if (sqr <0)
			output =("Shot at " + i + "," +j + " ERROR location contains a sunk ship. Value of square is " + sqr);
			
		return hit;
	
	
	}
	
	/**
		Creates a string representation of the game board like so:
		|000|
		|050|
		|000|
		
		@return the string representation
	*/
	
	public String toString()
	{
		String r = "";
		for (int i = 0; i < userRow; i++) //change these to ROWS to use the default
		{
			
			r = r + "|";
			for (int j = 0; j < userColumn; j++)//change this to CoLumns for default
				r = r + board[i][j];
			r= r + "|\n";
		}
		return r;
	}
	
	/**
		Returns a string output of the status of the ships on the grid, whever they are
		sunk or not.
	*/
	public String printIsSunk()
	{
		String MINESWEEPER =("Minesweeper is intact");
		String SUBMARINE =("Submarine is intact");
		String DESTROYER =("Destroyer is intact");
		String BATTLESHIP =("Battleship is intact");
		String AIRCRAFTCARRIER =("Aircraft Carrier is intact");
			
		if (minesweeper.isSunk() == true)
			 MINESWEEPER =("Minesweeper is SUNK");
		
		if (submarine.isSunk() == true)
			 SUBMARINE =("Submarine is SUNK");
		
		if (destroyer.isSunk() == true)
			 DESTROYER =("Destroyer is SUNK");
		
		
		if (battleship.isSunk() == true)
			 BATTLESHIP =("Battleship is SUNK");
		
		if (aircraftCarrier.isSunk() == true)
			 AIRCRAFTCARRIER =("Aircraft Carrier is SUNK");

		
		return (MINESWEEPER + "\n" +SUBMARINE + "\n" +  DESTROYER + "\n" + BATTLESHIP+ "\n" +AIRCRAFTCARRIER); 
	}
	
	
	/**
		Returns the a string returning the value of each ship's IsPlaced flag. If a ship is placed this flag will 
		change to true and the this method will return a string confirming this. 
	*/
	public String printIsPlaced()
	{
		System.out.println("The following ships are now placed ");
		String Minesweeper="Minesweeper NOT Placed";
		String Destroyer="Destroyer NOT Placed";
		String Submarine="Submarine NOT placed";
		String Battleship="Battleship NOT placed";
		String AircraftCarrier="Aircraft Carrier NOT placed";
		
		if (minePlaced == true) 
			Minesweeper="Minesweeper has been placed";

		if (destPlaced == true) 
			Destroyer="Destroyer has been placed";
		
		if (subPlaced == true) 
			Submarine="Submarine has been placed";
		
		if (battlePlaced == true)
			Battleship="Battleship has been placed";
		
		if(airPlaced ==true)
			AircraftCarrier="Aircraft Carrier has been placed";
		
		return Minesweeper + "\n" + Destroyer + "\n" + Submarine + "\n" + Battleship + "\n" + AircraftCarrier;
	}
	

}
