package Ch13.MaxHeapToMinHeap;

public class Heaps {
	
	public static void convertToMinHeap(int[] maxHeap) {
		
		if(maxHeap == null) {
			throw new IllegalArgumentException("The given max heap cannot be null");
		}
		
		int p = (maxHeap.length - 2) / 2;
		while(p >= 0) {
			heapifyMin(maxHeap, p--, maxHeap.length);
		}
	}
	
	private static void heapifyMin(int[] maxHeap, int p, int size) {
		
		int left = leftChild(p);
		int right = rightChild(p);
		
		int smallest = p;
		
		if((left < size) && (maxHeap[right] < maxHeap[smallest])) {
			smallest = right;
		}
		
		if(smallest != p) {
			swap(maxHeap, p, smallest);
			heapifyMin(maxHeap, smallest, size);
		}
	}
	
	public static void convertToMaxHeap(int[] minHeap) {

        if (minHeap == null) {
            throw new IllegalArgumentException("The given min heap cannot be null");
        }

        // build heap from last node to all the way up to the root node
        int p = (minHeap.length - 2) / 2;
        while (p >= 0) {
            heapifyMax(minHeap, p--, minHeap.length);
        }
    }
	
	public static void heapifyMax(int[] minHeap, int p, int size) {
		
		int left = leftChild(p);
		int right = rightChild(p);
		
		int largest = p;
		
		if((left < size) && (minHeap[left] > minHeap[p])	) {
			largest = left;
		}
		
		if((right < size) && (minHeap[right] > minHeap[largest])) {
			largest = right;
		}
		
		if(largest != p) {
			swap(minHeap, p, largest);
			heapifyMax(minHeap, largest, size);
		}
	}
	
	private static int leftChild(int parentIndex) {
		return (2 * parentIndex + 1);
	}
	
	private static int rightChild(int parentIndex) {
		return (2 * parentIndex + 2);
	}
	
	private static void swap(int heap[], int i, int j) {
		int aux = heap[i];
		heap[i] = heap[j];
		heap[j] = aux;
	}
}
