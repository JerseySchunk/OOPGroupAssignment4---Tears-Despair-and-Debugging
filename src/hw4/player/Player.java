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
	 * Moves the player
	 */
	public boolean move(Movement movement) {
		
		boolean moved = false;
		
		switch (movement) {
		
		
		case LEFT:
			if (currentCell.getLeft() == CellComponents.APERTURE) {
				int currentIndex = currentRow.getCells().indexOf(currentCell);
				if (currentIndex > 0) {
					currentCell = currentRow.getCells().get(currentIndex -1);
					moved = true;
				}
			}
			break;
			
			
		case RIGHT:
			if (currentCell.getRight() == CellComponents.APERTURE) {
				int currentIndex = currentRow.getCells().indexOf(currentCell);
				if (currentIndex > 0) {
					currentCell = currentRow.getCells().get(currentIndex +1);
					moved = true;
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
