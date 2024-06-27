package queue;

public class QueueUsingLinkedList {
	private static Node front;
	private static Node rear;

	static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public boolean isEmpty() {
		return front == null && rear == null;
	}

	public void enQueue(int data) {
		Node node = new Node(data);
		if (front == null) {
			front = rear = node;
			return;
		}
		rear.next = node;
		rear = node;
	}

	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue Is Empty..!");
			return -1;
		}
		if (front == rear) {
			int data = front.data;
			front = rear = null;
			return data;
		}
		int data = front.data;
		front = front.next;
		return data;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue Is Empty..!");
			return -1;
		}
		return front.data;
	}

	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue Is Empty..!");
			return;
		}

		Node temp = front;

		while (temp != null) {
			System.out.print(temp.data + "<--");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QueueUsingLinkedList queue = new QueueUsingLinkedList();

		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);

		queue.printQueue();

		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		// System.out.println (queue.deQueue ());

		System.out.println(queue.peek());
		queue.enQueue(3);
		queue.enQueue(4);
		queue.printQueue();
	}

}
