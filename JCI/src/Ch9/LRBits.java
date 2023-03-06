package Ch9;

public class LRBits {
	
	private LRBits() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int setBetween(int left, int right) {
		return(1 << (right + 1)) - (1 << left);
	}
}
