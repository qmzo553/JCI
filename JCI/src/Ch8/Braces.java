package Ch8;

import java.util.*;

public final class Braces {
	
	private Braces() {
		throw new AssertionError("Canonot be instantiated");
	}
	
	public static List<String> embrace(int nr) {
		
		if(nr <= 0) {
			return Collections.emptyList();
		}
		
		List<String> results = new ArrayList<>();
		embrace(nr, nr, new char[nr * 2], 0, results);
		
		return results;
	}
	
	private static void embrace(int leftHand, int rightHand, char[] str, int index, List<String> results) {
		
		if(rightHand < leftHand || leftHand < 0) {
			return;
		}
		
		if(leftHand == 0 && rightHand == 0) {
			results.add(String.valueOf(str));
		} else {
			str[index] = '{';
			embrace(leftHand - 1, rightHand, str, index + 1, results);
			
			str[index] = '}';
			embrace(leftHand, rightHand - 1, str, index + 1, results);
		}
	}
}
