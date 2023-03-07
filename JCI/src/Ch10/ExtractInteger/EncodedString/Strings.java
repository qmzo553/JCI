package Ch10.EncodedString;

public class Strings {
	
	private Strings() {
		throw new AssertionError("Cannot be instantated");
	}
	
	public static char[] encodeWhitespaces(char[] str) {
		
		if(str == null) {
			throw new IllegalArgumentException("The given string cannot be null");
		}
		
		int countWhitespaces = 0;
		
		for(int i = 0; i < str.length; i++) {
			
			if(Character.isWhitespace(str[i])) {
				countWhitespaces++;
			}
		}
		
		if(countWhitespaces > 0) {
			
			char[] encodedStr = new char[str.length + countWhitespaces * 2];
			
			int index = 0;
			
			for(int i = 0; i < str.length; i++) {
				
				if(Character.isWhitespace(str[i])) {
					
					encodedStr[index] = '%';
					encodedStr[index + 1] = '2';
					encodedStr[index + 2] = '0';
					index = index + 3;
				} else {
					encodedStr[index] = str[i];
					index++;
				}
			}
			return encodedStr;
		}
		
		return str;
	}
}
