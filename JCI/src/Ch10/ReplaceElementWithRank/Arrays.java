package Ch10.ReplaceElementWithRank;

import java.util.*;

public final class Arrays {
	
	private Arrays() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static void replace(int[] m) {
		
		if(m == null) {
			throw new IllegalArgumentException("The given array cannot be null");
		}
		
		Map<Integer, Integer> treemap = new TreeMap<>();
		
		for(int i = 0; i < m.length; i++) {
			treemap.put(m[i], i);
		}
		
		int rank = 1;
		
		for(Map.Entry<Integer, Integer> entry : treemap.entrySet()) {
			m[entry.getValue()] = rank++;
		}
	}
}
