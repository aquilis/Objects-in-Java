package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
/**
 * Testing the methods and functionallity of the binary search tree.
 *
 * @author Black_eagle
 */
public class BinarySearchTreeTest {
	private BinarySearchTree<Integer> myTree;
	
	/**
	 * Initiate the tree with a root node having the value of Integer(3).
	 */
	@Before
	public final void initTree() {
		myTree = new BinarySearchTree<Integer>(3);
	}

	/**
	 * Add some values to the tree, test the print method and the method for
	 * seeking certain values in the binary tree.
	 */
	@Test
	public final void testTree() {
		myTree.addElement(5);
		myTree.addElement(1);
		myTree.addElement(6);
		myTree.addElement(9);
		myTree.addElement(0);
		assertTrue(myTree.find(6) != null);
		assertTrue(myTree.find(11) == null);
		myTree.print();
	}

}
