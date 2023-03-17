package Ch11.LinkedListRemoveDuplicates;

import java.util.*;

public final class SinglyLinkedList {
	
	private final class Node {
		
		private int data;
		private Node next;
		
		@Override
		public String toString() {
			return " " + data + " ";
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public void insertFirst(int data) {
		
		Node newNode = new Node();
		
		newNode.data = data;
		newNode.next = head;
		head = newNode;
		
		if(tail == null) {
			tail = newNode;
		}
		
		size++;
	}
	
	public void removeDuplicates1() {
		
		Set<Integer> dataSet = new HashSet<>();
		
		Node currentNode = head;
		Node prevNode = null;
		while(currentNode != null) {
			if(dataSet.contains(currentNode.data)) {
				prevNode.next = currentNode.next;
				
				if(currentNode == null) {
					tail = prevNode;
				}
				
				size--;
			} else {
				dataSet.add(currentNode.data);
				prevNode = currentNode;
			}
			
			currentNode = currentNode.next;
		}
	}
	
	public void print() {
		
		System.out.println("\nHead (" + head + ")----------> Last (" + tail + "):");
		
		Node currentNode = head;
		while(currentNode != null) {
			
			System.out.print(currentNode);
			currentNode = currentNode.next;
		}
		
		System.out.println();
	}
	
	public int size() {
		return size;
	}
}
