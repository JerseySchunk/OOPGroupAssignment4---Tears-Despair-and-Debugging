package hw4.maze;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Cell> cells;  // List to store the cells in this row

    // Constructor to initialize an empty row
    public Row() {
        this.cells = new ArrayList<>();  // Initialize the cells list
    }

    // Constructor to initialize row with a list of cells
    public Row(List<Cell> cells) {
        this.cells = cells;
    }

    // Method to add a Cell to the row
    public void add(Cell cell) {
        this.cells.add(cell);  // Adds a cell to the list
    }

    // Getter for cells list
    public List<Cell> getCells() {
        return cells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell cell : cells) {
            sb.append(cell.toString()).append(" ");  // Append the string representation of each cell
        }
        return sb.toString();
    }

	public void setCells(ArrayList<Cell> cellList) {

		
	}
}
