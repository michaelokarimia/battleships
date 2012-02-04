/*
 * Author: Michael
 * Created: 05 December 2004 18:57:44
 * Modified: 05 December 2004 18:57:44
 */
import java.io.Serializable;

public class Mine extends Ship implements Serializable
{
	public Grid board = null;
	private int segments = 2;
		/**
		Fills 2 sequencial elements in the two dimensional array in either the same row or column with the a value.
		The value entered represents an Minesweeper on the grid.
		The elements will either be filled in row from left to right or a column from top to bottom
				
		@param i the row index to postion the values
		@param j the column postition to start placing the values from left to right
		@param s if this is 0 (zero) a horizonal ship will be entered in the grid, if this parameter equals 1 a vertical ship will be entered in the grid
		
		@throws InitialPositionOccupiedException if the inital poition is already occupied with a ship
		@throws PositionExceedsBoardException if the ship cannot fit onto the board 
		@throws PositionOccupiedException if any of the 2 elements about to be filled are already filled
		@throws IllegalArgumentException if the last parameter does not equal 1 or 0
		*/
	public Mine(Grid board, int i, int j, int s)
	{
		//Grid board;
		int userColumn = board.getWidth();
		int userRow = board.getLength();	
		
		boolean minePlaced = board.checkMinePlaced();
	
		if (minePlaced == true)
			System.out.println("Minesweeper already placed\n");
		
		if (s < 0 || s > 1)
			throw new IllegalArgumentException();
		
		if (minePlaced == false && s ==0)
		try
			{
			if(board.getGridVal(i,j) != 0)
				throw new InitialPositionOccupiedException();
			if(j+2>userColumn)
				throw new PositionExceedsBoardException();
		
			for(int c =j; c < j+2 ; c++)
				while(board.getGridVal(i,c) != 0)
				{	
					throw new PositionOccupiedException();
				}
			
			for(int c =j; c < j+2 ; c++)
				if(board.getGridVal(i,c) == 0)
				{
					board.set(i,c,2);
				
					board.setMinePlacedTrue();
				}
			
			}
		
			catch (PositionOccupiedException Exception)
			{
				System.out.println("Cannot place Minesweeper horizontally here, position is occupied \n");
			}
		
			catch (PositionExceedsBoardException Exception)
			{
				System.out.println("Cannot place Minesweeper horizontally here, ship will not fit on grid \n");
			}
		
			catch (InitialPositionOccupiedException Exception)
			{
				System.out.println("Horizontal Minesweeper cannot go here Initial point is already occupied \n");
			}
		
			else if(minePlaced == false && s ==1)
			{
			
			try{
				
				if(board.getGridVal(i,j) != 0)
					throw new PositionOccupiedException();
				if(i+2>userRow)
					throw new PositionExceedsBoardException();
		
				for(int r =i; r < i+2 ; r++)
					while(board.getGridVal(r,j) != 0)
					{
						throw new PositionOccupiedException();
					}
		
				for(int r =i; r < i+2 ; r++)
					if(board.getGridVal(r,j) == 0)
					{
						board.set(r,j,2);
				
					 	board.setMinePlacedTrue();
					}
			}
			
			
			catch (PositionOccupiedException Exception)
			{
				System.out.println("Cannot place vertical Minesweeper here, position is occupied \n");
			}
		
			catch (PositionExceedsBoardException Exception)
			{
				System.out.println("Cannot place vertical Minesweeper here, ship will not fit on grid \n");
			}
		
			catch (InitialPositionOccupiedException Exception)
			{
				System.out.println("Cannot place vertical Minesweeper here, Initial point is already occupied \n");
			}
		
		
		}	
	}
	
	/**
		Checks if the ship is sunk. 
		
		@returns a boolean true if it is sunk and false if it is not sunk
	*/
	public boolean checkSunk()
	{
		if (segments == 0)
			return true;
		else
			return false;
	}
	
	
	/**
		Reduces the number of undamaged segments of the ship by one when called.
		
	*/
	
	public void scoreHit()
	{
		segments = segments -1;
		
		if (segments < 0 )
			throw new IllegalArgumentException("Segments var is less than 0"); 		
			
	}

}
