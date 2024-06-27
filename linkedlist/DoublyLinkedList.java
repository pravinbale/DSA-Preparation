package linkedlist;

public class DoublyLinkedList {
	private static Node head;
	private static Node tail;
	private static int size;

	static class Node {
		private int data;
		private Node next;
		private Node prev;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
			size++;
		}
	}

	public void addFirst(int data) {
		Node node = new Node(data);

		if (head == null && tail == null) {
			head = tail = node;
			return;
		}
		node.next = head;
		head.prev = node;
		head = node;
	}

	public int deleteFirst() {
		if (head == null && tail == null) {
			System.out.println("List Is Empty...!");
			return -1;
		}

		size--;

		if (head == tail) {
			int data = head.data;
			head = tail = null;
			return data;
		} else {
			int data = head.data;
			head = head.next;
			head.prev = null;
			return data;
		}
	}

	public void addLast(int data) {
		Node node = new Node(data);

		if (head == null && tail == null) {
			head = tail = node;
			return;
		}

		tail.next = node;
		node.prev = tail;
		tail = node;
	}

	public int deleteLast() {
		if (head == null && tail == null) {
			System.out.println("List Is Empty...!");
			return -1;
		}

		size--;

		if (head == tail) {
			int data = tail.data;
			head = tail = null;
			return data;
		}

		int data = tail.data;
		tail = tail.prev;
		tail.next = null;
		return data;
	}

	public void printForwardList() {
		if (head == null && tail == null) {
			System.out.println("List Is Empty...!");
			return;
		}

		Node temp = head;
		System.out.print("NULL<-->");
		while (temp != null) {
			System.out.print(temp.data + "<-->");
			temp = temp.next;
		}
		System.out.println("NULL");

	}

	public void printReversedList() {
		if (head == null && tail == null) {
			System.out.println("List Is Empty...!");
			return;
		}

		Node temp = tail;
		System.out.print("NULL<-->");
		while (temp != null) {
			System.out.print(temp.data + "<-->");
			temp = temp.prev;
		}
		System.out.println("NULL");

	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addFirst(5);
		list.addFirst(10);
		list.addFirst(15);
		list.addFirst(20);
		list.addLast(25);
		list.addLast(30);
		list.printForwardList();
		list.printReversedList();
		System.out.println(list.deleteFirst());
		System.out.println(list.deleteLast());
		System.out.println(list.size());
		System.out.println(list.deleteFirst());
		System.out.println(list.deleteFirst());
		list.printForwardList();

	}
}
