package com.sirma.itt.javacourse.objects;

/**
 * A class implementing a geometric arc. The arc is constructed using the
 * implementation of the circle, plus two angles (alpha, beta) representing what
 * part of the circle will be sliced to construct the geometric arc.
 */
@SuppressWarnings("unused")
public class Arc extends Circle {

	private final int angleAlpha;
	private final int angleBeta;

	/**
	 * 4 parameters constructor.
	 * 
	 * @param origin
	 *            is a Point instance to be the origin of the figure
	 * @param radius
	 *            is the radius of the base circle
	 * @param alpha
	 *            is the the first angle used to construct the arc
	 * @param beta
	 *            is the second angle used to construct the arc
	 */
	public Arc(Point origin, int radius, int alpha, int beta) {
		super(origin, radius);
		this.angleAlpha = alpha;
		this.angleBeta = beta;
	}

	/**
	 * Default constructor. Set all values to zero
	 */
	public Arc() {
		super(new Point(0, 0), 0);
		this.angleAlpha = 0;
		this.angleBeta = 0;
	}

	@Override
	public void draw() {
	}

}
