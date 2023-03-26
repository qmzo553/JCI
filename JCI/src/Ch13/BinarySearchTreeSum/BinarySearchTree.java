package Ch13.BinarySearchTreeSum;

import java.util.*;

import org.w3c.dom.Node;

public class BinarySearchTree {
	
	private Node root = null;
	
	private class Node {
		
		private final int element;
		
		private Node left;
		private Node right;
		
		public Node(Node left, Node right, int element) {
			
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
	
	public boolean insert(int element) {
		
		root = insert(root, element);
		return true;
	}
	
	private Node insert(Node current, int element) {
		
		if(current == null) {
			return new Node(null, null, element);
		}
		
		if(element < current.element) {
			current.left = insert(current.left, element);
		} else {
			current.right = insert(current.right, element);
		}
		
		return current;
	}
	
	public boolean findPairSumHashing(int sum) {
		
		if(sum <= 0) {
			return false;
		}
		
		return findPairSumHashing(root, sum, new HashSet());
	}
	
	private static boolean findPairSumHashing(Node node, int sum, Set<Integer> set) {
		
		if(node == null) {
			return false;
		}
		
		if(set.contains(sum - node.element)) {
			System.out.print("\nPair (" + (sum - node.element) + ", " + node.element + ") = " + sum);
			return true;
		} else {
			set.add(node.element);
		}
		
		return findPairSumHashing(node.right, sum, set);
	}
	
	public boolean findPairSumTwoStacks(int sum) {
		
		if(sum <= 0 || root == null) {
			return false;
		}
		
		return findPairSumTwoStacks(root, sum);
	}
	
	private static boolean findPairSumTwoStacks(Node node, int sum) {
		  
		Stack<Node> fio = new Stack<>();
		Stack<Node> rio = new Stack<>();
		
		Node minNode = node;
		Node maxNode = node;
		
		while(!fio.isEmpty() || !rio.isEmpty() || minNode != null || maxNode != null) {
			if(minNode != null || maxNode != null) {
				if(minNode != null) {
					fio.push(minNode);
					minNode = minNode.left;
				}
				
				if(maxNode != null) {
					rio.push(maxNode);
					maxNode = maxNode.right;
				}
			} else {
				int elem1 = fio.peek().element;
				int elem2 = rio.peek().element;
				
				if(fio.peek() == rio.peek()) {
					break;
				}
				
				if((elem1 + elem2) == sum) {
					System.out.print("\nPair (" + elem1 + ", " + elem2 + ") = " + sum);
					return true;
				}
				
				if((elem1 + elem2) < sum) {
					minNode = fio.pop();
					minNode = minNode.right;
				} else {
					maxNode = rio.pop();
					maxNode = maxNode.left;
				}
			}
		}
		
		return false;
	}
	
	public void printInOrder() {
		printInOrder(root);
	}
	
	private void printInOrder(Node node) {
		if(node != null) {
			printInOrder(node.left);
			System.out.print(" " + node.element);
			printInOrder(node.right);
		}
	}
}
