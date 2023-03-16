package Ch10.PatrolBunks;

public final class Bunks {
	
	private Bunks() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int circularTour(int[] fuel, int[] dist) {
		
		int sumRemainingFuel = 0;
		int totalFuel = 0;
		int start = 0;
		
		for(int i = 0; i < fuel.length; i++) {
			
			int remainingFuel = fuel[i] - dist[i];
			
			if(sumRemainingFuel >= 0) {
				sumRemainingFuel += remainingFuel;
			} else {
				sumRemainingFuel = remainingFuel;
				start = i;
			}
			
			totalFuel += remainingFuel;
		}
		
		if(totalFuel >= 0) {
			return start;
		} else {
			return -1;
		}
	}
}
