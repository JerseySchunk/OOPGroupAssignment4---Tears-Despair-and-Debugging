package hw4.maze;

import java.util.ArrayList;
import hw4.player.Player;

/**
 * Represents the entire maze structure used in TDD.
 * A grid is made up of multiple {@link Row} objects, and each row
 * contains several {@link Cell} objects. Together, they form a 2D maze that
 * the player can move through.
 *
 * Provides methods to access and update the grid's layout.
 * It also includes readable string formats of the grid.
 *
 * @author Jersey Schunk
 */
public class Grid {
    private ArrayList<Row> rows;

    public Grid(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public ArrayList<Row> getRows() {
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

    /**
     * Prints a more visual and compact representation of the grid
     * with the player's position marked as [P].
     * Cell contents are not printed in full detail, but as a visual grid.
     *
     * @param player the player whose position to highlight
     */
    public void printVisualGridWithPlayer(Player player) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows.size(); i++) {
            Row row = rows.get(i);
            sb.append("Row ").append(i).append(" | ");
            for (int j = 0; j < row.getCells().size(); j++) {
            	if (player.getRow() == row && player.getCol() == j) {
                    sb.append("[P]");
                } else {
                    sb.append("[ ]");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    /**
     * Legacy method to print the grid using row-specific string conversion.
     * Useful if rows implement special formatting with the player's position.
     *
     * @param player the player whose position to highlight
     */
    public void printGridWithPlayer(Player player) {
        StringBuilder sb = new StringBuilder();
        for (Row row : rows) {
            sb.append(row.toString1(player)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
