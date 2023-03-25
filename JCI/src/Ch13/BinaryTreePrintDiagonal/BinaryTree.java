package Ch13.BinaryTreePrintDiagonal;

import java.util.*;

public class BinaryTree<T> {
	
	private Node root = null;
	
	private class Node {
		
		private Node left;
		private Node right;
		
		private final T element;
		
		public Node(T element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}
		
		public Node(Node left, Node right, T element) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
	
	public boolean insert(T element) {
		
		if(element == null) {
			return false;
		}
		
		if(root == null) {
			root = new Node(element);
					
			return true;
		}
		
		insert(root, element);
		
		return true;
	}
	
	private void insert(Node node, T element) {
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			node = queue.peek();
			queue.poll();
			
			if(node.left == null) {
				node.left = new Node(element);
				break;
			} else {
				queue.add(node.left);
			}
			
			if(node.right == null) {
				node.right = new Node(element);
				break;
			} else {
				queue.add(node.right);
			}
		}
	}
	
	public void printDiagonalRecursive() {
		
		Map<Integer, List<T>> map = new HashMap<>();
		
		printDiagonal(root, 0, map);
		
		for(int i = 0; i < map.size(); i++) {
			System.out.println(map.get(i));
		}
	}
	
	private void printDiagonal(Node node, int diagonal, Map<Integer, List<T>> map) {
		
		if(node == null) {
			return;
		}
		
		if(!map.containsKey(diagonal)) {
			map.put(diagonal, new ArrayList<>());
		}
		
		map.get(diagonal).add(node.element);
		
		printDiagonal(node.left, diagonal + 1, map);
		
		printDiagonal(node.right, diagonal, map);
	}
	
	public void printDiagonalIterative() {
		
		Queue<Node> queue = new ArrayDeque<>();
		
		Node dummy = new Node(null);
		
		while(root != null) {
			queue.add(root);
			root = root.right;
		}
		
		queue.add(dummy);
		
		while(queue.size() != 1) {
			
			Node front = queue.poll();
			
			if(front != dummy) {
				
				System.out.print(front.element + " ");
				
				Node node = front.left;
				while(node != null) {
					queue.add(node);
					node = node.right;
				}
			} else {
				queue.add(dummy);
				
				System.out.println();
			}
		}
	}
}
