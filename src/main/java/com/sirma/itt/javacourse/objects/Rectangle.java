package com.sirma.itt.javacourse.objects;

/**
 * Implemets a geometric rectangle.
 * 
 * @author vtsonev
 */
@SuppressWarnings("unused")
public class Rectangle extends Square {

	private final int sideB;

	/**
	 * @param origin
	 *            is a Point instance to be the origin of the figure
	 * @param sideA
	 *            is the length of side A i pixels
	 * @param sideB
	 *            is the lenth of side B in pixels
	 */
	public Rectangle(Point origin, int sideA, int sideB) {
		super(origin, sideA);
		this.sideB = sideB;
	}

	/**
	 * default constructor.
	 */
	public Rectangle() {
		super(new Point(0, 0), 0);
		this.sideB = 0;
	}

	@Override
	public void draw() {
	}
}
