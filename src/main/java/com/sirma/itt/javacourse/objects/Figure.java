package com.sirma.itt.javacourse.objects;

/**
 * Base class for all figures. Has origin point only.
 * 
 */
public abstract class Figure {

	private Point origin;

	/**
	 * abstract method that draws the concrete figure onto the screen.
	 */
	public abstract void draw();

	/**
	 * A two-parameters constructor.
	 * 
	 * @param x
	 *            is the x of the figure origin.
	 * @param y
	 *            is the y of the figure origin.
	 */
	public Figure(int x, int y) {
		this.origin.setX(x);
		this.origin.setY(y);
	}

	/**
	 * default constructor. Set coordinates to 0.
	 */
	public Figure() {
		this.origin.setX(0);
		this.origin.setY(0);
	}
}
