package stack;
import java.util.*;

public class StackUsingArrayList {
	ArrayList<Integer> stack;

	public StackUsingArrayList ()
	  {

		stack = new ArrayList < Integer > ();

	  }

	public boolean isEmpty() {

		return stack.isEmpty();

	}

	public void push(int data) {

		stack.add(0, data);

	}

	public int pop() {

		if (isEmpty()) {

			System.out.println("Stack Underflow..!");

			return -1;

		}

		int data = stack.get(0);

		stack.remove(0);

		return data;

	}

	public int peek() {

		if (isEmpty()) {

			System.out.println("Stack Underflow..!");

			return -1;

		}

		return stack.get(0);

	}

	public void printStack() {

		if (isEmpty()) {

			System.out.println("Stack Underflow..!");

			return;

		}

		for (int i = 0; i < stack.size(); i++) {

			System.out.println(stack.get(i));

		}
	}

	public static void main(String[] args) {
		StackUsingArrayList stack = new StackUsingArrayList();

		stack.push(1);

		stack.push(2);

		stack.push(3);

		stack.push(4);

		stack.push(5);

		stack.printStack();

		System.out.println(stack.pop());

		System.out.println(stack.pop());

		System.out.println(stack.peek());

		System.out.println(stack.pop());

		System.out.println(stack.pop());

		System.out.println(stack.pop());

		System.out.println(stack.pop());

	}
}
