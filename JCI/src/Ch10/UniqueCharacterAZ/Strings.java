package Ch10.UniqueCharacterAZ;

public final class Strings {
	
	private static final char A_CHAR = 'a';
	
	private Strings() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static boolean isUnique(String str) {
		
		if(str == null || str.isEmpty()) {
			return false;
		}
		
		int marker = 0;
		
		for(int i = 0; i < str.length(); i++) {
			
			int s = str.charAt(i) - A_CHAR;
			int mask = 1 << s;
			
			if((marker & mask) > 0) {
				return false;
			}
			
			marker = marker | mask;
		}
		
		return true;
	}
}
