package hw4.game;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.player.Movement;
import hw4.player.Player;

public class Game {

    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public boolean play(Movement movement, Player player) {
        if (player == null || movement == null) return false;

        Cell currentCell = player.getCurrentCell();
        int row = player.getCurrentRow();
        int col = player.getCurrentCol();

        boolean isValidMove = false;

        switch (movement) {
            case UP:
                if (row > 0 && currentCell.getUp() != CellComponents.WALL) {
                    player.moveUp();
                    isValidMove = true;
                }
                break;
            case DOWN:
                if (row < grid.getRows().size() - 1 && currentCell.getDown() != CellComponents.WALL) {
                    player.moveDown();
                    isValidMove = true;
                }
                break;
            case LEFT:
                if (col > 0 && currentCell.getLeft() != CellComponents.WALL) {
                    player.moveLeft();
                    isValidMove = true;
                }
                break;
            case RIGHT:
                if (col < grid.getRows().get(row).getCells().size() - 1 && currentCell.getRight() != CellComponents.WALL) {
                    player.moveRight();
                    isValidMove = true;
                }
                break;
        }

        return isValidMove;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public String toString() {
        return "Game [grid=" + grid + "]";
    }
}
