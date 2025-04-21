package hw4.maze;

import java.util.ArrayList;

/**
 * A row in a maze, composed of a list of {@link Cell} objects.
 * A Row object provides access to and modification of its list of cells.
 */

public class Row {
	private ArrayList<Cell> cells;
	
	/**
	 * Constructs a Row with the provided list of cells
	 * @param cells an {@code ArrayList} of {@code Cell} objects that make up the row
	 */
	
	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
	/**
	 * Returns the list of cells in this row
	 * @return an {@code ArrayList} of {@code Cell} objects
	 */
	
	public ArrayList<Cell> getCells(){
		return cells;
	}
	
	/**
	 * Sets the cells of this row to the provided list
	 * 
	 * @param cells an {@code ArrayList} of {@code Cell} objects to set for this row
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
	/**
	 * Returns a string representation of the row.
	 * 
	 * @return a string in the format "Row [cells=...]" representing the row
	 */
	
	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}

}
