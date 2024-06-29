package binarytree;

public class BinaryTreeQuestions {
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

	public int countOfNodes(Node root) {
		if (root == null) {
			return 0;
		}

		int leftNodes = countOfNodes(root.left);
		int rightNodes = countOfNodes(root.right);

		return leftNodes + rightNodes + 1;
	}

	public int sumOfNodes(Node root) {
		if (root == null) {
			return 0;
		}

		int leftSum = sumOfNodes(root.left);
		int rightSum = sumOfNodes(root.right);

		return leftSum + rightSum + root.data;
	}

	public int heightOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);

		int myHeight = Math.max(leftHeight, rightHeight) + 1;
		return myHeight;
	}

	public int diameterOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		int diam1 = diameterOfTree(root.left);
		int diam2 = diameterOfTree(root.right);
		int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

		return Math.max(diam3, Math.max(diam1, diam2));
	}

	static class TreeInfo {
		int height;
		int diameter;

		TreeInfo(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
		}
	}

	public static TreeInfo diameter2(Node root) {
		if (root == null) {
			return new TreeInfo(0, 0);
		}
		TreeInfo left = diameter2(root.left);
		TreeInfo right = diameter2(root.right);

		int myHeight = Math.max(left.height, right.height) + 1;

		int diam1 = left.diameter;
		int diam2 = right.diameter;
		int diam3 = left.height + right.height + 1;

		int myDiameter = Math.max(Math.max(diam1, diam2), diam3);

		TreeInfo myInfo = new TreeInfo(myHeight, myDiameter);
		return myInfo;
	}

	public static void main(String[] args) {
		int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
		BinaryTreeQuestions tree = new BinaryTreeQuestions();
		Node root = tree.buildTree(nodes);
		System.out.println("Root of Tree : " + root.data);
		System.out.println("\nCount Of Nodes: " + tree.countOfNodes(root));
		System.out.println("\nSum Of Nodes: " + tree.sumOfNodes(root));
		System.out.println("\nHeight Of Tree: " + tree.heightOfTree(root));
		System.out.println("\nDiameter Of Tree Through Root Node: " + tree.diameterOfTree(root));
		System.out.println("\nDiameter Of Tree Through Root Node: " + diameter2(root).diameter);

	}
}
