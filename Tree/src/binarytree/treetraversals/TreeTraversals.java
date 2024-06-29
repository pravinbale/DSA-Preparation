package binarytree.treetraversals;

import java.util.*;

public class TreeTraversals {
	private static int idx = -1;

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

	public Node buildTree(int[] nodes) {
		idx++;
		if (nodes[idx] == -1) {
			return null;
		}

		Node newNode = new Node(nodes[idx]);

		newNode.left = buildTree(nodes);
		newNode.right = buildTree(nodes);

		return newNode;
	}

	public void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	public void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	public void levelOrderTraversal(Node root) {

		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			Node currNode = queue.remove();

			if (currNode == null) {
				System.out.println();
				if (queue.isEmpty()) {
					break;
				} else {
					queue.add(null);
				}

			} else {
				System.out.print(currNode.data + " ");
				if (currNode.left != null) {
					queue.add(currNode.left);
				}
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
		TreeTraversals tree = new TreeTraversals();
		Node root = tree.buildTree(nodes);
		System.out.println("Root of Tree : " + root.data);
		System.out.println("\npreOrderTraversal: ");
		tree.preOrderTraversal(root);
		System.out.println("\ninOrderTraversal: ");
		tree.inOrderTraversal(root);
		System.out.println("\npostOrderTraversal: ");
		tree.postOrderTraversal(root);
		System.out.println("\nlevelOrderTraversal: ");
		tree.levelOrderTraversal(root);

	}
}
