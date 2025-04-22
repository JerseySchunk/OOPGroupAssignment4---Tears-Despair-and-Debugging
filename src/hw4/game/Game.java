package hw4.game;
import hw4.player.Movement;
import hw4.maze.Grid;
import hw4.player.Player;

public class Game {
    private final Grid grid;
    private final Player player;
    private boolean isGameOver;

    public Game(Grid grid, Player player) {
        this.grid = grid;
        this.player = player;
        this.isGameOver = false;
    }

    public void movePlayer(String direction) {
        if (isGameOver) return;
        {}}
      

    public boolean isOver() {
        return isGameOver;
    }
}