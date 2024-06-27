package queue;

public class CircularQueueUsingArray {

	private int[] queue;
	private int front;
	private int rear;
	private int capacity;
	private int currSize;

	public CircularQueueUsingArray(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		this.currSize = 0;
		this.front = -1;
		this.rear = -1;
	}

	public void enQueue(int data) {
		if (isFull()) {
			System.out.println("Queue Is Full..!");
			return;
		}

		rear = (rear + 1) % capacity;
		queue[rear] = data;
		if (front == -1) {
			front = rear;
		}
		currSize++;
	}

	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue Is Empty..!");
			return -1;
		}
		int data = queue[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % capacity;
		}
		currSize--;
		return data;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue Is Empty..!");
			return -1;
		}
		return queue[front];
	}

	public boolean isFull() {
		return currSize == capacity;
	}

	public boolean isEmpty() {
		return currSize == 0;
	}

	public int size() {
		return currSize;
	}

	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue Is Empty..!");
			return;
		}

		int i = front;
		while (i != rear) {
			System.out.print(queue[i] + "<--");
			i = (i + 1) % capacity;
		}
		System.out.println(queue[rear]);
	}

	public static void main(String[] args) {
		CircularQueueUsingArray queue = new CircularQueueUsingArray(5);

		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		// queue.enQueue (5); //Queue Is Full..!

		queue.printQueue();

		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.peek());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());

		queue.enQueue(3);
		queue.enQueue(4);
		queue.printQueue();
	}

}
