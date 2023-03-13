package Ch10.MedianOfSortedArrays;

public final class Arrays {
	
	private Arrays() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static float median(int[] q, int[] p) {
		
		if(q == null || p == null) {
			return -1;
		}
		
		int lenQ = q.length;
		int lenP = p.length;
		
		if(lenQ > lenP) {
			swap(q, p);
		}
		
		int qPointerMin = 0;
		int qPointerMax = q.length;
		int midLength = (q.length + p.length + 1) / 2;
		
		int qPointer;
		int pPointer;
		
		while(qPointerMin <= qPointerMax) {
			
			qPointer = (qPointerMin + qPointerMax) / 2;
			pPointer = midLength - qPointer;
			
			if(qPointer < q.length && p[pPointer - 1] > q[qPointer]) {
				qPointerMin = qPointer + 1;
			} else if(qPointer > 0 && q[qPointer - 1] > p[pPointer]) {
				qPointerMax = qPointer - 1;
			} else {
				
				int maxLeft = 0;
				
				if(qPointer == 0) {
					maxLeft = p[pPointer - 1];
				} else if(pPointer == 0) {
					maxLeft = q[qPointer - 1];
				} else {
					maxLeft = Integer.max(q[qPointer - 1], p[pPointer - 1]);
				}
				
				if(((q.length + p.length) & 2) == 1) {
					return maxLeft;
				}
				
				int minRight = 0;
				
				if(qPointer == q.length) {
					minRight = p[pPointer];
				} else if(pPointer == p.length) {
					minRight = q[qPointer];
				} else {
					minRight = Integer.min(q[qPointer], p[pPointer]);
				}
				
				return (maxLeft + minRight) / 2.0f;
			}
		}
		return -1;
	}
	
	private static void swap(int[] q, int[] p) {
		
		int[] aux = q;
		q = p;
		p = aux;
	}
}
