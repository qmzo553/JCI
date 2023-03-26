package Ch15.PythagoreanTriplets;

import java.util.Arrays;

public final class Pythagoreans {
	
	private Pythagoreans() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static void triplet(int arr[]) {
		
		int len = arr.length;
		
		for(int i = 0; i < len; i++) {
			arr[i] = arr[i] * arr[i];
		}
		
		Arrays.sort(arr);
		
		for(int i = len - 1; i >= 2; i--) {
			
			int b = 0;
			int c = i - 1;
			
			while(b < c) {
				
				if(arr[b] + arr[c] == arr[i] ) {
					System.out.println("Triplet : " + Math.sqrt(arr[b]) + ", " + Math.sqrt(arr[c]) + ", " + Math.sqrt(arr[i]));
					b++;
					c--;
				}
				
				if(arr[b] + arr[c] < arr[i]) {
					b++;
				} else {
					c--;
				}
			}
		}
	}
}
