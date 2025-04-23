package hw4.maze;

import java.util.ArrayList;

/**
 * Represents the entire maze structure used in TDD
 * 
 * A grid is made up of multiple {@link Row} objects, and each row
 * contains several {@link Cell} objects. Together, they form a 2D maze that
 * the player can move through.
 *
 *Provides methods to access and update the grid's layout.
 *It also includes readable string formats of the grid.
 *
 *@author
 *	Jersey Schunk
 */

public class Grid {
	private ArrayList<Row> rows;
	
	public Grid(ArrayList<Row> rows) {
		this.rows = rows;
	}
	
	public ArrayList<Row> getRows(){
		return rows;
	}
	
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Row row : rows) {
			sb.append(row.toString()).append("\n");
		}
		return sb.toString();
	}
}
