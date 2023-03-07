package Ch10.StringShrinker;

public final class Strings {
	
	private Strings() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static String shrink(String str) {
		
		if(str == null || str.isEmpty()) {
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			
			count++;
			if(!Character.isWhitespace(str.charAt(i))) {
			
				if((i + 1) >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
					
					result.append(str.charAt(i)).append(count);
					count = 0;
				}
			} else {
				result.append(str.charAt(i));
				count = 0;
			}
		}
		
		return result.length() > str.length() ? str : result.toString();
	}
}
