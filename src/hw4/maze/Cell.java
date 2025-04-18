package hw4.maze;

public class Cell {

	private CellComponents up;
	private CellComponents down;
	private CellComponents left;
	private CellComponents right;
	
	public Cell(CellComponents up, CellComponents down, CellComponents left, CellComponents right){
		
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
		if(left != null) {
			this.left = left;
		}
	}
	
	public void setRight(CellComponents right) {
		if(right != null) {
			this.right = right;
			}
		}
	
	public void setUp(CellComponents up) {
		if(down != null) {
			this.up = up;
		}
	}
	
	public void setDown(CellComponents down) {
		if(down != null) {
			this.down = down;
		}
	}
}
