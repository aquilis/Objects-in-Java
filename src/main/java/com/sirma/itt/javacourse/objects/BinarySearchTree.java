package com.sirma.itt.javacourse.objects;

/**
 * A binary-search, self-balancing (AVL), heterogeneous tree accepting any type
 * of classes <T> implementing Comparable<T> and extending Number. The methods
 * available for the user are: inserting new elements on the proper position in
 * the tree, searching for elements in the tree and printing the tree on the
 * console using the depth-first search algorithm.
 * 
 * @version 1.5
 * @since 15/05/2013
 * @author v.tsonev
 */
@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class BinarySearchTree {

	private Node root;

	/**
	 * Constructs the tree, setting its root node to null.
	 */
	public BinarySearchTree() {
		this.root = null;
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
		if (value == null) {
			throw new IllegalArgumentException(
					"Can't insert a null value into the tree");
		}
		this.root = addElement(root, value);
	}

	/**
	 * Adds the given value on the proper position into the binary search tree.
	 * 
	 * @param value
	 *            is the value to be added to the tree
	 * @param node
	 *            is the current node
	 * @param <T>
	 *            is any class extending Number and implementing Comparable.
	 *            Designed for the java primitive wrapper classes
	 * @return a reference to the newly inserted node, or to the newly placed
	 *         node on that position, if the tree gets rebalanced
	 */
	private <T extends Number & Comparable> Node addElement(Node node, T value) {
		if (node == null) {
			return new Node(value);
		} else {
			// Typecast the input value and the current node's value to Double
			// before making the comparison, in order to avoid
			// ClassCastException and information loss.
			Double valCompareTo = node.value.doubleValue();
			Double toAdd = value.doubleValue();
			int compareTo = toAdd.compareTo(valCompareTo);
			if (compareTo < 0) {
				node.setLeft(addElement(node.left, value));
			} else if (compareTo > 0) {
				node.setRight(addElement(node.right, value));
			}
		}
		// Compute heights of the left and right subtrees
		// and rebalance the tree if needed
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		if (Math.abs(leftHeight - rightHeight) == 2) {
			return balance(node);
		} else {
			node.resetHeight();
			return node;
		}
	}

	/**
	 * Returns the height of the given AVL subtree. Height is the count of all
	 * children of the subtree.
	 * 
	 * @param tree
	 *            An AVL subtree.
	 * @return The height of the AVL subtree.
	 */

	private static int getHeight(Node tree) {
		if (tree == null)
			return -1;
		else
			return tree.height;
	}

	/**
	 * Calculates what rebalancing has to be made to the tree, and performs the
	 * appropiate operation.
	 * 
	 * @param node
	 *            The AVL subtree to be balanced.
	 * @return The balanced subAVL tree.
	 */

	private Node balance(Node node) {
		int rHeight = getHeight(node.right);
		int lHeight = getHeight(node.left);

		if (rHeight > lHeight) {
			Node rightChild = node.right;
			int rrHeight = getHeight(rightChild.right);
			int rlHeight = getHeight(rightChild.left);
			if (rrHeight > rlHeight)
				return rotateRight(node);
			else
				return rotateDoubleRight(node);
		} else {
			Node leftChild = node.left;
			int llHeight = getHeight(leftChild.left);
			int lrHeight = getHeight(leftChild.right);
			if (llHeight > lrHeight)
				return rotateLeft(node);
			else
				return rotateDoubleLeft(node);
		}
	}

	/**
	 * Performs a right rotation to the subtree. The right child of the node
	 * becomes the new root and the old root node gets attached as its left
	 * child.
	 * 
	 * @param node
	 *            The AVL tree wih an RR imbalance.
	 * @return The balanced AVL tree.
	 */

	private Node rotateRight(Node node) {
		Node rightChild = node.right;
		Node rightLeftChild = rightChild.left;
		rightChild.left = node;
		node.right = rightLeftChild;
		node.resetHeight();
		rightChild.resetHeight();
		return rightChild;
	}

	/**
	 * Performs a double right rotation. The right subtree of the tree is
	 * left-heavy, so the method balances the entite subtree.
	 * 
	 * @param node
	 *            The AVL tree with an RL imbalance.
	 * @return The balanced AVL tree.
	 */

	private Node rotateDoubleRight(Node node) {
		Node root = node;
		Node rNode = root.right;
		Node rlNode = rNode.left;
		Node rlrTree = rlNode.right;
		Node rllTree = rlNode.left;

		// Build the restructured tree
		rNode.left = rlrTree;
		root.right = rllTree;
		rlNode.left = root;
		rlNode.right = rNode;

		// Adjust heights
		rNode.resetHeight();
		root.resetHeight();
		rlNode.resetHeight();

		return rlNode;
	}

	/**
	 * Performs a left rotation to the subtree. The left child of the node
	 * becomes the new root and the old root node gets attached as its right
	 * child.
	 * 
	 * @param node
	 *            The AVL tree with an LL imbalance.
	 * @return The balanced AVL tree.
	 */

	private Node rotateLeft(Node node) {
		Node leftChild = node.left;
		Node lrTree = leftChild.right;
		leftChild.right = node;
		node.left = lrTree;
		node.resetHeight();
		leftChild.resetHeight();
		return leftChild;
	}

	/**
	 * Performs a double left rotation to the subtree. The left subtree of the
	 * given node is right-heavy, so the method balances the entire subtree.
	 * 
	 * @param node
	 *            The AVL tree with an LR imbalance.
	 * @return The new root node of the balanced AVL tree.
	 */

	private Node rotateDoubleLeft(Node node) {
		Node root = node;
		Node lNode = root.left;
		Node lrNode = lNode.right;
		Node lrlTree = lrNode.left;
		Node lrrTree = lrNode.right;

		// Build the restructured tree
		lNode.right = lrlTree;
		root.left = lrrTree;
		lrNode.left = lNode;
		lrNode.right = root;

		// Adjust heights
		lNode.resetHeight();
		root.resetHeight();
		lrNode.resetHeight();

		return lrNode;
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
	 * right child nodes only. The right child's key value is always bigger than
	 * the left.
	 */
	private class Node<T extends Number & Comparable<T>> implements
			Comparable<Node> {
		private final T value;
		private Node parent;
		private Node left;
		private Node right;
		private int height;

		/**
		 * Constructs the node taking its value.
		 * 
		 * @param value
		 *            is the value to be inserted to the node
		 */
		public Node(T value) {
			this.value = value;
			this.height = 0;
		}

		/**
		 * Recalculates the height if the left or right subtrees have changed.
		 */
		void resetHeight() {
			int leftHeight = BinarySearchTree.getHeight(left);
			int rightHeight = BinarySearchTree.getHeight(right);
			height = 1 + Math.max(leftHeight, rightHeight);
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
		 * A setter for the left child node.
		 * 
		 * @param left
		 *            is the node to be inserted as a left child
		 */
		public void setLeft(Node left) {
			this.left = left;
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
		 * A setter for the right child node.
		 * 
		 * @param right
		 *            is the node to be inserted as a right child
		 */
		public void setRight(Node right) {
			this.right = right;
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
