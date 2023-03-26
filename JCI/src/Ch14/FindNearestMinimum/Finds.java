package Ch14.FindNearestMinimum;

import java.util.Stack;

public final class Finds {
	
	private Finds() {
		throw new AssertionError("Cannot be instantitated");
	}
	
	public static void leftSmaller(int arr[]) {
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < arr.length; i++) {
			while(!stack.empty() && stack.peek() >= arr[i]) {
				stack.pop();
			}
			
			if(stack.empty()) {
				System.out.print("_, ");
			} else {
				System.out.print(stack.peek() + ", ");
			}
			
			stack.push(arr[i]);
		}
	}
}
