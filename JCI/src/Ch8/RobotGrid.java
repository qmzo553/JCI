package Ch8;

public final class RobotGrid {
	
	private RobotGrid() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int countPaths(int m, int n) {
		if(m <= 0 || n <= 0) {
			return -1;
		}
		
		if(m == 1 || n == 1) {
			return 1;
		}
		
		return countPaths(m - 1, n) + countPaths(m, n - 1);
	}
	
	public static int countPathsBottomUp(int m, int n) {
		if(m <= 1 || n <= 1) {
			return -1;
		}
		
		int[][] count = new int[m][n];
		
		for(int j = 0; j < n; j++) {
			count[0][j] = 1;
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				count[i][j] = count[i - 1][j] + count[i][j - 1];
			}
		}
		
		return count[m - 1][n - 1];
	}
}
