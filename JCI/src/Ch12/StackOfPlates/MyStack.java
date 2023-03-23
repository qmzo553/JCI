package Ch12.StackOfPlates;

import java.util.*;

public class MyStack {
	
	private static final int STACK_SIZE = 3;
	
	private final LinkedList<Stack<Integer>> stacks = new LinkedList<>();
	
	public void push(int value) {
		
		if(stacks.isEmpty() || stacks.getLast().size() >= STACK_SIZE) {
			
			Stack<Integer> stack = new Stack<>();
			stack.push(value);
			
			stacks.add(stack);
		} else {
			stacks.getLast().push(value);
		}
	}
	
	public Integer pop() {
		
		if(stacks.isEmpty()) {
			throw new EmptyStackException();
		}
		
		Stack<Integer> lastStack = stacks.getLast();
		
		int value = lastStack.pop();
		
		removeStackIfEmpty();
		
		return value;
	}
	
	public Integer popAt(int stackIndex) {
		
		if(stacks.isEmpty()) {
			throw new EmptyStackException();
		}
		
		if(stackIndex < 0 || stackIndex >= stacks.size()) {
			throw new IllegalArgumentException("The given index is out of bounds");
		}
		
		int value = stacks.get(stackIndex).pop();
		
		shift(stackIndex);
		
		removeStackIfEmpty();
		
		return value;
	}
	
	private void shift(int index) {
		
		for(int i = index; i < stacks.size() - 1; ++i) {
			Stack<Integer> currentStack = stacks.get(i);
			Stack<Integer> nextStack = stacks.get(i + 1);
			
			currentStack.push(nextStack.remove(0));
		}
	}
	
	private void removeStackIfEmpty() {
		if(stacks.getLast().isEmpty()) {
			stacks.removeLast();
		}
	}
	
	public void printStacks() {
		for(int i = 0; i < stacks.size(); i++) {
			System.out.println("\nStack " + (i) + ": ");
			System.out.print("BOTTOM -> ");
			for(int value : stacks.get(i)) {
				System.out.print(value + " ");
			}
			System.out.print(" <- Top\n");
		}
	}
}
