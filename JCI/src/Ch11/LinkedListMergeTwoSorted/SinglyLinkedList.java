package Ch11.LinkedListMergeTwoSorted;

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
	
	public void merge(SinglyLinkedList sll) {
		
		if(sll == null) {
			throw new IllegalArgumentException("Cannot merge null linked list");
		}
		
		Node list1 = head;
		Node list2 = sll.head;
		
		if(list1.data < list2.data) {
			head = list1;
		} else {
			head = list2;
			list2 = list1;
			list1 = head;
		}
		
		while(list1.next != null) {
			if(list1.next.data > list2.data) {
				
				Node auxNode = list1.next;
				list1.next = list2;
				list2 = auxNode;
			}
			
			list1 = list1.next;
		}
		
		if(list1.next == null) {
			list1.next = list2;
		}
	}
	
	public void print() {      
        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
