package Ch9;

import java.util.*;

public final class Sets {
	
	private Sets() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static Set<Set<Character>> powerSet(char[] set) {
		
		if(set == null) {
			throw new IllegalArgumentException("The given set cannot be null");
		}
		
		long subsetsNo = (long) Math.pow(2, set.length);
		
		Set<Set<Character>> subsets = new HashSet<>();
		
		for(int i = 0; i < subsetsNo; i++) {
			Set<Character> subset = new HashSet<>();
			
			for(int j = 0; j < set.length; j++) {
				if((i & (1 << j)) != 0) {
					subset.add(set[j]);
				}
			}
			
			subsets.add(subset);
		}
		
		return subsets;
	}
}
