package com.sirma.itt.javacourse.objects;

/**
 * A binary-search tree accepting any types of classes implementing
 * Comparable<T>. Has methods for adding elements, inserting new elements on the
 * proper position in the tree, searching for elements in the tree and printing
 * the tree on the console using the depth-first search algorithm.
 * 
 * @param <T>
 *            is a class implementing the Comparable interface
 * @version 1.0
 * @author vtsonev
 */
@SuppressWarnings("unused")
public class BinarySearchTree<T extends Comparable<T>> {
	/**
	 * Enumerable type telling the method if we are ataching left or right node.
	 */
	private enum Position {
		RIGHT, LEFT
	}
	private final Node root;

	/**
	 * One-parameter constructor.
	 * @param a is the value to be inserted at the root node
	 */
	public BinarySearchTree(T a) {
		this.root = new Node(a);
	}

	/**
	 * Adding an element to the tree. Beginning the recursion with the root
	 * node.
	 *
	 * @param value
	 *            is the value to be inserted in the tree
	 */
	public void addElement(T value) {
		int compare = value.compareTo(this.root.value);
		if (compare > 0) {
			addElement(value, null, this.root, Position.RIGHT);
		} else {
			addElement(value, null, this.root, Position.LEFT);
		}
	}

	/**
	 * Recursive method adding the given value into the binary search tree.
	 * 
	 * @param value
	 *            is the value to be added to the tree
	 * @param parent
	 *            is the parent node of the new node
	 * @param node
	 *            is the current node
	 * @param nodePos
	 *            is telling the method if we are attaching left or right child
	 */
	private void addElement(T value, Node parent, Node node,
 Position nodePos) {
		if (node == null) {
			if (nodePos == Position.LEFT) {
				parent.left = new Node(value);
				parent.left.setParent(parent);
			} else if (nodePos == Position.RIGHT) {
				parent.right = new Node(value);
				parent.right.setParent(parent);

			}
		} else {
			if (value.compareTo(node.value) < 0) {
				addElement(value, node, node.left, Position.LEFT);
			} else if (value.compareTo(node.value) > 0) {
				addElement(value, node, node.right, Position.RIGHT);
			}
		}
	}

	/**
	 * Finds if the given value is present in the tree.
	 * 
	 * @param value
	 *            is the value to search for
	 * @return a reference to the node with the given value or null if no such
	 */
	public Node find(T value) {
		Node node = this.root;
		while (node != null) {
			int compare = value.compareTo(node.value);
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
	 * Printing all tree nodes using recursion and the depth-first search
	 * algorithm.
	 * 
	 * @param node
	 *            is the curent node to be printed
	 * @param spaces
	 *            is the left offset to print and a text telling the user if
	 *            it's a right or left child node
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
	 * A binary node. Has left and right child nodes only.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private class Node implements Comparable<Node> {
		private final T value;
		private Node parent;
		private Node left;
		private Node right;

		/**
		 * One-parameter constructor.
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
		 * Overriding the compareTo method to compare the values of the nodes.
		 * 
		 * @param other
		 *            is the other node to compare to
		 * @return 0 equal
		 */
		@Override
		public int compareTo(Node other) {
			return this.value.compareTo(other.value);
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
