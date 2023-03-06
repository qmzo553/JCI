package Ch9;

public class MultiplyingBits {
	
	private MultiplyingBits() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int multiply(int q, int p) {
		
		int result = 0;
		
		while(p != 0) {
			
			if((p & 1) != 0) {
				result = result + q;
			}
			
			q = q << 1;
			p = p >>> 1;
		}
		
		return result;
	}
}
