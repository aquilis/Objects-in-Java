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
	 * Construct the figure with a specified origin point.
	 * 
	 * @param origin
	 *            is a Point instance to be the origin of the figure
	 */
	public Figure(Point origin) {
		this.origin = origin;
	}

	/**
	 * default constructor. Set coordinates to 0.
	 */
	public Figure() {
		this.origin.setX(0);
		this.origin.setY(0);
	}
}
