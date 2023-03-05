package Ch8;

import java.util.*;

public class DuplicatePermutation {
	
	private DuplicatePermutation() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static Set<String> permute(String str) {
		if(str == null || str.isEmpty()) {
			return Collections.emptySet();
		}
		
		return permute("", str);
	}
	
	private static Set<String> permute(String prefix, String str) {
		
		Set<String> permutations = new HashSet<>();
		
		int n = str.length();
		
		if(n == 0) {
			permutations.add(prefix);
		} else {
			for(int i = 0; i < n; i++) {
				permutations.addAll(permute(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
			}
		}
		
		return permutations;
	}
}
