package Ch10.MergeKSortedArr;

public class MergeArrays {
	
	public static int[] merge(int[][] arrs, int k) {
		
		if(arrs == null) {
			throw new IllegalArgumentException("The given arrays cannot be null");
		}
		
		if(k <= 0) {
			throw new IllegalArgumentException("The number of given arrays cannot be less or equal to 0");
		}
		
		int len = 0;
		for(int i = 0 ; i < arrs.length; i++) {
			len += arrs[i].length;
		}
		
		int[] result = new int[len];
		
		MinHeap[] heap = new MinHeap[k];
		
		for(int i = 0; i < k; i++) {
			heap[i] = new MinHeap(arrs[i][0], i, 0);
		}
		
		for(int i = 0; i < result.length; i++) {
			
			heapify(heap, 0, k);
			
			result[i] = heap[0].data;
			
			heap[0].currentIndex++;
			int[] subarray = arrs[heap[0].heapIndex];
			if(heap[0].currentIndex >= subarray.length) {
				heap[0].data = Integer.MAX_VALUE;
			} else {
				heap[0].data = subarray[heap[0].currentIndex];
			}
		}
		
		return result;
	}
	
	private static void heapify(MinHeap[] heap, int root, int len) {
		
		int smallest = root;
		int leftIndex = left(root);
		int rightIndex = right(root);
		
		if(leftIndex < len && heap[smallest].data > heap[leftIndex].data) {
			smallest = leftIndex;
		}
		
		if(rightIndex < len && heap[smallest].data > heap[leftIndex].data) {
			smallest = rightIndex;
		}
		
		if (smallest != root) {
            swap(heap, smallest, root);
            heapify(heap, smallest, len);
        }
	}
	
	private static void swap(MinHeap[] heap, int i, int j) {
        MinHeap aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }
	
	private static int left(int i) {
	        return (2 * i + 1);
	}
	
	private static int right(int i) {
	        return (2 * i + 2);
	}
}
