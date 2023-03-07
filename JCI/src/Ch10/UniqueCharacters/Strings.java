package Ch10.UniqueCharacters;

import java.util.*;

public final class Strings {
	
	private static final int MAX_CODE = 65535;
	
	private Strings() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static boolean isUnique(String str) {
		
		if(str == null || str.isEmpty()) {
			return false;
		}
		
		Map<Character, Boolean> chars = new HashMap<>();
		
		for(int i = 0; i < str.length(); i++) {
			
			if(str.codePointAt(i) <= MAX_CODE) {
				char ch = str.charAt(i);
				if(!Character.isWhitespace(ch)) {
					if(chars.put(ch, true) != null) {
						return false;
					}
				}
			} else {
				System.out.println("The given string contains unallowed characters");
				return false;
			}
		}
		
		return true;
	}
}
