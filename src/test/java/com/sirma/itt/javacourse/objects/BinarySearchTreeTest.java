package com.sirma.itt.javacourse.objects;

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
	 * Adds some values to the tree and print it on the console to test its
	 * functionallity.
	 */
	@Test
	public final void testTree() {
		myTree.addElement(8);
		myTree.addElement(4);
		myTree.addElement(10);
		myTree.addElement(2);
		myTree.addElement(9);
		myTree.addElement(6);
		myTree.addElement(11);
		myTree.addElement(1);
		myTree.addElement(12);
		myTree.addElement(3);
		myTree.addElement(5);
		myTree.addElement(7);
		myTree.print();
	}

}
