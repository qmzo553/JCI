package Ch12.StackBraces;

import java.util.Stack;

public final class StackBraces {
	
	private StackBraces() {
		throw new AssertionError("Cannot be intantiated");
	}
	
	public static boolean bracesMatching(String bracesStr) {
		
		if(bracesStr == null || bracesStr.isEmpty()) {
			return false;
		}
		
		Stack<Character> stackBraces = new Stack<>();
			
		int len = bracesStr.length();
		for(int i = 0; i < len; i++) {
			
			switch(bracesStr.charAt(i)) {
			case '{':
				stackBraces.push(bracesStr.charAt(i));
				break;
				
			case '}':
				if(stackBraces.isEmpty()) {
					return false;
				}
				
				stackBraces.pop();
				break;
			
			default:
				return false;
			}
		}
		
		return stackBraces.empty();
	}
}
