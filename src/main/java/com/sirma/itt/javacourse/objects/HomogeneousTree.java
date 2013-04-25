package com.sirma.itt.javacourse.objects;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implementation of a homogeneous tree holding the same type of classes.
 * 
 * @param <T>
 *            is the data type that the tree will hold
 */
@SuppressWarnings("unused")
public class HomogeneousTree<T> {

	private final Node<T> root;

	/**
	 * A getter for the root node.
	 * 
	 * @return the root node of the current tree.
	 */
	public Node<T> getRoot() {
		return root;
	}

	/**
	 * one-parameter constructor.
	 * 
	 * @param value
	 *            is the value to be insterted to the root
	 */
	public HomogeneousTree(T value) {
		this.root = new Node<T>(value);
	}

	/**
	 * @param value
	 *            is the value to be insterted to the root node
	 * @param children
	 *            is an array of trees to be insterted as children of teh root
	 */

	@SafeVarargs
	public HomogeneousTree(T value, HomogeneousTree<T>... children) {
		this(value);
		for (HomogeneousTree<T> child : children) {
			this.root.addChild(child.getRoot());
		}
	}

	/**
	 * Using recursion, print the given Node and all its children.
	 * 
	 * @param root
	 *            is the node the be printed
	 * @param spaces
	 *            is the left print offset for the children
	 */
	private void print(Node<T> root, String spaces) {
		if (root == null) {
			return;
		}
		System.out.println(spaces + root);
		ArrayList<Node<T>> children = root.getChildren();
		if (children == null) {
			return;
		}
		for (Node<T> child : children) {
			print(child, spaces + " ");
		}
	}

	/**
	 * Begins recursion for printing all children of the tree.
	 */
	public void print() {
		print(this.root, "");
	}

	/**
	 * An inner class representing a single node from the tree.
	 * 
	 * @param <T>
	 *            is the data type that the node will hold
	 */
	@SuppressWarnings("hiding")
	private class Node<T> {
		private final T value;
		private ArrayList<Node<T>> children;
		/**
		 * One parameters constructor.
		 * 
		 * @param value
		 *            is the value to be insterted
		 */
		public Node(T value) {
			this.value = value;
		}

		/**
		 * A two-parameters constructor.
		 * 
		 * @param value
		 *            is the value to be insterted in the node.
		 * @param children
		 *            is an array of nodes to be inserted as children
		 */
		@SafeVarargs
		public Node(T value, Node<T>... children) {
			this.value = value;
			this.children = new ArrayList<Node<T>>(Arrays.asList(children));
		}

		/**
		 * A getter for the list of children nodes of the tree.
		 * 
		 * @return ArrayList of all children of this node.
		 */
		public ArrayList<Node<T>> getChildren() {
			return this.children;
		}

		/**
		 * Adds a new child node to the current node.
		 * 
		 * @param child
		 *            is the child to be added.
		 */
		public void addChild(Node<T> child) {
			if (this.children == null) {
				this.children = new ArrayList<Node<T>>();
			}
			this.children.add(child);
		}

		/**
		 * Overrides the toString method to print the value of the node.
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			return this.value.toString();
		}
	}
}
