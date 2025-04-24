package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.maze.Row;

public class Player {
    private int row;
    private int col;
    private Cell currentCell;

    public Player(int row, int col, Cell currentCell) {
        this.row = row;
        this.col = col;
        this.currentCell = currentCell;
    }

    public Player(Row row2, Cell cell, Grid grid) {
	
	}

	public Player(Cell cell, Grid grid) {
		
	}

	// Getter for the current row
    public int getCurrentRow() {
        return row;
    }

    // Getter for the current column
    public int getCurrentCol() {
        return col;
    }

    // Getter for the current cell 
    public Cell getCurrentCell() {
        return currentCell;
    }

    // Setters for row, column, and currentCell
    public void setCurrentRow(int row) {
        this.row = row;
    }

    public void setCurrentCol(int col) {
        this.col = col;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    // Movement methods
    public void moveUp() {
        this.row--;
    }

    public void moveDown() {
        this.row++;
    }

    public void moveLeft() {
        this.col--;
    }

    public void moveRight() {
        this.col++;
    }
}
