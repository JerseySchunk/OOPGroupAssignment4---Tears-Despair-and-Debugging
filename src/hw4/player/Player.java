package hw4.player;

import hw4.maze.Cell;
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
			if (currentRow.getCells().indexOf(currentCell) > 0) {
				Cell aboveCell = currentRow.getCells().get(currentIndex - 1);
				if (aboveCell.getUp() != CellComponents.WALL) {
					currentCell = aboveCell;
					moved = true;
				}
			}
			break;

			
		case DOWN:
			if(currentRow.getCells().indexOf(currentCell) < currentRow.getCells().size() - 1) {
				Cell belowCell = currentRow.getCells().get(currentIndex + 1);
				if (belowCell.getDown() != CellComponents.WALL) {
					currentCell = belowCell;
					moved = true;
				}				
			}
			
			
			
		/**
		 * Checks if the left of the Cell has a space
		 * Then it checks the position of the player to see if it's on the very left
		 * If it is on the very left wall it can't more left again
		 * If not it can move left by moving down one on the index
		 */
		case LEFT:
			if (currentCell.getLeft() != CellComponents.WALL) {
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
			if (currentCell.getRight() == CellComponents.WALL) {
				if(currentIndex < currentRow.getCells().size() - 1) {
					currentCell = currentRow.getCells().get(currentIndex + 1);
				}
			}
			break;
			
		}
		//Just to give a invalid move message to the player
		if (moved = false) {
			System.out.println("Invalid Move");
		}
		
		return moved;
	}
	
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}
}
