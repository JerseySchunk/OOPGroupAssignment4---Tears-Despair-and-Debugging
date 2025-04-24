package hw4.simulation;

import hw4.game.Game;
import hw4.maze.Grid;
import hw4.player.Movement;
import hw4.player.Player;

public class GameSimulation {
    public static void main(String[] args) {
        // Initialize 
        Game game = new Game(5);  // Creates a 5x5 grid
        Grid grid = game.createRandomGrid(5);
        
        game.setGrid(grid);

        // Create player at bottom-right cell
        Player player = new Player(
            grid.getRows().get(4),                      // row
            grid.getRows().get(4).getCells().get(4),    // cell
            grid                                        // grid
        );

        // Print initial grid with player
        System.out.println("Initial Grid:");
        grid.printGridWithPlayer(player);

        // Simulate moves
        boolean moved;

        moved = game.play(Movement.UP, player);
        System.out.println("Move UP: " + moved);
        grid.printGridWithPlayer(player);

        moved = game.play(Movement.LEFT, player);
        System.out.println("Move LEFT: " + moved);
        grid.printGridWithPlayer(player);

        moved = game.play(Movement.UP, player);
        System.out.println("Move UP: " + moved);
        grid.printGridWithPlayer(player);

        moved = game.play(Movement.LEFT, player);
        System.out.println("Move LEFT: " + moved);
        grid.printGridWithPlayer(player);

        // Print final grid with player
        System.out.println("Final Grid:");
        grid.printGridWithPlayer(player);
    }
}
