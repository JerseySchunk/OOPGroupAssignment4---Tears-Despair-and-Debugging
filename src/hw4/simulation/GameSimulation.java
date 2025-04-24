package hw4.simulation;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

import java.util.ArrayList;

public class GameSimulation {
    public static void main(String[] args) {

        Grid grid = createRandomGrid(5);
        Game game = new Game(grid);  // Pass the grid to the Game constructor

        // Create player at bottom-right cell
        Player player = new Player(
            grid.getRows().get(4).getCells().get(4),    // cell (
            grid                                       // grid
        );

        // Print initial grid with player
        System.out.println("Initial Grid:");
        grid.printVisualGridWithPlayer(player);  // Print grid with player

        // Simulate moves
        boolean moved;

        moved = game.play(Movement.UP, player);
        System.out.println("Move UP: " + moved);
        grid.printVisualGridWithPlayer(player);  // Print grid after move

        moved = game.play(Movement.LEFT, player);
        System.out.println("Move LEFT: " + moved);
        grid.printVisualGridWithPlayer(player);  // Print grid after move

        moved = game.play(Movement.UP, player);
        System.out.println("Move UP: " + moved);
        grid.printVisualGridWithPlayer(player);  // Print grid after move

        moved = game.play(Movement.LEFT, player);
        System.out.println("Move LEFT: " + moved);
        grid.printVisualGridWithPlayer(player);  // Print grid after move

        // Print final grid with player
        System.out.println("Final Grid:");
        grid.printVisualGridWithPlayer(player);  // Print final grid
    }

    public static Grid createRandomGrid(int size) {
        ArrayList<Row> rows = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Cell> cells = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                
                cells.add(new Cell(CellComponents.EMPTY, CellComponents.EMPTY, CellComponents.EMPTY, CellComponents.EMPTY));
            }
            rows.add(new Row(cells));  // Add a new Row with the list of cells
        }
        return new Grid(rows);  // Return the constructed Grid
    }
}
