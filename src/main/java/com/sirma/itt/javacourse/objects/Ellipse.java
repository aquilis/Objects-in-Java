package com.sirma.itt.javacourse.objects;

/**
 * Implemeting a geometric ellipse.
 * 
 * @author vtsonev
 */
@SuppressWarnings("unused")
public class Ellipse extends Figure {

	private final int semiMajorAxis;
	private final int semiMinorAxis;

	/**
	 * A 4 parameters constructor.
	 * 
	 * @param x
	 *            is the x of the figure origin
	 * @param y
	 *            is the y of the figure origin
	 * @param semiMajorAxis
	 *            is the semi major axis of the circle
	 * @param semiMinorAxis
	 *            is the semi minor axis of the circle
	 */
	public Ellipse(int x, int y, int semiMajorAxis, int semiMinorAxis) {
		super(x, y);
		this.semiMajorAxis = semiMajorAxis;
		this.semiMinorAxis = semiMinorAxis;
	}

	/**
	 * Default constructor. Set all values to 0.
	 */
	public Ellipse() {
		super(0, 0);
		this.semiMajorAxis = 0;
		this.semiMinorAxis = 0;
	}

	/**
	 * Draws the ellipse. Not yet implemented. {@inheritDoc}
	 */
	@Override
	public void draw() {
	}

}
