package Ch10.RotationString;

import java.util.regex.Pattern;

public final class Strings {
	
	private Strings() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static boolean isRotation(String str1, String str2) {
		
		if(str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
			return false;
		}
		
		if(str1.length() != str2.length()) {
			return false;
		}
		
		return (str1 + str2).matches("(?i).*" + Pattern.quote(str2) + ".*");
	}
	
}
