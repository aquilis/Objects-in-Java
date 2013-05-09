package com.sirma.itt.javacourse.objects;

/**
 * Implemets a geometric line.
 */
public class Line extends Figure {

	@SuppressWarnings("unused")
	private final Point end;

	/**
	 * 3 parameters constructor.
	 * 
	 * @param origin
	 *            is a Point instance to be the origin of the figure
	 * @param x2
	 *            is the x of the end point of the line
	 * @param y2
	 *            is the y of the end point of the line
	 */
	public Line(Point origin, int x2, int y2) {
		super(origin);
		this.end = new Point(x2, y2);
	}

	/**
	 * Default constructor. Sets all values to 0.
	 */
	public Line() {
		super(new Point(0, 0));
		this.end = new Point(0, 0);
	}

	@Override
	public void draw() {

	}

}
