package stack;

public class StackUsingLinkedList {
	private static Node head;

	static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static boolean isEmpty() {
		return head == null;
	}

	public static void push(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return;
		}
		node.next = head;
		head = node;
	}

	public static int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow..!");
			return -1;
		}
		int data = head.data;
		head = head.next;
		return data;
	}

	public static int peek() {
		if (isEmpty()) {
			System.out.println("Stack Underflow..!");
			return -1;
		}
		return head.data;
	}

	public static void printStack() {
		if (isEmpty()) {
			System.out.println("Stack Underflow..!");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;

		}
	}

	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		printStack();
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(peek());
		System.out.println(pop());
		printStack();
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		// printStack ();
	}
}
