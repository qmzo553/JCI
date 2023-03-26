package Ch14.MergeSortSinglyLinkedList;

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
	private int size;
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public void insertFirst(int data) {
		
		Node newNode = new Node();
		
		newNode.data = data;
		newNode.next = head;
		head = newNode;
		
		size++;
	}
	
	public void sort() {
		
		head = sort(head);
	}
	
	private Node sort(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node[] headsOfSublists = divide(head);
		
		Node head1 = headsOfSublists[0];
		Node head2 = headsOfSublists[1];
		
		head1 = sort(head1);
		head2 = sort(head2);
		
		return merge(head1, head2);
	}
	
	private Node[] divide(Node sourceNode) {
		
		if(sourceNode == null || sourceNode.next == null) {
			return new Node[] {sourceNode, null};
		}
		
		Node fastRunner = sourceNode.next;
		Node slowRunner = sourceNode;
		
		while(fastRunner != null) {
			fastRunner = fastRunner.next;
			if(fastRunner != null) {
				slowRunner = slowRunner.next;
				fastRunner = fastRunner.next;
			}
		}
		
		Node[] headsOfSublists = new Node[] {sourceNode, slowRunner.next};
		
		slowRunner.next = null;
		
		return headsOfSublists;
	}
	
	private Node merge(Node head1, Node head2) {
		
		if(head1 == null) {
			return head2;
		} else if(head2 == null) {
			return head1;
		}
		
		Node merged;
		
		if(head1.data <= head2.data) {
			merged = head1;
			merged.next = merge(head1.next, head2);
		} else {
			merged = head2;
			merged.next = merge(head1, head2.next);
		}
		
		return merged;
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

    public int size() {
        return size;
    }
}
