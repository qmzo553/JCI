package Ch11.LinkedListPalindrome;

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
	
	public void insertFirst(int data) {
		
		Node newNode = new Node();
		
		newNode.data = data;
		newNode.next = head;
		head = newNode;
		
		if(tail == null) {
			tail = newNode;
		}
	}
	
	public boolean isPalindrome() {
		
		Node fastRunner = head;
		Node slowRunner = head;
		
		Stack<Integer> firstHalf = new Stack<>();
		
		while(fastRunner != null && fastRunner.next != null) {
			
			firstHalf.push(slowRunner.data);
			
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
		}
		
		if(fastRunner != null) {
			slowRunner = slowRunner.next;
		}
		
		while(slowRunner != null) {
			
			int top = firstHalf.pop();
			
			if(top != slowRunner.data) {
				return false;
			}
			
			slowRunner = slowRunner.next;
		}
		
		return true;
	}
	
	public void print() {
		
		System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
	}
}
