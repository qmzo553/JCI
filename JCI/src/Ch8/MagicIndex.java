package Ch8;

public class MagicIndex {
	
	private MagicIndex() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int find(int[] arr) {
		
		if(arr == null) {
			return -1;
		}
		
		return find(arr, 0, arr.length - 1);
	}
	
	private static int find(int[] arr, int startIndex, int endIndex) {
		
		if(startIndex > endIndex) {
			return -1;
		}
		
		int middleIndex = (startIndex + endIndex) / 2;
		int value = arr[middleIndex];
		
		int leftIndex = find(arr, startIndex, Math.min(middleIndex - 1, value));
		if(leftIndex >= 0) {
			return leftIndex;
		}
		
		if(value == middleIndex) {
			return middleIndex;
		}
		
		return find(arr, Math.max(middleIndex + 1, value), endIndex);
	}
}
