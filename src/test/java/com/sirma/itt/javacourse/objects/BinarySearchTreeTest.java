package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
/**
 * Testing the methods and functionallity of the binary search tree.
 */
public class BinarySearchTreeTest {
	private BinarySearchTree myTree;
	
	/**
	 * Initiate the tree with a root node having the value of Integer(3).
	 */
	@Before
	public final void initTree() {
		myTree = new BinarySearchTree(7);
	}

	/**
	 * Adds some values to the tree, test the print method and the method for
	 * seeking certain values in the binary tree.
	 */
	@Test
	public final void testTree() {
		myTree.addElement(5);
		myTree.addElement(8);
		myTree.addElement(555);
		myTree.addElement(3.14);
		myTree.addElement(1);
		myTree.addElement(-45);
		myTree.addElement(-576.67);
		assertTrue(myTree.find(-576.67) != null);
		assertTrue(myTree.find(11) == null);
		myTree.print();
	}

}
