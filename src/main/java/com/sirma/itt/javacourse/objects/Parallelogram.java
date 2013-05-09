package com.sirma.itt.javacourse.objects;

/**
 * Implemets a geometric parallelogram.
 * 
 * @version 16/4/2013
 * @author vtsonev
 */
public class Parallelogram extends Rectangle {

	@SuppressWarnings("unused")
	private final int angleA;

	/**
	 * 4 parameters constructor.
	 * 
	 * @param origin
	 *            is a Point instance to be the origin of the figure
	 * @param sideA
	 *            is the length of side A of the figure in pixels
	 * @param sideB
	 *            is the length of side B of the figure in pixels
	 * @param angleA
	 *            is the angle of edge A of the parallelogram
	 */
	public Parallelogram(Point origin, int sideA, int sideB, int angleA) {
		super(origin, sideA, sideB);
		this.angleA = angleA;
	}

	/**
	 * default constructor.
	 */
	public Parallelogram() {
		super(new Point(0, 0), 0, 0);
		this.angleA = 0;
	}

	@Override
	public void draw() {
	}
}