package com.sirma.itt.javacourse.objects;

/**
 * Implemets a geometric square.
 * 
 * @author vtsonev
 */
public class Square extends Figure {

	@SuppressWarnings("unused")
	private final int sideA;

	/**
	 * @param x
	 *            is the x of the figure origin
	 * @param y
	 *            is the y of the figure origin
	 * @param sideA
	 *            is the length of side A in pixels
	 */
	public Square(int x, int y, int sideA) {
		super(x, y);
		this.sideA = sideA;
	}

	/**
	 * default constructor.
	 */
	public Square() {
		super(0, 0);
		this.sideA = 0;
	}

	@Override
	public void draw() {

	}

}
