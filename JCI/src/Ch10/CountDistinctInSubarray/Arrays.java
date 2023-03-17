package Ch10.CountDistinctInSubarray;

import java.util.*;

public final class Arrays {
	
	private Arrays() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static void find(int[] m, int n) {
		
		if(m == null) {
			throw new IllegalArgumentException("The given array cannot be null");
		}
		
		if(n <= 0) {
			throw new IllegalArgumentException("The given sub-array size cannot be <= 0");
		}
		
		Map<Integer, Integer> frequency = new HashMap<>();
		
		int countDistinct = 0;
		
		for(int i = 0; i < m.length; i++) {
			
			if(i >= n) {
				frequency.putIfAbsent(m[i - n], 0);
				frequency.put(m[i - n], frequency.get(m[i - n]) - 1);
				
				if(frequency.get(m[i - n]) == 0) {
					countDistinct--;
				}
			}
			
			frequency.putIfAbsent(m[i], 0);
			frequency.put(m[i], frequency.get(m[i]) + 1);
			
			if(frequency.get(m[i]) == 1) {
				countDistinct++;
			}
			
			if(i >= n - 1) {
				System.out.println("Distinct elemnets in the "
						+ "sub - array [" + (i - n + 1) + "," + i +"]" + "is "
						+ countDistinct);
			}
		}
	}
}
