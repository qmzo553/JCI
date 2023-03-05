package Ch8;

import java.util.Set;

public final class Words {
	
	private Words() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static boolean breakItPlainRecursive(Set<String> dictionary, String str) {
		
		if(dictionary == null || str == null || dictionary.isEmpty() || str.isEmpty()) {
			return false;
		}
		
		return breakItPlainRecursive(dictionary, str, 0);
	}
	
	private static boolean breakItPlainRecursive(Set<String> dictionary, String str, int index) {
		
		if(index == str.length()) {
			return true;
		}
		
		boolean canBreak = false;
		for(int i = index; i < str.length(); i++) {
			canBreak = canBreak || dictionary.contains(str.substring(index, i + 1)) && breakItPlainRecursive(dictionary, str, i + 1);
		}
		
		return canBreak;
	}
	
	public static boolean breakItBottomUp(Set<String> dictionary, String str) {
		
		if(dictionary == null || str == null || dictionary.isEmpty() || str.isEmpty()) {
			return false;
		}
		
		boolean[] table = new boolean[str.length() + 1];
		table[0] = true;
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = i + 1; table[i] && j <= str.length(); j++) {
				if(dictionary.contains(str.subSequence(i, j))) {
					table[j] = true;
				}
			}
		}
		
		return table[str.length()];
	}
	
	public static void printAllSequences(Set<String> dictionary, String str, String result) {
		
		if(str.length() == 0) {
			System.out.println(result);
			return;
		}
		
		for(int i = 1; i <= str.length(); i++) {
			
			String prefix = str.substring(0, i);
			
			if(dictionary.contains(prefix)) {
				printAllSequences(dictionary, str.substring(i), result + " " + prefix);
			}
		}
	}
}
