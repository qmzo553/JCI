package Ch11.DoublyLinkedListReverse;

public final class DoublyLinkedList {
	
	private final class Node {
		
		private int data;
		private Node next;
		private Node prev;
		
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
		
		if(head != null) {
			head.prev = newNode;
		}
		
		head = newNode;
	}
	
	public void reverse() {
		
		Node currentNode = head;
		Node prevNode = null;
		
		while(currentNode != null) {
			
			Node prev = currentNode.prev;
			currentNode.prev = currentNode.next;
			currentNode.next = prev;
			
			prevNode = currentNode;
			
			currentNode = currentNode.prev;
		}
		
		if(prevNode != null) {
			head = prevNode;
		}
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
