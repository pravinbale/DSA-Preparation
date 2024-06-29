package binarytree;



public class BinaryTree {
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

	public static void main(String[] args) {
		int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		System.out.println("Root of Tree : " + root.data);
	}

}
