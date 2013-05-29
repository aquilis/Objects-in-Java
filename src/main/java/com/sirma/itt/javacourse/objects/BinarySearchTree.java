package com.sirma.itt.javacourse.objects;

/**
 * A binary-search, self-balancing, heterogeneous tree accepting any type of
 * classes <T> implementing Comparable<T> and extending Number. The methods
 * available for the user are: inserting new elements on the proper position in
 * the tree, searching for elements in the tree and printing the tree on the
 * console using the depth-first search algorithm.
 * 
 * @version 1.7
 * @since 29/05/2013
 * @author v.tsonev
 */
@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class BinarySearchTree {

	private Node root;

	/**
	 * A nullary constructor.
	 */
	public BinarySearchTree() {
	}

	/**
	 * Adds a new element on the proper position in the tree.
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
		this.root = addElement(null, root, value);
		// comment/uncomment the line below to toggle the tree balancing
		root = rebalance(root);
	}

	/**
	 * Adds the given value on the proper position into the tree.
	 * 
	 * @param value
	 *            is the value to be added to the tree
	 * @param node
	 *            is the current node
	 * @param parent
	 *            is the node to become the parent of the newly inserted node
	 * @param <T>
	 *            is any class extending Number and implementing Comparable.
	 *            Designed for the java primitive wrapper classes
	 * @return a reference to the newly inserted node
	 */
	private <T extends Number & Comparable> Node addElement(Node parent,
			Node node, T value) {
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
				node.setLeft(addElement(node, node.left, value));
			} else if (compareTo > 0) {
				node.setRight(addElement(node, node.right, value));
			}
		}
		return node;
	}

	/**
	 * Returns the biggest element from the given subtree and then removes it.
	 * 
	 * @return the rightmost, biggest node in the subtree.
	 */
	private Node getBiggest(Node parent, Node node) {
		while (node.right != null) {
			parent = node;
			node = node.right;
		}
		if (((Comparable) node.value).compareTo(parent.value) < 0) {
			parent.left = node.left;
		} else if (((Comparable) node.value).compareTo(parent.value) > 0) {
			parent.right = node.left;
		}
		return node;
	}

	/**
	 * Returns the smallest element from the given subtree and then removes it.
	 * 
	 * @return the rightmost, biggest node in the subtree.
	 */
	private Node getSmallest(Node parent, Node node) {
		while (node.left != null) {
			parent = node;
			node = node.left;
		}
		if (((Comparable) node.value).compareTo(parent.value) < 0) {
			parent.left = node.right;
		} else if (((Comparable) node.value).compareTo(parent.value) > 0) {
			parent.right = node.right;
		}
		return node;
	}

	/**
	 * Rebalances the given subtree.
	 * 
	 * @param root
	 *            is the root node of the subtree to be rebalanced
	 * @return the new root node, placed on its proper position in the subtree
	 *         after the rebalancing is made
	 */
	private Node rebalance(Node root) {
		if (root == null) {
			return null;
		}

		int rWeight = 0;
		int lWeight = 0;
		if (root.right != null) {
			rWeight = root.right.getWeight();
		}
		if (root.left != null) {
			lWeight = root.left.getWeight();
		}

		while (Math.abs(lWeight - rWeight) > 1) {
			if (rWeight > lWeight) {
				Node smallest = getSmallest(root, root.right);
				// shift phase
				smallest.right = root.right;
				root.right = null;
				smallest.left = root;
				root = smallest;
				// update phase
				lWeight++;
				rWeight--;
			} else if (lWeight > rWeight) {
				Node biggest = getBiggest(root, root.left);
				// shift phase
				biggest.left = root.left;
				root.left = null;
				biggest.right = root;
				root = biggest;
				// update phase
				lWeight--;
				rWeight++;
			}
		}
		root.right = rebalance(root.right);
		root.left = rebalance(root.left);
		return root;
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
	 * Prints all tree nodes on the console.
	 */
	public void print() {
		print(this.root, "");
	}

	/**
	 * Using Pre-order traversal to print all nodes, adding a simple text after
	 * each one.
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
	 * the left. The node class is private and not designed to be freely
	 * instantiated by the user. It's part of the inner work of the tree class
	 * and has to be instantiated by it, and visible for it only.
	 */
	private class Node<T extends Number & Comparable<T>> implements
			Comparable<Node> {
		private final T value;
		private Node left;
		private Node right;
		private int weight;

		/**
		 * Constructs the node taking its initial value.
		 * 
		 * @param value
		 *            is the value to be inserted to the node
		 */
		public Node(T value) {
			this.value = value;
		}

		/**
		 * Gets the weight of the given node taking that of the children nodes
		 * recursively. If the node has no children, its weight is 1.
		 * 
		 * @return The weight of the node - the count of all children of the
		 *         subtree
		 */
		int getWeight() {
			int result = 1;
			if (right != null) {
				result += right.getWeight();
			}
			if (left != null) {
				result += left.getWeight();
			}
			this.weight = result;
			return this.weight;
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
