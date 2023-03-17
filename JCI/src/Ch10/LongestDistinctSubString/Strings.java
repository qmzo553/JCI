package Ch10.LongestDistinctSubString;

public final class Strings {
	
	private Strings() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	private static final int ASCII_CODES = 256;
	
	public static String longestDistinctSubstring(String str) {
		
		if(str == null || str.isEmpty()) {
			return "";
		}
		
		boolean[] flagWindow = new boolean[ASCII_CODES];
		
		int left = 0;
		int right = 0;
		
		for(int wl = 0, wr = 0; wr < str.length(); wr++) {
			
			if(flagWindow[str.charAt(wr)]) {
				while(str.charAt(wl) != str.charAt(wr)) {
					flagWindow[str.charAt(wl)] = false;
					wl++;
				}
				
				wl++;
			} else {
				flagWindow[str.charAt(wr)] = true;
				
				if((right - left) < (wr - wl)) {
					left = wl;
					right = wr;
				};
			}
		}
		
		return str.substring(left, right + 1);
	}
}
