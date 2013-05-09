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
	 * @param origin
	 *            is a Point instance to be the origin of the figure
	 * @param sideA
	 *            is the length of side A in pixels
	 */
	public Square(Point origin, int sideA) {
		super(origin);
		this.sideA = sideA;
	}

	/**
	 * default constructor.
	 */
	public Square() {
		super(new Point(0, 0));
		this.sideA = 0;
	}

	@Override
	public void draw() {

	}

}
