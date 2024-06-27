package linkedlist;

public class SinglyLinkedList {
	private static Node head;
	private static int size;

	static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
			size++;
		}
	}

	public void addFirst(int data) {
		Node node = new Node(data);

		if (head == null) {
			head = node;
			return;
		}
		node.next = head;
		head = node;
	}

	public int deleteFirst() {
		if (head == null) {
			System.out.println("List Is Empty...!");
			return -1;
		}

		size--;

		if (head.next == null) {
			int data = head.data;
			head = null;
			return data;
		} else {
			int data = head.data;
			head = head.next;
			return data;
		}
	}

	public void addLast(int data) {
		Node node = new Node(data);

		if (head == null) {
			head = node;
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	public int deleteLast() {
		if (head == null) {
			System.out.println("List Is Empty...!");
			return -1;
		}

		size--;

		if (head.next == null) {
			int data = head.data;
			head = null;
			return data;
		}
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		int data = temp.next.data;
		temp.next = null;
		return data;
	}

	public void printList() {
		if (head == null) {
			System.out.println("List Is Empty...!");
			return;
		}

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "<-->");
			temp = temp.next;
		}
		System.out.println("NULL");

	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(5);
		list.addFirst(10);
		list.addFirst(15);
		list.addFirst(20);
		list.printList();
		list.addLast(25);
		list.addLast(30);
		list.printList();
		System.out.println(list.deleteFirst());
		System.out.println(list.deleteLast());
		System.out.println(list.size());
		System.out.println(list.size());
		list.printList();
		System.out.println(list.deleteLast());
		System.out.println(list.deleteLast());
		System.out.println(list.deleteLast());
		System.out.println(list.deleteLast());
		System.out.println(list.deleteLast());
		System.out.println(list.size());
	}

}
