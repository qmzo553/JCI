package Ch10.MaxMatrixOfOne;

public final class Matrices {
	
	private Matrices() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int ofOne(int[][] matrix) {
		
		if(matrix == null) {
			throw new IllegalArgumentException("The given matrix cannot be null");
		}
		
		int maxSubMatrixSize = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for(int k = 1; k <= Math.max(cols, rows); k++) {
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					
					int temp = 1;
					
					if((i + k) > rows || (j + k) > cols) {
						continue;
					}
					
					for(int x = i; x < (i + k); x++) {
						for(int y = j; y < (j + k); y++) {
							if(matrix[x][y] == 0) {
								temp = 0;
								break;
							}
						}
					}
					
					if(temp == 1) {
						maxSubMatrixSize = Math.max(maxSubMatrixSize, k);
					}
				}
			}
		}
		
		return maxSubMatrixSize;
	}
	
	public static int ofOneOptimized(int[][] matrix) {
		
		if(matrix == null) {
			throw new IllegalArgumentException("The given matrix cannot be null");
		}
		
		int maxSubMatrixSize = 1;
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int[][] subMatrix = new int[rows][cols];
		
		for(int i = 0; i < cols; i++) {
			subMatrix[0][i] = matrix[0][i];
		}
		
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				if(matrix[i][j] == 1) {
					subMatrix[i][j] = Math.min(subMatrix[i - 1][j - 1], Math.min(subMatrix[i][j - 1], subMatrix[i - 1][j])) + 1;
					maxSubMatrixSize = Math.max(maxSubMatrixSize, subMatrix[i][j]);
				}
			}
		}
		
		for(int i = 0; i < subMatrix.length; i++) {
			System.out.println();
			for(int j = 0; j < subMatrix[i].length; j++) {
				System.out.print(subMatrix[i][j] + " ");
			}
		}
		
		return maxSubMatrixSize;
	}
}
