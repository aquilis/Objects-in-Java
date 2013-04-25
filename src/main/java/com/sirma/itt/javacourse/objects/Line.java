package com.sirma.itt.javacourse.objects;

/**
 * Implemets a geometric line.
 */
public class Line extends Figure {

	@SuppressWarnings("unused")
	private final Point end;

	/**
	 * Four-parameters constructor.
	 * 
	 * @param x
	 *            is the x of the figure origin
	 * @param y
	 *            is the y of the figure origin
	 * @param x2
	 *            is the x of the end point of the line
	 * @param y2
	 *            is the y of the end point of the line
	 */
	public Line(int x, int y, int x2, int y2) {
		super(x, y);
		this.end = new Point(x2, y2);
	}

	/**
	 * Default constructor. Sets all values to 0.
	 */
	public Line() {
		super(0, 0);
		this.end = new Point(0, 0);
	}

	@Override
	public void draw() {

	}

}
