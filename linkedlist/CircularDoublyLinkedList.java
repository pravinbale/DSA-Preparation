package linkedlist;

public class CircularDoublyLinkedList {
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
			head.prev = tail;
			tail.next = head;
			return;
		}
		node.next = head;
		head.prev = node;
		head = node;
		head.prev = tail;
		tail.next = head;
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
			head.prev = tail;
			tail.next = head;
			return data;
		}
	}

	public void addLast(int data) {
		Node node = new Node(data);

		if (head == null && tail == null) {
			head = tail = node;
			tail.next = head;
			head.prev = tail;
			return;
		}
		tail.next = node;
		node.prev = tail;
		tail = node;
		head.prev = tail;
		tail.next = head;
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
		tail.next = head;
		head.prev = tail;
		return data;
	}

	public void printList() {
		if (head == null && tail == null) {
			System.out.println("List Is Empty...!");
			return;
		}

		Node temp = head;
		System.out.print("<-->");
		do {
			System.out.print(temp.data + "<-->");
			temp = temp.next;
		} while (temp != head);
		System.out.println();
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		CircularDoublyLinkedList list = new CircularDoublyLinkedList();
		list.addFirst(5);
		list.addFirst(10);
		list.addFirst(15);
		list.addFirst(20);
		list.addLast(25);
		list.addLast(30);
		list.printList();
		System.out.println(list.deleteFirst());
		System.out.println(list.deleteFirst());
		System.out.println(list.deleteLast());
		System.out.println(list.deleteLast());
		list.addLast(25);
		list.addFirst(20);
		System.out.println(list.size());
		list.printList();

	}

}
