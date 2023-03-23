package Ch12.MinStackConstantTimeAndSpace;

import java.util.*;

public class MyStack {
	
	private int min;
	private final Stack<Integer> stack = new Stack<>();
	
	public void push(int value) {
		
		int r = Math.addExact(value, value);
		
		if(stack.empty()) {
			stack.push(value);
			min = value;
		} else if(value > min) {
			stack.push(value);
		} else {
			stack.push(r - min);
			min = value;
		}
	}
	
	public void pop() {
		
		if(stack.empty()) {
			throw new EmptyStackException();
		}
		
		int top = stack.peek();
		if(top < min) {
			min = 2 * min - top;
		}
		stack.pop();
	}
	
	public int min() {
		return min;
	}
}
