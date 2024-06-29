package binarysearchtree;
import java.util.*;

public class BSTQuestions {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static Node insert(Node root, int val) {
		if (root == null) {
			root = new Node(val);
			return root;
		}

		if (root.data > val) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}

		return root;
	}

	public static void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	public static boolean search(Node root, int key) {
		if (root == null) {
			return false;
		}

		if (root.data > key) {
			return search(root.left, key);
		} else if (root.data == key) {
			return true;
		} else {
			return search(root.right, key);
		}
	}

	public static Node deleteNode(Node root, int val) {
		if (root.data > val) {
			root.left = deleteNode(root.left, val);
		} else if (root.data < val) {
			root.right = deleteNode(root.right, val);
		} else {
			// Root value matches with given value...

			// Case 1 :when node is leaf node

			if (root.left == null && root.right == null) {
				return null;
			}

			// Case 2: when node has single child...

			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			// Case 3: When node has both childs...

			Node IS = inorderSuccessor(root.right);
			root.data = IS.data;
			root.right = deleteNode(root.right, IS.data);
		}
		return root;
	}

	public static Node inorderSuccessor(Node root) {
		if (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static void printInRange(Node root, int X, int Y) {
		if (root == null) {
			return;
		}

		if (X <= root.data && root.data <= Y) {
			printInRange(root.left, X, Y);
			System.out.print(root.data + " ");
			printInRange(root.right, X, Y);
		} else if (Y <= root.data) {
			printInRange(root.left, X, Y);
		} else {
			printInRange(root.right, X, Y);
		}

	}

	public static void printRootToLeafPaths(Node root, ArrayList<Integer> path) {
		if (root == null) {
			return;
		}

		path.add(root.data);

		if (root.left == null && root.right == null) // leaf node
		{
			printPath(path);
		} else // non-leaf nodes
		{
			printRootToLeafPaths(root.left, path);
			printRootToLeafPaths(root.right, path);
		}
		path.remove(path.size() - 1);
	}

	public static void printPath(ArrayList<Integer> path) {
		for (int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i) + "->");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
		Node root = null;

		for (int i = 0; i < values.length; i++) {
			root = insert(root, values[i]);
		}

		System.out.println("BST InOrderTraversal: ");
		inOrderTraversal(root);
		System.out.println();

		if (search(root, 101)) {
			System.out.println("Key Found In Tree..!");
		} else {
			System.out.println("Key Not Found In Tree..!");
		}

//		deleteNode (root, 5);
		System.out.println("BST InOrderTraversal: ");
		inOrderTraversal(root);
		System.out.println();
		System.out.println("Print In Range: ");
		printInRange(root, 6, 11);
		System.out.println();
		printRootToLeafPaths(root, new ArrayList<Integer>());

	}

}
