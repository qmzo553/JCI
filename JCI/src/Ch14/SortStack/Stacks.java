package Ch14.SortStack;

import java.util.Stack;

public final class Stacks {
	
	private Stacks() {
		throw new AssertionError("Cannot be instantitated");
	}
	
	public static void sort(Stack<Integer> stack) {
		
		Stack<Integer> auxStack = new Stack<>();
		
		while(!stack.isEmpty()) {
			int t = stack.pop();
			while(!auxStack.isEmpty() && auxStack.peek() > t) {
				stack.push(auxStack.pop());
			}
			
			auxStack.push(t);
		}
		
		while(!auxStack.isEmpty()) {
			stack.push(auxStack.pop());
		}
	}
}
