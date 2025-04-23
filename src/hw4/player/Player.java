package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.maze.CellComponents;
import hw4.maze.Row;

public class Player {

	private Row currentRow;
	private Cell currentCell;
	private Grid grid; // Added to access grid within Player

	public Player(Row currentRow, Cell currentCell, Grid grid) {
		this.currentRow = currentRow;
		this.currentCell = currentCell;
		this.grid = grid;
	}
	
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
	public Player(Row row, Cell cell) {
		
	}

	public Row getCurrentRow() {
		return currentRow;
	}

	public Cell getCurrentCell() {
		return currentCell;
	}

	public Grid getGrid() {
		return grid;
	}

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
}
