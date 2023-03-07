package Ch10.ExtractSurrogatePairs;

import java.util.*;

public class Strings {
	
	private Strings() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static List<Integer> extract(String str) {
		
		if(str == null || str.isEmpty()) {
			return Collections.emptyList();
		}
		
		List<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < str.length(); i++) {
			
			int cp = str.codePointAt(i);
			if(i < str.length() - 1 && str.codePointCount(i, i + 2) == 1) {
				result.add(cp);
				result.add(str.codePointAt(i + 1));
				i++;
			}
		}
		
		return result;
	}
}
