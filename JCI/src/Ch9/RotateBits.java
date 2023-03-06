package Ch9;

public class RotateBits {
	
	private static final int MAX_INT_BITS = 32;
	
	private RotateBits() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int leftRotate(int n, int bits) {
		
		if(n < 0) {
			return -1;
		}
		
		int fallBits = n << bits;
		int fallBitsShiftToRight = n >> (MAX_INT_BITS - bits);
		
		return fallBits | fallBitsShiftToRight;
	}
	
	public static int rightRotate(int n, int bits) {
		
		if(n < 0) {
			return -1;
		}
		
		int fallBits = n >> bits;
		int fallBitsShiftToLeft = n << (MAX_INT_BITS - bits);
		
		return fallBits | fallBitsShiftToLeft;
	}
}
