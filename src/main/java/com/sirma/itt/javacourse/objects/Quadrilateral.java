package com.sirma.itt.javacourse.objects;

/**
 * Implemets a geometric quadriliteral.
 */
@SuppressWarnings("unused")
public class Quadrilateral extends Parallelogram {

	private final int sideC;
	private final int sideD;

	/**
	 * @param origin
	 *            is a Point instance to be the origin of the figure
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
	public Quadrilateral(Point origin, int sideA, int sideB, int sideC,
			int sideD, int angleA) {
		super(origin, sideA, sideB, angleA);
		this.sideC = sideC;
		this.sideD = sideD;
	}

	/**
	 * default constructor.
	 */
	public Quadrilateral() {
		super(new Point(0, 0), 0, 0, 0);
		this.sideC = 0;
		this.sideD = 0;
	}

	@Override
	public void draw() {
	}

}
