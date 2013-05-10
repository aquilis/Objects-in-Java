package com.sirma.itt.javacourse.objects;

/**
 * A binary-search, heterogeneous tree accepting any type of classes <T>
 * implementing Comparable<T> and extending Number. Has methods for inserting
 * new elements on the proper position in the tree, searching for elements in
 * the tree and printing the tree on the console using the depth-first search
 * algorithm.
 * 
 * @version 1.3
 * @since 10/05/2013
 * @author v.tsonev
 */
@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class BinarySearchTree {
	/**
	 * Enumerable type telling the recursive methods if we are ataching left or
	 * right node.
	 */
	private enum Position {
		RIGHT, LEFT
	}

	private final Node root;

	/**
	 * Constructs the tree taking the value of the root node.
	 * 
	 * @param a
	 *            is the value to be inserted at the root node
	 * @param <T>
	 *            is any class extending Number and implementing Comparable.
	 *            Designed for the java primitive wrapper classes
	 */
	public <T extends Number & Comparable<T>> BinarySearchTree(T a) {
		this.root = new Node(a);
	}

	/**
	 * Adds a new element on the proper position in the tree. Begins the
	 * recursive algorithm with the root node.
	 * 
	 * @param value
	 *            is the value to be inserted in the tree
	 * @param <T>
	 *            is any class extending Number and implementing Comparable.
	 *            Designed for the java primitive wrapper classes
	 */
	public <T extends Number & Comparable<T>> void addElement(T value) {
		// Typecast the input value and the current root value to Double
		// before making the comparison, in order to avoid
		// ClassCastException and information loss.
		Double valCompareTo = this.root.value.doubleValue();
		Double toAdd = value.doubleValue();
		int compare = toAdd.compareTo(valCompareTo);
		if (compare > 0) {
			addElement(value, null, this.root, Position.RIGHT);
		} else {
			addElement(value, null, this.root, Position.LEFT);
		}
	}

	/**
	 * Adds the given value on the proper position into the binary search tree.
	 * 
	 * @param value
	 *            is the value to be added to the tree
	 * @param parent
	 *            is the parent node of the new node
	 * @param node
	 *            is the current node
	 * @param nodePos
	 *            tells the method if we are attaching left or right child
	 * @param <T>
	 *            is any class extending Number and implementing Comparable.
	 *            Designed for the java primitive wrapper classes
	 */
	private <T extends Number & Comparable> void addElement(T value,
			Node parent, Node node, Position nodePos) {
		if (node == null) {
			if (nodePos == Position.LEFT) {
				parent.left = new Node(value);
				parent.left.setParent(parent);
			} else if (nodePos == Position.RIGHT) {
				parent.right = new Node(value);
				parent.right.setParent(parent);
			}
		} else {
			// Typecast the input value and the current node's value to Double
			// before making the comparison, in order to avoid
			// ClassCastException and information loss.
			Double valCompareTo = node.value.doubleValue();
			Double toAdd = value.doubleValue();
			if (toAdd.compareTo(valCompareTo) < 0) {
				addElement(value, node, node.left, Position.LEFT);
			} else if (toAdd.compareTo(valCompareTo) > 0) {
				addElement(value, node, node.right, Position.RIGHT);
			}
		}
	}

	/**
	 * Finds if the given value is present in the tree.
	 * 
	 * @param value
	 *            is the value to search for
	 * @param <T>
	 *            is any class extending Number and implementing Comparable.
	 *            Designed for the java primitive wrapper classes
	 * @return a reference to the node with the given value or null if no such
	 */
	public <T extends Number & Comparable> Node find(T value) {
		Node node = this.root;
		while (node != null) {
			Double valCompareTo = node.value.doubleValue();
			Double toAdd = value.doubleValue();
			int compare = toAdd.compareTo(valCompareTo);
			if (compare < 0) {
				node = node.left;
			} else {
				if (compare > 0) {
					node = node.right;
				} else {
					// we found it
					break;
				}
			}
		}
		return node;
	}

	/**
	 * Prints all tree nodes on the console. Begin the recursion with the root
	 * node.
	 */
	public void print() {
		print(this.root, "");
	}

	/**
	 * Prints all tree nodes using recursion and the depth-first search
	 * algorithm.
	 * 
	 * @param node
	 *            is the curent node to be printed
	 * @param spaces
	 *            is the left offset to print on the console and a text telling
	 *            the user if it's a right or left child node
	 */
	private void print(Node node, String spaces) {
		if (node == null) {
			return;
		}
		System.out.println(spaces + node.toString());
		print(node.left, spaces + node + " left: ");
		print(node.right, spaces + node + " right: ");
	}

	/**
	 * A binary node. The primary carrier of data in the tree. Has left and
	 * right child nodes only. The right child is always bigger than the left.
	 */
	private class Node<T extends Number & Comparable<T>> implements
			Comparable<Node> {
		private final T value;
		private Node parent;
		private Node left;
		private Node right;

		/**
		 * Constructs the node taking its value.
		 * 
		 * @param value
		 *            is the value to be inserted to the node
		 */
		public Node(T value) {
			this.value = value;
		}

		/**
		 * A getter method for the parent node.
		 * 
		 * @return reference to the parent node.
		 */
		public Node getParent() {
			return parent;
		}

		/**
		 * A setter method for the parent node.
		 * 
		 * @param parent
		 *            is the new parent node to be set.
		 */
		public void setParent(Node parent) {
			this.parent = parent;
		}

		/**
		 * A getter method for the left child node.
		 * 
		 * @return the left node
		 */
		public Node getLeft() {
			return left;
		}

		/**
		 * A getter method for the right child node.
		 * 
		 * @return the right node
		 */
		public Node getRight() {
			return right;
		}

		/**
		 * Overrides the toString method to return the value of the node.
		 * 
		 * @return the value of the node.
		 */
		@Override
		public String toString() {
			return this.value.toString();
		}

		/**
		 * Overrides the compareTo method to compare the values of the nodes.
		 * 
		 * @param other
		 *            is the other node to compare to
		 * @return 0 equal
		 */
		@Override
		public int compareTo(Node other) {
			return this.value.compareTo((T) other.value);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result
					+ ((parent == null) ? 0 : parent.hashCode());
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (left == null) {
				if (other.left != null)
					return false;
			} else if (!left.equals(other.left))
				return false;
			if (parent == null) {
				if (other.parent != null)
					return false;
			} else if (!parent.equals(other.parent))
				return false;
			if (right == null) {
				if (other.right != null)
					return false;
			} else if (!right.equals(other.right))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		/**
		 * Auto generated.
		 * 
		 * @return the outer type of the tree.
		 */
		private BinarySearchTree getOuterType() {
			return BinarySearchTree.this;
		}
	}

}
