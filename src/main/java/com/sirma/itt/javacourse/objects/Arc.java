package com.sirma.itt.javacourse.objects;

/**
 * A class implementing a geometric arc.
 */
@SuppressWarnings("unused")
public class Arc extends Circle {

	private int angle;
	private final int length;

	/**
	 * Four-parameters constructor.
	 * 
	 * @param x
	 *            is x of the figure origin
	 * @param y
	 *            is the y of the figure origin
	 * @param radius
	 *            is the radius of the arc
	 * @param length
	 *            is the length of the arc
	 */
	public Arc(int x, int y, int radius, int length) {
		super(x, y, radius);
		this.length = length;
	}

	/**
	 * Default constructor. Set all values to zero
	 */
	public Arc() {
		super(0, 0, 0);
		this.length = 0;
	}

	/**
	 * Draws the arc. Not yet implemented. {@inheritDoc}
	 */
	@Override
	public void draw() {
	}

}
