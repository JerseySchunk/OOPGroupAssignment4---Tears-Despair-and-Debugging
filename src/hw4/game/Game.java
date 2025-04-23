package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Game {
	private Grid grid;

	public Game(Grid grid) {
		this.grid = grid;
	}

	public Game(int gridSize) {
		this.grid = createRandomGrid(gridSize);
	}

	public boolean play(Movement movement, Player player) {
		if (movement == null || player == null) {
			return false;
		}

		Cell currentCell = player.getCurrentCell();
		Row currentRow = player.getCurrentRow();
		Grid grid = player.getGrid();
		int rowIndex = grid.getRows().indexOf(currentRow);
		int colIndex = currentRow.getCells().indexOf(currentCell);

		switch (movement) {
			case UP:
				if (rowIndex > 0 && (currentCell.getUp() == CellComponents.APERTURE || currentCell.getUp() == CellComponents.EXIT)) {
					Row newRow = grid.getRows().get(rowIndex - 1);
					player.setCurrentRow(newRow);
					player.setCurrentCell(newRow.getCells().get(colIndex));
					return true;
				}
				break;
			case DOWN:
				if (rowIndex < grid.getRows().size() - 1 && (currentCell.getDown() == CellComponents.APERTURE || currentCell.getDown() == CellComponents.EXIT)) {
					Row newRow = grid.getRows().get(rowIndex + 1);
					player.setCurrentRow(newRow);
					player.setCurrentCell(newRow.getCells().get(colIndex));
					return true;
				}
				break;
			case LEFT:
				if (colIndex > 0 && (currentCell.getLeft() == CellComponents.APERTURE || currentCell.getLeft() == CellComponents.EXIT)) {
					player.setCurrentCell(currentRow.getCells().get(colIndex - 1));
					return true;
				}
				break;
			case RIGHT:
				if (colIndex < currentRow.getCells().size() - 1 && (currentCell.getRight() == CellComponents.APERTURE || currentCell.getRight() == CellComponents.EXIT)) {
					player.setCurrentCell(currentRow.getCells().get(colIndex + 1));
					return true;
				}
				break;
		}

		return false;
	}
	
	@Override
	public String toString() {
	    return grid.toString(); 
	}
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Grid createRandomGrid(int size) {
		if (size < 3 || size > 7) return null;

		ArrayList<Row> rows = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			ArrayList<Cell> cells = new ArrayList<>();
			for (int j = 0; j < size; j++) {
				CellComponents left = (j == 0) ? CellComponents.WALL : randomComponent();
				CellComponents right = (j == size - 1) ? CellComponents.WALL : randomComponent();
				CellComponents up = (i == 0) ? CellComponents.WALL : randomComponent();
				CellComponents down = (i == size - 1) ? CellComponents.WALL : randomComponent();
				cells.add(new Cell(left, right, up, down));
			}
			rows.add(new Row(cells));
		}

		// Randomly place EXIT on the other end 
		int exitRow = random.nextInt(size);
		rows.get(exitRow).getCells().get(0).setLeft(CellComponents.EXIT);

		return new Grid(rows);
	}

	private CellComponents randomComponent() {
		return Math.random() < 0.5 ? CellComponents.APERTURE : CellComponents.WALL;
	}
}