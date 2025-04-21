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

	@Override
	public String toString() {
		return "Player [currentRow=" + currentRow + ", currentCell=" + currentCell + "]";
	}
	
}
