package com.sirma.itt.javacourse.objects;

/**
 * Implemets a geometric rhombus.
 * 
 * @author vtsonev
 */
public class Rhombus extends Square {

	@SuppressWarnings("unused")
	private final int angleA;

	/**
	 * @param origin
	 *            is a Point instance to be the orgin of the figure
	 * @param sideA
	 *            is the length of side A in pixels
	 * @param angleA
	 *            s the length of side B in pixels
	 */
	public Rhombus(Point origin, int sideA, int angleA) {
		super(origin, sideA);
		this.angleA = angleA;
	}

	/**
	 * default constructor.
	 */
	public Rhombus() {
		super(new Point(0, 0), 0);
		this.angleA = 0;
	}

	@Override
	public void draw() {
	}
}
