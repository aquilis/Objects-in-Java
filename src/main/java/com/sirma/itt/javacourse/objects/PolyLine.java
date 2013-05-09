package com.sirma.itt.javacourse.objects;

import java.util.ArrayList;

/**
 * Implemets a random poly line constructed by a sequence of arcs and lines.
 */
@SuppressWarnings("unused")
public class PolyLine extends Figure {

	/**
	 * A sequence of arc and line objects to construct the poly line.
	 */
	private final ArrayList<Figure> listArcsLines;

	/**
	 * Iterates through all array elements to make sure there are no other types
	 * of figures excpet Arcs and Lines. If other types are found,
	 * IllegalArgumentException is thrown.
	 * 
	 * @param arcsLines
	 *            is the input array list to validate
	 */
	private void validateInputFigures(ArrayList<Figure> arcsLines) {
		for (Figure fig : arcsLines) {
			if ((!fig.getClass().equals(Arc.class))
					&& (!fig.getClass().equals(Line.class))) {
				throw new IllegalArgumentException(
						"\nThe poly line can be constructed of arcs and lines only.");
			}
		}
	}

	/**
	 * 2 parameters constructor.
	 * 
	 * @param origin
	 *            is a Point instance to be the orgin of the figure
	 * @param arcsLines
	 *            is an arraylist consisting of arc and line instances that will
	 *            construct the polyline.
	 */
	public PolyLine(Point origin, ArrayList<Figure> arcsLines) {
		super(origin);
		validateInputFigures(arcsLines);
		this.listArcsLines = arcsLines;
	}

	@Override
	public void draw() {

	}
}
