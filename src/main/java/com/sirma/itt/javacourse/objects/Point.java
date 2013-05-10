package com.sirma.itt.javacourse.objects;

/**
 * Implemets a geometric 2-dimensional point.
 */
public class Point {

	private int x;
	private int y;

	/**
	 * @return x coord. of the point
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @return t coord. of the point.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * @param x
	 *            the x of the point.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y
	 *            is the y coord. of the point
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @param x
	 *            is the x coord. of the point
	 * @param y
	 *            is the y coord. of the point.
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * default constructor. Set x and y of the point to 0
	 */
	public Point() {
	}
}