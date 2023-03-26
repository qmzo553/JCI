package Ch14.SortQueueWithoutExtraSpace;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new ArrayDeque<>();
        queue.add(7);
        queue.add(1);
        queue.add(-7);
        queue.add(3);
        queue.add(9);
        queue.add(2);
        queue.add(1);
        queue.add(-1);
        queue.add(0);
        queue.add(0);
        queue.add(9);
        queue.add(2);
        queue.add(3);
        queue.add(1);

        System.out.println("Given queue: " + queue);

        Queues.sort(queue);

        System.out.println("Sorted queue: " + queue);
	}

}
