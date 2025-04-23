package hw4.game;

import hw4.player.Movement;
import hw4.player.Player;
import hw4.maze.Grid;
import hw4.maze.Row;

public class Game {
    private final Grid grid;
    private final Player player;
    private boolean isGameOver;

    public Game(Grid grid, Player player) {
        this.grid = grid;
        this.player = player;
        this.isGameOver = false;
    }

    public Game(Grid grid2) {
		this.grid = null;
		this.player = null;
    }

	public Game(int i) {
		this.grid = null;
		this.player = null;
		
	}

	public void movePlayer(String direction) {
        if (isGameOver) return;

        try {
            // Convert input direction to Movement enum
            Movement move = Movement.valueOf(direction.toUpperCase());
            
            // Move the player and print the grid
            boolean moved = player.move(move, grid);
            printGrid();

            // Check if the player has reached the exit
            if (moved && isExit(player.getCurrentRow(), getPlayerCol()) && move == Movement.LEFT) {
                System.out.println("Agent escaped through the EXIT! 🎉");
                isGameOver = true;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid move! Please enter: UP, DOWN, LEFT, or RIGHT.");
        }
    }

    public boolean isOver() {
        return isGameOver;
    }

    // Helper method to print the current state of the grid
    private void printGrid() {
        for (Row row : grid.getRows()) {
            for (var cell : row.getCells()) {
                if (row == player.getCurrentRow() && cell == player.getCurrentCell()) {
                    System.out.print("A ");  // A for Agent
                } else if (cell.getLeft() == hw4.maze.CellComponents.EXIT) {
                    System.out.print("E ");  // E for Exit
                } else {
                    System.out.print("S ");  // S for Space
                }
            }
            System.out.println();
        }
    }

    // Helper method to check if the current position is the exit
    private boolean isExit(Row playerRow, int col) {
        return playerRow.getCells().get(col).getLeft() == hw4.maze.CellComponents.EXIT;
    }

    // Helper method to get the player's column index
    private int getPlayerCol() {
        return player.getCurrentRow().getCells().indexOf(player.getCurrentCell());
    }

	public Object play(Movement down, Player player2) {
		return null;
	}

	public Object getGrid() {
		return null;
	}

	public void setGrid(Object object) {
		
	}

	public Grid createRandomGrid(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}