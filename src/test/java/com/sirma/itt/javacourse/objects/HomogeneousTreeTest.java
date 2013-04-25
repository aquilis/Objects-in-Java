package com.sirma.itt.javacourse.objects;

import org.junit.Test;

/**
 * Testing the homogeneous tree's functionallity.
 * 
 * @author vtsonev
 */
public class HomogeneousTreeTest {

	/**
	 * Construct a trest tree with a depth of 3 and add some ranodm values to
	 * it. Then test its print method using the depth-first search.
	 */
	@Test
	public void testTree() {
		HomogeneousTree<Integer> myTree = new HomogeneousTree<Integer>(1,
				new HomogeneousTree<>(2, new HomogeneousTree<>(22),
						new HomogeneousTree<>(222)), new HomogeneousTree<>(3,
						new HomogeneousTree<>(33), new HomogeneousTree<>(333)),
				new HomogeneousTree<>(4));
		myTree.print();
	}

}
