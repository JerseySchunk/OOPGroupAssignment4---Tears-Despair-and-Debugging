package hw4.maze;

import java.util.ArrayList;

import hw4.player.Player;

public class Grid {
    private ArrayList<Row> rows;

    // Constructor expecting ArrayList<Row>
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

    public void printVisualGridWithPlayer(Player player) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows.size(); i++) {
            Row row = rows.get(i);
            for (int j = 0; j < row.getCells().size(); j++) {
                if (player.getCurrentRow() == i && player.getCurrentCol() == j) {
                    sb.append("[P]");  // Display player position
                } else {
                    sb.append(row.getCells().get(j).toVisualString());
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
