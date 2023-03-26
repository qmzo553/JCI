package Ch14.SearchInFullSortedMatrix;

public final class Matrices {
	
	private Matrices() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static boolean search(int[][] matrix, int element) {
		
		if(matrix == null || matrix.length == 0) {
			return false;
		}
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int left = 0;
		int right = (rows * cols) - 1;
		
		while(left <= right) {
			
			int mid = (left + right) / 2;
			int midElement = matrix[mid / cols][mid % cols];
			
			if(element == midElement) {
				return true;
			} else if (element < midElement) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return false;
	}
}
