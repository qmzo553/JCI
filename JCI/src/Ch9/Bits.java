package Ch9;

public final class Bits {
	
	private Bits() {
		throw new AssertionError("Cannot be instaniated");
	}
	
	public static char getValue(int n, int k) {
		
		if(k < 0 || k > 31) {
			throw new IllegalArgumentException("The position must be between () and 31");
		}
		
		int result = 1 & (n >> k);
		
		if(result == 0) {
			return '0';
		}
		
		return '1';
	}
}
