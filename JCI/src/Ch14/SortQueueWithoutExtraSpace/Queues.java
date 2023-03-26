package Ch14.SortQueueWithoutExtraSpace;

import java.util.*;

public final class Queues {
	
	private Queues() {
		throw new AssertionError("Cannot be instatiated");
	}
	
	public static void sort(Queue<Integer> queue) {
		
		if(queue == null || queue.size() < 2) {
			return;
		}
		
		for(int i = 1; i <= queue.size(); i++) {
			
			moveMinToRear(queue, queue.size() - i);
		}
	}
	
	private static void moveMinToRear(Queue<Integer> queue, int sortIndex) {
		
		int minElement = Integer.MAX_VALUE;
		boolean flag = false;
		
		int queueSize = queue.size();
		for(int i = 0; i < queueSize; i++) {
			
			int currentElement = queue.peek();
			
			queue.poll();
			
			if(currentElement <= minElement && i <= sortIndex) {
				if(flag) {
					queue.add(minElement);
				}
				
				flag = true;
				minElement = currentElement;
			} else {
				queue.add(currentElement);
			}
		}
		
		queue.add(minElement);
	}
}
