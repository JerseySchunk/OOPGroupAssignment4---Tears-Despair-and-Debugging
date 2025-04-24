package hw4.maze;

import java.util.ArrayList;

import hw4.player.Player;

/**
 * A row in a maze, composed of a list of {@link Cell} objects.
 * A Row object provides access to and modification of its list of cells.
 * 
 * @author Jersey Schunk
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
	 * Returns a string representation of the row, highlighting the player's position.
	 * If a player is at a cell in this row, that cell is marked with asterisks.
	 * 
	 * @param player The player whose position will be highlighted
	 * @return a string in the format "Row [cells=...]" representing the row
	 */
	public String toString(Player player) {
		StringBuilder sb = new StringBuilder("Row [cells=[");
		for (Cell cell : cells) {
			if (player.getCurrentCell() == cell) {
				sb.append("*").append(cell.toString()).append("*");  // Mark player's position
			} else {
				sb.append(cell.toString());
			}
			sb.append(", ");
		}
		// Remove trailing comma and space, if present
		if (sb.length() > 2) {
			sb.setLength(sb.length() - 2);
		}
		sb.append("]]");
		return sb.toString();
	}

	/**
	 * Returns a string representation of the row (default, without the player's position).
	 * 
	 * @return a string in the format "Row [cells=...]" representing the row
	 */
	public String toString1(Player player) {
	    StringBuilder sb = new StringBuilder("Row [cells=");
	    for (Cell cell : cells) {
	        if (player.getCurrentCell() == cell) {
	            sb.append("[PLAYER] ");
	        } else {
	            sb.append(cell.toString()).append(" ");
	        }
	    }
	    sb.append("]");
	    return sb.toString();
	}
}
	
