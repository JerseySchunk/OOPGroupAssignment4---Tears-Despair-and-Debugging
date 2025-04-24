package hw4.game.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import hw4.game.Game;
import hw4.player.Movement;
import hw4.player.Player;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class GameTest {

    private Game game;
    private Player player;

    @BeforeEach
    public void setUp() {
        // Setup grid, cells, and player for testing
        Cell emptyCell = new Cell(CellComponents.EMPTY, CellComponents.EMPTY, CellComponents.EMPTY, CellComponents.EMPTY);
        
        // Construct rows and grid with multiple cells
        Row row = new Row(new ArrayList<>());
        row.add(emptyCell);
        row.add(emptyCell);
        row.add(emptyCell);

        ArrayList<Row> rows = new ArrayList<>();
        rows.add(row);
        rows.add(row);
        rows.add(row);  // Three rows for testing

        Grid grid = new Grid(rows);  // Pass the ArrayList<Row> to the constructor

        // Initialize player at (0,0) position
        player = new Player(0, 0, emptyCell);  
        game = new Game(grid);
    }

    @Test
    public void testValidMoveUp() {
        // Before moving up, player is at (0,0), so moving up should not be valid
        assertFalse(game.play(Movement.UP, player));  // Expecting false as player can't move up
    }

    @Test
    public void testValidMoveDown() {
        // Initially at (0,0), player can move down to (1,0) as there's space
        assertTrue(game.play(Movement.DOWN, player));
        assertEquals(1, player.getCurrentRow());  // Player should now be at row 1
    }

    @Test
    public void testInvalidMoveDown() {
        // Set player at the bottom row (2,0)
        player.moveDown();
        player.moveDown();
        
        // Player is at the last row now, so moving down should not be valid
        assertFalse(game.play(Movement.DOWN, player));
    }

    @Test
    public void testValidMoveLeft() {
        // Initially at (0,0), player can move left if there's no wall
        assertFalse(game.play(Movement.LEFT, player));  // Invalid as player is at column 0
    }

    @Test
    public void testValidMoveRight() {
        // Initially at (0,0), player can move right to (0,1)
        assertTrue(game.play(Movement.RIGHT, player));
        assertEquals(1, player.getCurrentCol());  // Player should now be at column 1
    }

    @Test
    public void testInvalidMoveRight() {
        // Move player to the rightmost column (0,2)
        player.moveRight();
        player.moveRight();

        // Now, player can't move right anymore
        assertFalse(game.play(Movement.RIGHT, player));
    }
}
