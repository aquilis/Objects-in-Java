package com.sirma.itt.javacourse.objects;


import java.util.ArrayList;

import org.junit.Test;

/**
 * Testing the PolyLine's class functionallity.
 */
public class PolyLineTest {
	@SuppressWarnings("unused")
	private PolyLine myPolyLine;
	private final ArrayList<Figure> myList = new ArrayList<Figure>();

	/**
	 * A regular test with an input list of only arcs and lines. If no exception
	 * is thrown, the test is passed.
	 */
	@Test
	public void testRegular() {
		myList.clear();
		myList.add(new Arc());
		myList.add(new Line());
		myList.add(new Arc());
		myPolyLine = new PolyLine(new Point(0, 0), myList);
	}

	/**
	 * Testing the polyline's constructor with an input array of invalid
	 * figures. If IllegalArgumentException is thrown, the test is passed.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		myList.clear();
		myList.add(new Circle());
		myList.add(new Parallelogram());
		myList.add(new Rhombus());
		myPolyLine = new PolyLine(new Point(0, 0), myList);
	}
}
