package queue;

import java.util.*;;

public class QueueUsingStack {
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public QueueUsingStack() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void enQueue(int data) {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack1.push(data);
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}

	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue Is Empty..!");
			return -1;
		}

		return stack1.pop();
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue Is Empty..!");
			return -1;
		}
		return stack1.peek();
	}

	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();

		queue.enQueue(1);
		queue.enQueue(2);
		System.out.println(queue.peek());
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);

		while (!queue.isEmpty()) {
			System.out.print(queue.deQueue()+ "<--");
		}
		System.out.println();

		queue.enQueue(3);
		queue.enQueue(4);
		System.out.println(queue.peek());

	}
}
