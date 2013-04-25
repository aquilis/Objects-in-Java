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
	 * 5 - parameters constructor.
	 * 
	 * @param x
	 *            is the x of the figure origin
	 * @param y
	 *            is the y of the figure orign
	 * @param sideA
	 *            is the length of side A of the figure in pixels
	 * @param sideB
	 *            is the length of side B of the figure in pixels
	 * @param angleA
	 *            is the angle of edge A of the parallelogram
	 */
	public Parallelogram(int x, int y, int sideA, int sideB, int angleA) {
		super(x, y, sideA, sideB);
		this.angleA = angleA;
	}

	/**
	 * default constructor.
	 */
	public Parallelogram() {
		super(0, 0, 0, 0);
		this.angleA = 0;
	}

	@Override
	public void draw() {
	}
}