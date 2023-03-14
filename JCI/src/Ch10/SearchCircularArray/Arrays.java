package Ch10.SearchCircularArray;

public final class Arrays {
	
	private Arrays() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int find(int[] m, int x) {
		
		if(m == null || m.length == 0) {
			return -1;
		}
		
		int left = 0;
		int right = m.length - 1;
		
		while(left <= right) {
			
			int middle = (left + right) / 2;
			
			if(m[middle] == x) {
				return middle;
			}
			
			if(m[middle] <= m[right]) {
				
				if(x > m[middle] && x <= m[right]) {
					left = middle + 1;
				} else {
					right = middle - 1;
				}
			} else {
				
				if(x >= m[left] && x < m[middle]) {
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			}
		}
		
		return -1;
	}
}
