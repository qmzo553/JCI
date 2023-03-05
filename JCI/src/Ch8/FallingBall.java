package Ch8;

public class FallingBall {
	
	private FallingBall() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static void computePath(int prevElevation, int i, int j, int rows, int cols, int[][] elevations) {
		
		if(elevations == null) {
			throw new IllegalArgumentException("Elevations cannot be null");
		}
		
		if( i >= 0 && i <= (rows - 1) && j >= 0 && j <= (cols - 1)) {
			int currentElevation = elevations[i][j];
			if(prevElevation >= currentElevation && currentElevation > 0) {
				prevElevation = currentElevation;
				elevations[i][j] = 0;
				
				computePath(prevElevation, i, j - 1, rows, cols, elevations);
				computePath(prevElevation, i - 1, j, rows, cols, elevations);
				computePath(prevElevation, i, j + 1, rows, cols, elevations);
				computePath(prevElevation, i + 1, j, rows, cols, elevations);
			}
		}
	}
	
}
