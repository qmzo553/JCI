package Ch14.SortArrayBasedOnAnoterArray;

import java.util.*;

public final class Sorts {
	
	private Sorts() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static void custom(int[] firstArr, int[] secondArr) {
		
		if(firstArr == null || secondArr == null) {
			throw new IllegalArgumentException("The given input cannot be null");
		}
		
		Map<Integer, Integer> frequencyMap = new TreeMap<>();
		
		for(int i = 0; i < firstArr.length; i++) {
			frequencyMap.putIfAbsent(firstArr[i], 0);
			frequencyMap.put(firstArr[i], frequencyMap.get(firstArr[i]) + 1);
		}
		
		int index = 0;
		
		for(int i = 0; i < secondArr.length; i++) {
			
			int n = frequencyMap.getOrDefault(secondArr[i], 0);
			while(n-- > 0) {
				firstArr[index++] = secondArr[i];
			}
			
			frequencyMap.remove(secondArr[i]);
		}
		
		for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			
			int count = entry.getValue();
			
			while(count-- > 0) {
				firstArr[index++] = entry.getKey();
			}
		}
	}
}
