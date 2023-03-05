package Ch9;

public final class SetBitValue {
	
	private SetBitValue() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int setValueTo1(int n, int k) {
		
		if(k < 0 || k > 31) {
			throw new IllegalArgumentException("The position must be between () and 31");
		}
		
		return n | (1 << k);
	}
	
	public static int setValueTo0(int n, int k) {
		
		if(k < 0 || k > 31) {
			throw new IllegalArgumentException("The position must be between 0 and 31");
		}
		
		return n & ~(1 << k);
	}
}
