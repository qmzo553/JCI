package Ch11.LinkedListPaiwiseSwap;

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
	
	public void swap() {
		
		if(head == null || head.next == null) {
			return;
		}
		
		Node currentNode = head;
		Node prevPair = null;
		
		while (currentNode != null && currentNode.next != null) {
			
			Node node1 = currentNode;
			Node node2 = currentNode.next;
			Node node3 = currentNode.next.next;
			
			Node auxNode = node1;
			node1 = node2;
			node2 = auxNode;
			
			node1.next = node2;
			node2.next = node3;
			
			if(prevPair == null) {
				head = node1;
			} else {
				prevPair.next = node1;
			}
			
			if(currentNode.next == null) {
				tail = currentNode;
			}
			
			prevPair = node2;
			
			currentNode = node3;
		}
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
