package Ch13.BinaryTreePrintCorners;

import java.util.*;

public class BinaryTree<T> {
	
	private Node root = null;
	
	private class Node {
		
		private Node left;
		private Node right;
		
		private final T element;
		
		private Node(T element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}
		
		private Node(Node left, Node right, T element) {
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
	
	public void printCorners() {
		
		if(root == null) {
			return;
		}
		
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		
		int level = 0;
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			int position = size;
			
			System.out.print("Level : " + level + ": ");
			level++;
			
			while(position > 0) {
				
				Node node = queue.poll();
				position--;
				
				if(position == (size -1) || position == 0) {
					System.out.print(node.element + " ");
				}
				
				if(node.left != null) {
					queue.add(node.left);
				}
			}
			
			System.out.println();
		}
	}
}
