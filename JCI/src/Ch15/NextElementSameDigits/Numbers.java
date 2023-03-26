package Ch15.NextElementSameDigits;

public final class Numbers {
	
	private Numbers() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static void findNextGreater(int arr[]) {
		
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("The given array cannot be null or empty");
		}
		
		int min = -1;
		int len = arr.length;
		
		int prevDigit = arr[arr.length - 1];
		int currentDigit;
		
		for(int i = len - 2; i >= 0; i--) {
			currentDigit = arr[i];
			if(currentDigit < prevDigit) {
				min = i;
				break;
			}
		}
		
		if(min == -1) {
			System.out.println("There is no greater number with " + "same set of digits as the given one.");
		} else {
			swap(arr, min, len - 1);
			
			reverse(arr, min + 1, len - 1);
			
			System.out.print("The next greater number is : ");
			for(int i : arr) {
				System.out.print(i);
			}
		}
	}
	
	private static void reverse(int[] arr, int start, int end) {
		while(start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int aux = arr[i];
		arr[i] = arr[j];
		arr[j] = aux;
	}
}
