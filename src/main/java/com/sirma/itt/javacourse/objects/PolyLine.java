package com.sirma.itt.javacourse.objects;

import java.util.ArrayList;

/**
 * Implemets a random poly line consisting of arcs and lines.
 * 
 * @author vtsonev
 */
@SuppressWarnings("unused")
public class PolyLine extends Figure {

	private final ArrayList<Line> myLines;
	private final ArrayList<Arc> myArcs;

	/**
	 * The constructor gets the x and y of the origin and takes a list of lines
	 * and a list of arcs to construct the poly line.
	 * 
	 * @param x
	 *            is the x of the figure origin.
	 * @param y
	 *            is the y of the figure origin
	 * @param myLines
	 *            is an array list of lines to be drawn as part of the poly line
	 * @param myArcs
	 *            is an array list of arcs to be drawn a a part of the poly line
	 */
	public PolyLine(int x, int y, ArrayList<Line> myLines, ArrayList<Arc> myArcs) {
		super(x, y);
		this.myLines = myLines;
		this.myArcs = myArcs;
	}

	@Override
	public void draw() {

	}
}
