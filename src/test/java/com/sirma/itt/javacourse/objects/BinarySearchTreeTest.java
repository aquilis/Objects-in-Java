package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the functionallity of the AVL tree.
 */
public class BinarySearchTreeTest {
	private BinarySearchTree myTree;
	
	/**
	 * Initialises the tree.
	 */
	@Before
	public final void initTree() {
		myTree = new BinarySearchTree();
	}

	/**
	 * Adds some values to the tree, tests the print method and the method for
	 * seeking certain values in the tree.
	 */
	@Test
	public final void testTree() {
		myTree.addElement(1);
		myTree.addElement(2);
		myTree.addElement(3);
		myTree.addElement(5);
		myTree.addElement(4);
		myTree.addElement(6);
		assertTrue(myTree.find(6) != null);
		assertTrue(myTree.find(11) == null);
		System.out.println("Balanced AVL tree, values 1 to 6:");
		myTree.print();
	}

}
