package Ch9;

public final class Elements {
	
	private static final int INT_SIZE = 32;
	
	private Elements() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int unique1(int arr[]) {
		
		if(arr == null || arr.length < 4) {
			throw new IllegalArgumentException("The given array is not valid");
		}
		
		int n = arr.length;
		int result = 0;
		
		int nr;
		int sumBits;
		
		for(int i = 0; i < INT_SIZE; i++) {
			
			sumBits = 0;
			nr = (1 << i);
			for(int j = 0; j < n; j++) {
				if((arr[j] & nr) == 0) {
					sumBits++;
				}
			}
			
			if((sumBits % 3) == 0) {
				result = result | nr;
			}
		}
		
		return result;
	}
	
	public static int unique2(int arr[]) {
		
		if(arr == null || arr.length < 4) {
			throw new IllegalArgumentException("The given array is not valid");
		}
		
		int oneAppearance = 0;
		int twoAppearances = 0;
		
		for(int i = 0; i < arr.length; i ++) {
			twoAppearances = twoAppearances | (oneAppearance & arr[i]);
			oneAppearance = oneAppearance ^ arr[i];
			int neutraliser = ~(oneAppearance & twoAppearances);
			oneAppearance = oneAppearance & neutraliser;
			twoAppearances = twoAppearances & neutraliser;
		}
		
		return oneAppearance;
	}
}
