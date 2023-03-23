package Ch12.MyStack;

import java.lang.reflect.Array;
import java.util.*;

public final class MyStack<E> {
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int top;
	private E[] stack;
	
	MyStack(){
		
		stack = (E[]) Array.newInstance(
				Object[].class.getComponentType(), DEFAULT_CAPACITY);
		
		top = 0;
	}
	
	public void push(E e) {
		
		if(isFull()) {
			ensureCapacity();
		}
		
		stack[top ++] = e;
	}
	
	public E pop() {
		
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		E e = stack[--top];
		
		stack[top] = null;
		
		return e;
	}
	
	public E peek() {
		
		if(isEmpty()) {
			throw new EmptyStackException(); 
		}
		
		return stack[top - 1];
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public boolean isFull() {
		return top == stack.length;
	}
	
	private void ensureCapacity() {
		int newSize = stack.length * 2;
		stack = Arrays.copyOf(stack, newSize);
	}
}
