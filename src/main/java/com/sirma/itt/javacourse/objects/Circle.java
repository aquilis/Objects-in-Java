package com.sirma.itt.javacourse.objects;

/**
 * Implementing a geometric circle.
 */
@SuppressWarnings("unused")
public class Circle extends Figure {

	private final int radius;

	/**
	 * 2 parameters constructor.
	 * 
	 * @param origin
	 *            is a Point instance to be the origin of the figure
	 * @param radius
	 *            is the radius of the sphere
	 */
	public Circle(Point origin, int radius) {
		super(origin);
		this.radius = radius;
	}

	/**
	 * Default constructor. Sets all values to 0.
	 */
	public Circle() {
		super(new Point(0, 0));
		this.radius = 0;
	}

	@Override
	public void draw() {

	}
}
