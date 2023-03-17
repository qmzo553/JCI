package Ch11.LinkedListNthToLastNode;

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
	
	public int nthToLastIterative(int n) {
		
		if(n <= 0) {
			throw new IllegalArgumentException("The given n index is out of bounds");
		}
		
		Node firstRunner = head;
		Node secondRunner = head;
		
		for(int i = 0; i < n; i++) {
			if(firstRunner == null) {
				throw new IllegalArgumentException("The given n index is out of bounds");
			}
			firstRunner = firstRunner.next;
		}
		
		while(firstRunner != null) {
			firstRunner = firstRunner.next;
			secondRunner = secondRunner.next;
		}
		
		return secondRunner.data;
	}
	
	int nthToLastRecursive(int n) {
		
		if(n <= 0) {
			throw new IllegalArgumentException("The given n index is out of bounds");
		}
		
		Node nodeResult = nthToLastRecursive(head, n);
		
		return nodeResult.data;
	}
	
	private static int position;
	private Node nthToLastRecursive(Node node, int n) {
		
		if(node == null) {
			return null;
		}
		
		Node nextNode = nthToLastRecursive(node.next, n);
		
		position++;
		if(position == n) {
			return node;
		}
		
		return nextNode;
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
