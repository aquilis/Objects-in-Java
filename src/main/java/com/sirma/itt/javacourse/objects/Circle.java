package com.sirma.itt.javacourse.objects;

/**
 * Implementing a geometric circle.
 * 
 * @author vtsonev.
 */
@SuppressWarnings("unused")
public class Circle extends Figure {

	private final int radius;

	/**
	 * 3 - parameters constructor.
	 * 
	 * @param x
	 *            is the x of the figure origin
	 * @param y
	 *            is the y of the figure origin
	 * @param radius
	 *            is the radius of the sphere
	 */
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	/**
	 * Default constructor. Set all values to 0.
	 */
	public Circle() {
		super(0, 0);
		this.radius = 0;
	}

	/**
	 * Draws the circle. Not yet implemented. {@inheritDoc}
	 */
	@Override
	public void draw() {

	}

}
