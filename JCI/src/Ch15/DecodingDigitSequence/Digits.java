package Ch15.DecodingDigitSequence;

public final class Digits {
	
	private Digits() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int decoding(char[] digits, int n) {
		
		if(n == 0 || n == 1) {
			return 1;
		}
		
		if(digits == null || digits[0] == '0') {
			return 0;
		}
		
		int count = 0;
		
		if(digits[n - 1] > '0') {
			count = decoding(digits, n - 1);
		}
		
		if(digits[n - 2] == '1' || (digits[n - 2] == '2' && digits[n - 1] < '7')) {
			count += decoding(digits, n - 2);
		}
		
		return count;
	}
	
	public static int decoding(char digits[]) {
		
		if(digits == null || digits[0] == '0') {
			return 0;
		}
		
		int n = digits.length;
		
		int count[] = new int[n + 1];
		
		count[0] = 1;
		count[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			count[i] = 0;
			
			if(digits[i - 1] > '0') {
				count[i] = count[i - 1];
			}
			
			if(digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7')) {
				count[i] += count[i - 2];
			}
		}
		
		return count[n];
	}
}
