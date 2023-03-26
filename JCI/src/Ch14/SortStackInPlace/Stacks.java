package Ch14.SortStackInPlace;

import java.util.*;

public final class Stacks {
	
	private Stacks() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static void sort(Stack<Integer> stack) {
		
		if(stack == null) {
			throw new IllegalArgumentException("The given stack cannot be empty");
		}
		
		if(stack.isEmpty()) {
			return;
		}
		
		int top = stack.pop();
		
		sort(stack);
		
		sortedInsert(stack, top);
	}
	
	private static void sortedInsert(Stack<Integer> stack, int element) {
		
		if(stack.isEmpty() || element > stack.peek()) {
			stack.push(element);
			return;
		}
		
		int top = stack.pop();
		
		sortedInsert(stack, element);
		
		stack.push(top);
	}
}
