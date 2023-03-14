package Ch10.ContainMostWater;

public final class Containers {
	
	private Containers() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int maxArea(int[] heights) {
		
		if(heights == null) {
			throw new IllegalArgumentException("The given array cannot be null");
		}
		
		int maxArea = 0;
		
		for(int i = 0; i < heights.length; i++) {
			for(int j = i + 1; j < heights.length; j++) {
				maxArea = Math.max(maxArea, Math.min(heights[i], heights[j]) * (j - 1));
			}
		}
		
		return maxArea;
	}
	
	public static int maxAreaOptimized(int[] heights) {
		
		if(heights == null) {
			throw new IllegalArgumentException("The given array cannot be null");
		}
		
		int maxArea = 0;
		
		int i = 0;
		int j = heights.length - 1;
		
		while(i < j) {
			
			maxArea = Math.max(maxArea, Math.min(heights[i], heights[j]) * (j - i));
			
			if(heights[i] <= heights[j]) {
				i++;
			} else {
				j--;
			}
		}
		
		return maxArea;
	}
}
