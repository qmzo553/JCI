package Ch11.LinkedListLoopDetection;

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
	
	public void generateLoop() {
		
		if(size < 2) {
			throw new RuntimeException("The linked list size must be at least 2");
		}
		
		Node currentNode = head;
		int rnd = new Random().nextInt(size - 1);
		
		for(int i = 0; i < rnd; i++) {
			currentNode = currentNode.next;
		}
		
		System.out.println("The generated loop starts at the node with value : " + currentNode);
		
		tail.next = currentNode;
	}
	
	public void findLoopStartNode() {
		
		Node slowRunner = head;
		Node fastRunner = head;
		
		while(fastRunner != null && fastRunner.next != null) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			if(slowRunner == fastRunner) {
				System.out.println("\nThe meet point is at the node with value : " + slowRunner);
				break;
			}
		}
		
		if(fastRunner == null || fastRunner.next == null) {
			return;
		}
		
		slowRunner = head;
		while(slowRunner != fastRunner) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}
		
		System.out.println("\nLoop start detected at the node with value : " + fastRunner);
	}
	
	public void print() {

        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        for (int i = 0; i < size; i++) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
	}
}
