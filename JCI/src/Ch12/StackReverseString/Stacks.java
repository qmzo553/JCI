package Ch12.StackReverseString;

import java.util.*;

public final class Stacks {
	
	private Stacks() {
		throw new AssertionError("Cannot be instantited");
	}
	
	public static String reverse(String str) {
		
		Stack<Character> stack = new Stack();
		
		char[] chars = str.toCharArray();
		for(char c : chars) {
			stack.push(c);
		}
		
		for(int i = 0; i < str.length(); i++) {
			chars[i] = stack.pop();
		}
		
		return new String(chars);
	}
}
