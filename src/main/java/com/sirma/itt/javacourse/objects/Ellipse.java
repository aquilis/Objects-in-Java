package com.sirma.itt.javacourse.objects;

/**
 * Implemeting a geometric ellipse.
 */
@SuppressWarnings("unused")
public class Ellipse extends Circle {

	private final int semiMajorAxis;

	/**
	 * A 3 parameters constructor.
	 * 
	 * @param origin
	 *            is a Point instance to be the origin of the figure
	 * @param radius
	 *            is the radius (the semi-minor axis) of the ellipse
	 * @param semiMajorAxis
	 *            is the semi major axis of the circle
	 */
	public Ellipse(Point origin, int radius, int semiMajorAxis) {
		super(origin, radius);
		this.semiMajorAxis = semiMajorAxis;
	}

	/**
	 * Default constructor. Set all values to 0.
	 */
	public Ellipse() {
		super(new Point(0, 0), 0);
		this.semiMajorAxis = 0;
	}

	@Override
	public void draw() {
	}

}
