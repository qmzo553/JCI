package Ch9;

public final class SubBits {
	
	private SubBits() {
		throw new AssertionError("Cannot be istantiated");
	}
	
	public static int subtract(int q, int p) {
		
		while(p != 0) {
			
			int borrow = (~q) & p;
			
			q = q ^ p;
			
			p = borrow << 1;
		}
		
		return q;
	}
}
