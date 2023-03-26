package Ch15.MultiplyLargeNumbers;

public final class Numbers {
	
	private Numbers() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static String multiply(String a, String b) {
		
		if(a == null || b == null) {
			throw new IllegalArgumentException("a and b cannot be null");
		}
		
		int lenA = a.length();
		int lenB = b.length();
		
		if(lenA == 0 || lenB == 0) {
			return "0";
		}
		
		int c[] = new int[lenA + lenB];
		
		int idx1 = 0;
		int idx2 = 0;
		
		for(int i = lenA - 1; i >= 0; i--) {
			
			int carry = 0;
			int n1 = a.charAt(i) - '0';
			
			idx2 = 0;
			
			for(int j = lenB - 1; j >= 0; j--) {
				
				int n2 = b.charAt(j) - '0';
				
				int sum = n1 * n2 + c[idx1 + idx2] + carry;
				
				carry = sum / 10;
				
				c[idx1 + idx2] = sum % 10;
				idx2++;
			}
			
			if(carry > 0) {
				c[idx1 + idx2] += carry;
			}
			
			idx1++;
		}
		
		int i = c.length - 1;
		while(i >= 0 && c[i] == 0) {
			i--;
		}
		
		if(i == -1) {
			return "0";
		}
		
		String result = "";
		while(i >= 0) {
			result += (c[i--]);
		}
		
		return result;
	}
}
