package queue;

public class QueueUsingArray {
	private int[] queue;
	private int front;
	private int rear;
	private int maxSize;

	public void createQueue(int size) {
		maxSize = size;
		queue = new int[maxSize];
		front = 0;
		rear = -1;
	}

	public boolean isEmpty() {
		return front > rear;
	}

	public boolean isFull() {
		return rear == maxSize - 1;
	}

	public void enQueue(int data) {
		if (isFull()) {
			System.out.println("Queue Is Full..!");
			return;
		}
		queue[++rear] = data;
	}

	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue Is Empty..!");
			return -1;
		}
		return queue[front++];
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue Is Empty..!");
			return -1;
		}
		return queue[front];
	}

	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue Is Empty..!");
			return;
		}

		for (int start = front; start <= rear; start++) {
			System.out.print(queue[start] + "<--");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray();
		int size = 5;
		queue.createQueue(size);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);

		queue.enQueue(5);
		// queue.enQueue(6); //Queue Is Full..!

		queue.printQueue();

		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());

		System.out.println(queue.peek());
	}

}
