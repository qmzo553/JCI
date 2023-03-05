package Ch8;

import java.util.*;

public final class Tower {
	
	private Tower() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int build(List<Box> boxes) {
		
		if(boxes == null) {
			return -1;
		}
		
		Collections.sort(boxes, new Comparator<Box>(){
			@Override
			public int compare(Box b1, Box b2) {
				return Integer.compare(b2.getWidth(), b1.getWidth());
			}
		});
		
		boxes.forEach(System.out::println);
		
		int highest = 0;
		for(int i = 0; i < boxes.size(); i++) {
			int height = build(boxes, i);
			
			highest = Math.max(highest, height);
		}
		
		return highest;
	}
	
	private static int build(List<Box> boxes, int base) {
		
		Box current = boxes.get(base);
		
		int highest = 0;
		for(int i = base + 1; i < boxes.size(); i++) {
			if(boxes.get(i).canBeNext(current)) {
				int height = build(boxes, i);
				highest = Math.max(height, highest);
			}
		}
		
		highest = highest + current.getHeight();
		
		return highest;
	}
	
	public static int buildViaMemoization(List<Box> boxes) {
		
		if(boxes == null) {
			return -1;
		}
		
		Collections.sort(boxes, new Comparator<Box>() {
			@Override
			public int compare(Box b1, Box b2) {
				return Integer.compare(b2.getWidth(), b1.getWidth());
			}
		});
		
		boxes.forEach(System.out::println);
		
		int highest = 0;
		int [] cache = new int[boxes.size()];
		for(int i = 0; i < boxes.size(); i++) {
			int height = buildMemoization(boxes, i, cache);
			highest = Math.max(highest, height);
		}
		
		return highest;
	}
	
	private static int buildMemoization(List<Box> boxes, int base, int[] cache) {
		
		if(base < boxes.size() && cache[base] > 0) {
			return cache[base];
		}
		
		Box current = boxes.get(base);
		
		int highest = 0;
		for(int i = base + 1; i < boxes.size(); i++) {
			if(boxes.get(i).canBeNext(current)) {
				
				int height = buildMemoization(boxes, i, cache);
				highest = Math.max(height, highest);
			}
		}
		
		highest = highest + current.getHeight();
		cache[base] = highest;
		
		return highest;
	}
}
