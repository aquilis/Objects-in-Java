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
	 * @param x
	 *            is the x of the figure origin
	 * @param y
	 *            is the y of the figure origin
	 * @param sideA
	 *            is the length of side A i pixels
	 * @param sideB
	 *            is the lenth of side B in pixels
	 */
	public Rectangle(int x, int y, int sideA, int sideB) {
		super(x, y, sideA);
		this.sideB = sideB;
	}

	/**
	 * default constructor.
	 */
	public Rectangle() {
		super(0, 0, 0);
		this.sideB = 0;
	}

	@Override
	public void draw() {
	}
}
