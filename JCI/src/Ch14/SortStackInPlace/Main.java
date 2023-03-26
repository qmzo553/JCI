package Ch14.SortStackInPlace;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(8);
        stack.push(3);
        stack.push(5);
        stack.push(4);
        
        System.out.println("Before sorting: " + stack);
        
        Stacks.sort(stack);
        
        System.out.println("After sorting: " + stack);
	}

}
