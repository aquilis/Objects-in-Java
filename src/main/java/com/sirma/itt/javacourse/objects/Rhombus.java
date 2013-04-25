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
	 * @param x
	 *            is the x of the figure origin
	 * @param y
	 *            is the y of the figure origin
	 * @param sideA
	 *            is the length of side A in pixels
	 * @param angleA
	 *            s the length of side B in pixels
	 */
	public Rhombus(int x, int y, int sideA, int angleA) {
		super(x, y, sideA);
		this.angleA = angleA;
	}

	/**
	 * default constructor.
	 */
	public Rhombus() {
		super(0, 0, 0);
		this.angleA = 0;
	}

	@Override
	public void draw() {
	}
}
