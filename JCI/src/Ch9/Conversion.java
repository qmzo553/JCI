package Ch9;

public final class Conversion {
	
	private Conversion() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int count(int q, int p) {
		
		if(q < 0 || p < 0) {
			throw new IllegalArgumentException("The q and p numvers must be positive");
		}
	
		int count = 0;
		
		int xor = q ^ p;
		
		while(xor != 0) {
			count += xor & 1;
			xor = xor >> 1;
		}
	
		return count;
	}	
}
