package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.maze.CellComponents;
import hw4.maze.Row;

public class Player {

	//Stores the position of the player in the grid
	private Row currentRow;
	private Cell currentCell;
	
	//
	public Player(Row currentRow, Cell currentCell) {
		this.currentRow = currentRow;
		this.currentCell = currentCell;
	}

	public Row getCurrentRow() {
		return currentRow;
	}

	public Cell getCurrentCell() {
		return currentCell;
	}

	/**
	 * Moves the player using a boolean value to see if something is blocking the movement.
	 * 
	 * 4 types of movement options
	 * UP, DOWN, LEFT, RIGHT
	 * example use Movement.LEFT
	 * @return true if the move was possible otherwise false
	 */
	public boolean move(Movement movement) {
		
		boolean moved = false;
		int currentIndex = currentRow.getCells().indexOf(currentCell);
		
		switch (movement) {
		
		case UP:
			if (currentCell.getUp() == CellComponents.APERTURE) {
				
			}
		case DOWN:
		/**
		 * Checks if the left of the Cell has a space
		 * Then it checks the position of the player to see if it's on the very left
		 * If it is on the very left wall it can't more left again
		 * If not it can move left by moving down one on the index
		 */
		case LEFT:
			if (currentCell.getLeft() == CellComponents.APERTURE) {
				if(currentIndex > 0) {
					currentCell = currentRow.getCells().get(currentIndex -1);
					moved = true;
				}
			}
			break;
			
		/**
		* Checks if the right of the Cell has a space
		* Then it checks the position of the player to see if it's on the very right
		* If it is on the very right wall it can't more right again
		* If not it can move right by moving up one on the index
		*/			
		case RIGHT:
			if (currentCell.getRight() == CellComponents.APERTURE) {
				if(currentIndex < currentRow.getCells().size() - 1) {
					currentCell = currentRow.getCells().get(currentIndex + 1);
				}
			}
			break;
			
		}
		return moved;
	}
	
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}
}
