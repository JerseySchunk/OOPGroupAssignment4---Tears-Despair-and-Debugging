package hw4.maze;

/**
 * An enumeration of possible components on each side of a cell within the maze.
 * 
 * @author Jersey Schunk
 * 
 * The valid components are:
 * @code WALL - Solid barrier, the agent cannot move through
 * @code APERTURE - Open path the agent can travel through
 * @code EXIT - Special escape point on the left of a leftmost cell
 */

public enum CellComponents {
	WALL,
	APERTURE,
	EXIT;
}
