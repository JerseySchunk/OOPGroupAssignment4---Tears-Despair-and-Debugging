package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.maze.CellComponents;
import hw4.maze.Row;

/**
 * Represents a player navigating a grid-based maze.
 * Tracks the player's current position and allows movement in cardinal directions.
 */
public class Player {

	private Row currentRow;
	private Cell currentCell;
	private Grid grid;

	/**
	 * Constructs a player at a specific location with access to the maze grid.
	 * @param currentRow Row containing the player's cell
	 * @param currentCell Cell where the player is located
	 * @param grid Grid representing the maze
	 */
	public Player(Row currentRow, Cell currentCell, Grid grid) {
		this.currentRow = currentRow;
		this.currentCell = currentCell;
		this.grid = grid;
	}

	/**
	 * Updates the player's current row.
	 * @param currentRow New row
	 */
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

	/**
	 * Updates the player's current cell.
	 * @param currentCell New cell
	 */
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	/**
	 * Updates the grid reference.
	 * Use this only if the player was created without a grid.
	 * @param grid Maze grid
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	/**
	 * Returns the current row.
	 * @return Current row
	 */
	public Row getCurrentRow() {
		return currentRow;
	}

	/**
	 * Returns the current cell.
	 * @return Current cell
	 */
	public Cell getCurrentCell() {
		return currentCell;
	}

	/**
	 * Returns the maze grid.
	 * @return Grid
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * Attempts to move the player in a given direction.
	 * Movement only succeeds if no wall is blocking the path.
	 * @param direction Direction to move
	 * @return true if movement succeeded; false otherwise
	 */
	public boolean move(Movement direction) {
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

	public Row getRow() {
	    return currentRow;
	}

	public int getCol() {
	    return currentRow.getCells().indexOf(currentCell);
	}
}