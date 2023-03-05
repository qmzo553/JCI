package Ch9;

public final class ClearBits {

	private ClearBits() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int clearFromMsb(int n, int k) {
		
		if(k < 0 || k > 31) {
			throw new IllegalArgumentException("The position must be between 0 and 31");
		}
		
		return n & ((1 << k) - 1);
	}
	
	public static int clearFromPosition(int n, int k) {
		
		if(k < 0 || k > 31) {
			throw new IllegalArgumentException("The position must be between 0 and 31");
		}
		
		return n & ~((1 << k) - 1);
	}
}
