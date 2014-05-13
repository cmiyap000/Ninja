package com.doit.ninja;

import com.badlogic.gdx.math.Rectangle;

public class Block {

	// the colour of the block
	COLOURS colour;
	
	// rectangle for rendering purposes
	Rectangle rectangle;
	
	// hardcoded block size
	final int blockSize = 60;
		
	// the yoffset is used to simulate a block falling into place
	// causes block to be rendered above it's actual location
	int yOffset;

    // gravity
    private static final int GRAVITY = 35;
	
	public Block() {
		// set up the blocks rectangle and initial size
		rectangle = new Rectangle();
		
		rectangle.x = 0;
		rectangle.y = 0;
		
		yOffset = 0;

		rectangle.width = blockSize;
		rectangle.height = blockSize;
		
		// set colour to a random colour from the colours
		int c = (int)(Math.random() * 5);
		colour = COLOURS.values()[c];
	}
	
	// overloaded constructor to create a block of a certain colour
	// also used to create super blocks
	public Block(COLOURS colour) {
		this();
		this.colour = colour;
	}
	
	// called every frame on the block
	// used to apply gravity to the yOffset
	public void update() {
		if (yOffset > 0) {
			yOffset -= GRAVITY;
		}
		if (yOffset < 0) {
			yOffset = 0;
		}
	}
	
	public Rectangle getRectangle () {
		return rectangle;
	}
	
	public COLOURS getColour() {
		return colour;
	}
	
	public int getYOffset() {
		return yOffset;
	}
	
	public void setYOffset(int y) {
		yOffset = y;
	}
}
