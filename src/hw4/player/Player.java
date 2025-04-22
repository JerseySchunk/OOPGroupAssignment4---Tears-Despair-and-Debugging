package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.maze.CellComponents;
import hw4.maze.Row;

public class Player {

	// Stores the position of the player in the grid
	private Row currentRow;
	private Cell currentCell;

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
	public boolean move(Movement direction, Grid grid) {

		boolean moved = false;
		int currentIndex = currentRow.getCells().indexOf(currentCell);
		int rowIndex = grid.getRows().indexOf(currentRow);

		switch (direction) {
			case UP:
				if (rowIndex > 0) {
					Row aboveRow = grid.getRows().get(rowIndex - 1);
					Cell aboveCell = aboveRow.getCells().get(currentIndex);
					if (aboveCell.getDown() != CellComponents.WALL) {
						currentRow = aboveRow;
						currentCell = aboveCell;
						moved = true;
					}
				}
				break;

			case DOWN:
				if (rowIndex < grid.getRows().size() - 1) {
					Row belowRow = grid.getRows().get(rowIndex + 1);
					Cell belowCell = belowRow.getCells().get(currentIndex);
					if (belowCell.getUp() != CellComponents.WALL) {
						currentRow = belowRow;
						currentCell = belowCell;
						moved = true;
					}
				}
				break;

			case LEFT:
				if (currentCell.getLeft() != CellComponents.WALL && currentIndex > 0) {
					currentCell = currentRow.getCells().get(currentIndex - 1);
					moved = true;
				}
				break;

			case RIGHT:
				if (currentCell.getRight() != CellComponents.WALL && currentIndex < currentRow.getCells().size() - 1) {
					currentCell = currentRow.getCells().get(currentIndex + 1);
					moved = true;
				}
				break;
		}

		if (!moved) {
			System.out.println("Invalid Move");
		}

		return moved;
	}

	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}
}

