package Ch10.DuplicatesInArray;

import java.util.*;
import java.util.stream.IntStream;

public class Arrays {
	
	private Arrays() {
		throw new AssertionError("Cannot be Instantiated");
	}
	
	public static boolean checkDuplicates1(int[] arr) {
		
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("The given array cannot be null or empty");
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean checkDuplicates2(int[] arr) {
		
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("The given array cannot ve null or empty");
		}
		
		java.util.Arrays.sort(arr);
		
		int prev = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == prev) {
				return true;
			}
			
			prev = arr[i];
		}
		
		return false;
	}
	
	public static boolean checkDuplicates3(int[] arr) {
		
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("The given array cannot be null or empty");
		}
		
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < arr.length; i++) {
			
			if(set.contains(arr[i])) {
				return true;
			}
			
			set.add(arr[i]);
		}
		
		return false;
	}
	
	public static boolean checkDuplicates4(int[] arr) {
		
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("The given array cannot be null or empty");
		}
		
		Set set = new HashSet<>(java.util.Arrays.asList(IntStream.of(arr).boxed().toArray(Integer[]::new)));
		
		return arr.length != set.size();
	}
	
	public static boolean checkDuplicates5(int[] arr) {
		
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("The given array cannot be null or mepty");
		}
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[Math.abs(arr[i])] > 0) {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			} else if (arr[Math.abs(arr[i])] == 0) {
				arr[Math.abs(arr[i])] = -(arr.length - 1);
			} else {
				return true;
			}
		}
		
		return false;
	}
}
