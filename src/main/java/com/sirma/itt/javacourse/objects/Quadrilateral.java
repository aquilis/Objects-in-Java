package com.sirma.itt.javacourse.objects;

/**
 * Implemets a geometric quadriliteral.
 * 
 * @author vtsonev
 */
@SuppressWarnings("unused")
public class Quadrilateral extends Parallelogram {

	private final int sideC;
	private final int sideD;

	/**
	 * @param x
	 *            is the x of the figure origin
	 * @param y
	 *            is the y of the figure origb
	 * @param sideA
	 *            is the length of side A in pixels
	 * @param sideB
	 *            is the length of side B in pixels
	 * @param sideC
	 *            is the length of side C in pixels
	 * @param sideD
	 *            is the length of side D in pixels
	 * @param angleA
	 *            is the angle of edge A in degrees
	 */
	public Quadrilateral(int x, int y, int sideA, int sideB, int sideC,
			int sideD, int angleA) {
		super(x, y, sideA, sideB, angleA);
		this.sideC = sideC;
		this.sideD = sideD;
	}

	/**
	 * default constructor.
	 */
	public Quadrilateral() {
		super(0, 0, 0, 0, 0);
		this.sideC = 0;
		this.sideD = 0;
	}

	@Override
	public void draw() {
	}

}
