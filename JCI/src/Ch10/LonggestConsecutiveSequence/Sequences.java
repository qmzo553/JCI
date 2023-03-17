package Ch10.LonggestConsecutiveSequence;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public final class Sequences {
	
	private Sequences() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int findLongestConsecutive(int[] sequence) {
		
		if(sequence == null) {
			throw new IllegalArgumentException("The given sequence cannot be empty");
		}
		
		Set<Integer> sequenceSet = IntStream.of(sequence).boxed().collect(Collectors.toSet());
		int longestSequence = 1;
		
		for(int elem : sequence) {
			
			if(!sequenceSet.contains(elem - 1)) {
				
				int sequenceLength = 1;
				
				while(sequenceSet.contains(elem + sequenceLength)) {
					sequenceLength++;
				}
				
				longestSequence = Math.max(longestSequence, sequenceLength);
			}
		}
		
		return longestSequence;
	}
}
