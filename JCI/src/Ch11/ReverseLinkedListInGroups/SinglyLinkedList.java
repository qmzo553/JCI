package Ch11.ReverseLinkedListInGroups;

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
	
	public void insertFirst(int data) {
		
		Node newNode = new Node();
		
		newNode.data = data;
		newNode.next = head;
		head = newNode;
	}
	
	public void reverseInKGroups(int k) {
		
		if(k <= 0) {
			throw new IllegalArgumentException("A group cannot be 0 or negative");
		}
		
		if(head != null) {
			head = reverseInKGroups(head, k);
		}
	}
	
	private Node reverseInKGroups(Node head, int k) {
		
		Node current = head;
		Node next = null;
		Node prev = null;
		
		int counter = 0;
		
		while(current != null && counter < k) {
			
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			
			counter++;
		}
		
		if(next != null) {
			head.next = reverseInKGroups(next, k);
		}
		
		return prev;
	}
	
	public void print() {

        System.out.println("\nHead (" + head + ") ----------> Last:");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
