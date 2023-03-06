package Ch9;

public final class TwoBits {
	
	private TwoBits() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static void findNonRepeatable(int arr[]) {
		
		int xor = arr[0];
		for(int i = 1; i < arr.length; i++) {
			xor ^= arr[i];
		}
		
		int setBitNo = xor & ~(xor - 1);
		
		int p = 0;
		int q = 0;
		for(int i = 0; i < arr.length; i++) {
			if((arr[i] & setBitNo) != 0) {
				p = p ^ arr[i];
			} else {
				q = q ^ arr[i];
			}
		}
		
		System.out.println("The numbers are : " + p + " and " + q);
	}
}
