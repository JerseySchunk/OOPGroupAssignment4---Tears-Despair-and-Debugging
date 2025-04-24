package hw4.maze;

public class Cell {

	private CellComponents up;
	private CellComponents down;
	private CellComponents left;
	private CellComponents right;

	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down){
		this.left = (left != null) ? left : CellComponents.WALL;
		this.right = (right != null) ? right : CellComponents.WALL;
		this.up = (up != null) ? up : CellComponents.WALL;
		this.down = (down != null) ? down : CellComponents.WALL;
	}

	public CellComponents getLeft() {
		return left;
	}

	public CellComponents getRight() {
		return right;
	}

	public CellComponents getUp() {
		return up;
	}

	public CellComponents getDown() {
		return down;
	}

	public void setLeft(CellComponents left) {
		this.left = (left != null) ? left : CellComponents.WALL;
	}

	public void setRight(CellComponents right) {
		this.right = (right != null) ? right : CellComponents.WALL;
	}

	public void setUp(CellComponents up) {
		this.up = (up != null) ? up : CellComponents.WALL;
	}

	public void setDown(CellComponents down) {
		this.down = (down != null) ? down : CellComponents.WALL;
	}

	@Override
	public String toString() {
		return "Cell [left="  + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}

	/**
	 * Returns a simple visual representation of the cell.
	 * Used for grid printing.
	 * 
	 * @return a string like "[ ]"
	 */
	public String toVisualString() {
		return "[ ]";
	}
}
