package Ch10.OneEditAway;

public final class Strings {
	
	private Strings() {
		throw new AssertionError("Cannot bo instantiated");
	}
	
	public static boolean isOneEditAway(String q, String p) {
		
		if(q == null || p == null || q.isEmpty() || p.isEmpty()) {
			return false;
		}
		
		if(Math.abs(q.length() - p.length()) > 1) {
			return false;
		}
		
		String shorter = q.length() < p.length() ? q : p;
		String longer = q.length() < p.length() ? q : p;
		
		int is = 0;
		int il = 0;
		boolean marker = false;
		while(is < shorter.length() && il < longer.length()) {
			
			if(shorter.charAt(is) != longer.charAt(il)) {
				
				if(marker) {
					return false;
				}
				
				marker = true;
				
				if(shorter.length() == longer.length()) {
					is++;
				}
			} else {
				is++;
			}
			il++;
		}
		
		return true;
	}
}
