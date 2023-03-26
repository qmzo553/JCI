package Ch14.InterspersedEmpty;

public final class Strings {
	
	private Strings() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int search(String[] stringsArr, String str) {
		
		if(stringsArr == null || str == null || str.isEmpty()) {
			return -1;
		}
		
		return search(stringsArr, str, 0, stringsArr.length -1);
	}
	
	private static int search(String[] stringsArr, String str, int left, int right) {
		
		if(left > right) {
			return -1;
		}
		
		int mid = (left + right) / 2;
		
		if(stringsArr[mid].isEmpty()) {
			
			int leftMid = mid - 1;
			int rightMid = mid + 1;
			
			while(true) {
				
				if(leftMid < left && rightMid > right) {
					return -1;
				} else if(rightMid <= right && !stringsArr[rightMid].isEmpty()) {
					mid = rightMid;
					break;
				} else if(leftMid >= left && !stringsArr[leftMid].isEmpty()) {
					mid = leftMid;
					break;
				}
				
				rightMid++;
				leftMid--;
			}
		}
		
		if(str.equals(stringsArr[mid])) {
			return mid;
		} else if(stringsArr[mid].compareTo(str) < 0) {
			return search(stringsArr, str, mid + 1, right);
		} else {
			return search(stringsArr, str, left, mid - 1);
		}
	}
}
