package Ch12.MyQueue;

import java.lang.reflect.Array;
import java.util.*;

public final class MyQueue<E> {
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int front;
	private int rear;
	private int count;
	private int capacity;
	
	private E[] queue;
	
	MyQueue() {
		
		queue = (E[]) Array.newInstance(
				Object[].class.getComponentType(), DEFAULT_CAPACITY);
		
		count = 0;
		front = 0;
		rear = -1;
		
		capacity = DEFAULT_CAPACITY;
	}
	
	public void enqueue(E e) {
		
		if(isFull()) {
			ensureCapacity();
		}
		
		rear = (rear + 1) % capacity;
		queue[rear] = e;
		
		count++;
	}
	
	public E dequeue() {
		
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		E e = queue[front];
		queue[front] = null;
		
		front = (front + 1) % capacity;
		
		count--;
		
		return e;
	}
	
	public E peek() {
		
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		return queue[front];
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean isFull() {
		return size() == capacity;
	}
	
	private void ensureCapacity() {
		
		int newSize = queue.length * 2;
		queue = Arrays.copyOf(queue, newSize);
		
		capacity = newSize;
	}
}
