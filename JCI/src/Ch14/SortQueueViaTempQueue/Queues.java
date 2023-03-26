package Ch14.SortQueueViaTempQueue;

import java.util.*;

public final class Queues {

	private Queues() {
		throw new AssertionError("Cannot be instantitated");
	}
	
	public static void sort(Queue<Integer> queue) {
		
		if(queue == null || queue.size() < 2) {
			return;
		}
		
		Queue<Integer> extraQueue = new ArrayDeque();
		
		int count = 0;
		boolean sorted = false;
		
		int queueSize = queue.size();
		int lastElement = queue.peek();
		
		while(!sorted) {
			if(lastElement <= queue.peek()) {
				lastElement = queue.poll();
				extraQueue.add(lastElement);
			} else {
				queue.add(queue.poll());
			}
			
			count++;
			if(count != queueSize) {
				continue;
			}
			
			if(extraQueue.size() == queueSize) {
				sorted = true;
			}
			
			while(extraQueue.size() > 0) {
				queue.add(extraQueue.poll());
				lastElement = queue.peek();
			}
			
			count = 0;
		}
	}
}
