package stack;

public class StackUsingArray {
	private static int[] stack;
	private static int tos;
	private static int maxSize;

	public static void createStack(int size) {
		maxSize = size;
		stack = new int[maxSize];
		tos = -1;
	}

	public static boolean isEmpty() {
		return tos < 0;
	}

	public static boolean isFull() {
		return tos == maxSize - 1;
	}

	public static void push(int data) {
		if (isFull()) {
			System.out.println("Stack Overflow...!");
			return;
		}
		stack[++tos] = data;
	}

	public static int pop() {
		if (!isEmpty()) {
			int data = stack[tos--];
			return data;
		} else {
			System.out.println("Stack Underflow...!");
			return -1;
		}
	}

	public static int peek() {
		if (!isEmpty()) {
			return stack[tos];
		} else {
			System.out.println("Stack Underflow...!");
			return -1;
		}
	}

	public static void printStack() {
		if (isEmpty()) {
			System.out.println("Stack Underflow...!");
			return;
		}

		int i = tos;
		while (i >= 0) {
			System.out.println(stack[i--]);
		}
	}

	public static void main(String[] args) {
		int size = 5;
		createStack(size);
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		// push (6); //Stack Overflow...!
		printStack();
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(peek());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop()); // Stack Underflow...!

	}
}
