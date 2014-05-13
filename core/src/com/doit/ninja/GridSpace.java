package com.doit.ninja;

public class GridSpace {
	
	// reference to the grid itself
	Grid grid;
	
	/* the gridSpace's position on the grid */
	int gridPosX;
	int gridPosY;
	
	/* the block the grid is holding */
	Block currentBlock;
	
	public GridSpace(Grid grid) {
		this.grid = grid;
	}
	
	/* tell the gridSpace what block it holds */
	public void setBlock(Block block) {
		
		this.currentBlock = block;
		
		// set the blocks relevant location -- hardcoded
		currentBlock.getRectangle().x = 30 + (60 * gridPosX);
		currentBlock.getRectangle().y = 800 - (60*9) - 220 + (60 * gridPosY);
		
		// set the offset so the block falls a bit if dropping down a space
		currentBlock.setYOffset(currentBlock.getYOffset() + 60);
	}
	
	/*
	 * check if the space currently holds a block
	 */
	public boolean hasBlock() {
		if (currentBlock == null) {
			return false;
		}
		return true;
	}
	
	/*
	 * check if the gridspace is at the bottom
	 */
	public boolean onBottomRow () {
		if (getY() == 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * delete block on the space
	 * sets reference to null
	 */
	public void deleteBlock() {
		currentBlock = null;
	}
	
	/*
	 * spawn a random coloured block on the space
	 */
	public void spawnBlock() {
		setBlock(new Block());
	}
	
	/*
	 * spawn a specific block on the space
	 */
	public void spawnBlock(COLOURS type) {
		setBlock(new Block(type));
	}
	
	/*
	 * spawn a random super block on the space
	 */
	public void spawnSuperBlock() {
		COLOURS colour = COLOURS.SUPER_2WAYS;
		int c = (int)(Math.random() * 3);
		if (c == 0) {
			colour = COLOURS.SUPER_HORIZONTAL;
		} else if (c == 1) {
			colour = COLOURS.SUPER_VERTICAL;
		} else if (c == 2) {
			colour = COLOURS.SUPER_2WAYS;
		}
		setBlock(new Block(colour));
	}
	
	
	/*
	 * checking if the gridspace has spaces on whatever sides
	 */
	public boolean hasGridSpaceLeft() {
		if (getX() == 0) {
			return false;
		}
		return true;
	}
	public boolean hasGridSpaceRight() {
		if (getX() == 6) {
			return false;
		}
		return true;
	}
	public boolean hasGridSpaceAbove() {
		if (getY() == 8) {
			return false;
		}
		return true;
	}
	public boolean hasGridSpaceBelow() {
		if (getY() == 0) {
			return false;
		}
		return true;
	}
	
	/*
	 * get the grid the gridspace is on
	 */
	public Grid getGrid() {
		return grid;
	}

	/*
	 * getting gridpsaces to any side
	 */
	public GridSpace getGridSpaceLeft() {
		return grid.getGridSpace(gridPosX - 1, gridPosY);
	}
	public GridSpace getGridSpaceRight() {
		return grid.getGridSpace(gridPosX + 1, gridPosY);
	}
	public GridSpace getGridSpaceAbove() {
		return grid.getGridSpace(gridPosX, gridPosY + 1);
	}
	public GridSpace getGridSpaceBelow() {
		return grid.getGridSpace(gridPosX, gridPosY - 1);
	}
	
	public int getX() { return gridPosX; }
	
	public int getY() { return gridPosY; }
	
	public Block getBlock() {
		return currentBlock;
	}
	
	/*
	 * set the gridpspaces location on the grid
	 */
	public void setGridPosX(int gridPosX) {
		this.gridPosX = gridPosX;
	}	
	public void setGridPosY(int gridPosY) {
		this.gridPosY = gridPosY;
	}
}
