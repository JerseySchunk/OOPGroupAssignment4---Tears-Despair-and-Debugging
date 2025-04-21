package hw4.maze;

public class Cell {

	private CellComponents up;
	private CellComponents down;
	private CellComponents left;
	private CellComponents right;
	
	/**
	 * Constructs a Cell with the given components for each direction
	 * If a direction is null, it defaults to CellComponents.Wall
	 * 
	 * @author Jersey Schunk
	 * 
	 * @param up the component on the top side of the cell
	 * @param down the component on the bottom side of the cell
	 * @param left the component on the left side of the cell
	 * @param right the component on the right side of the cell
	 */
	
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down){
		
		if(left != null) {
			this.left = left;
		}else {
			this.left = CellComponents.WALL;
		}
		
		if(right != null) {
			this.right = right;
		}else {
			this.right = CellComponents.WALL;
		}
		
		if(up != null) {
			this.up = up;
		}else {
			this.up = CellComponents.WALL;
		}
		
		if(down != null){
			this.down = down;
		}else {
			this.down = CellComponents.WALL;
		}
		
	}
	
	/**
	 * Gets the component on the left side of the cell
	 * 
	 * @return the left side
	 */
	
	public CellComponents getLeft() {
		return left;
	}
	
	/**
	 * Gets the component on the right side of the cell
	 * 
	 * @return the right side
	 */
	public CellComponents getRight() {
		return right;
	}
	
	/**
	 * Gets the component on the top side of the cell
	 * 
	 * @return the top side
	 */
	public CellComponents getUp() {
		return up;
	}
	
	/**
	 * Gets the component on the bottom side of the cell
	 * 
	 * @return the bottom side
	 */
	
	public CellComponents getDown() {
		return down;
	}
	
	
	/**
	 * Sets the component on the left side of the cell
	 * Does nothing if the argument is null
	 * 
	 * @param left the new left side
	 */
	public void setLeft(CellComponents left) {
		this.left = (left != null) ? left : CellComponents.WALL;
	}
	
	/**
	 * Sets the component on the right side of the cell
	 * Does nothing if the argument is null
	 * 
	 * @param right the new right side
	 */
	public void setRight(CellComponents right) {
		this.right = (right != null) ? right : CellComponents.WALL;
		}
	
	/**
	 * Sets the component on the top side of the cell
	 * Does nothing if the argument is null
	 * 
	 * @param up the new top side
	 */
	public void setUp(CellComponents up) {
		this.up = (up != null) ? up : CellComponents.WALL;
	}
	
	/**
	 * Sets the component on the bottom side of the cell
	 * Does nothing if the argument is null
	 * 
	 * @param down the new bottom side
	 */
	public void setDown(CellComponents down) {
		this.down = (down != null) ? down : CellComponents.WALL;
	}
	
	/**
	 * Returns a string representation of the cell, showing its directional composition
	 * 
	 * @return a string describing the parts of the cell.
	 */
	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
}
