package Battleships.Ships;

/*
 * Author: Michael
 * Created: 07 December 2004 15:37:59
 * Modified: 07 December 2004 15:37:59
 */

/**
 Fills 3 sequencial elements in the two dimensional array in either the same row or column with the a value.
 The value entered represents a Submarine on the grid.
 The elements will either be filled in row from left to right or a column from top to bottom

 @param i the row index to postion the values
 @param j the column postition to start placing the values from left to right
 @param s if this is an 0 a horizonal ship will be entered in the grid, if this parameter equals a 1 a vertical ship will be entered in the grid

 @throws InitialPositionOccupiedException if the inital poition is already occupied with a ship
 @throws PositionExceedsBoardException if the ship cannot fit onto the board 
 @throws PositionOccupiedException if any of the 3 elements about to be filled are already filled
 */

import java.io.Serializable;

import Battleships.Grid;

public class Submarine extends Ship implements Serializable {
	private int intactSegments = 3;

	public Submarine(Grid board, int i, int j, boolean isHorizontal) {

		super.placeShipOnGrid(board, i, j, isHorizontal,intactSegments);
	}

	public boolean isSunk() {
		return (intactSegments == 0);
	}

	public void scoreHit() {
		intactSegments--;

		if (intactSegments < 0)
			throw new IllegalArgumentException("Segments var is less than 0");

	}

}
