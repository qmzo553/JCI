package Ch13.IsSymmetricBinaryTree;

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
		
		if(element == null ) {
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
	
	public boolean isSymmetricRecursive() {
		
		if(root == null) {
			return true;
		}
		
		return isSymmetricRecursive(root.left, root.right);
	}
	
	private boolean isSymmetricRecursive(Node leftNode, Node rightNode) {
		
		boolean result = false;
		
		if(leftNode == null && rightNode == null) {
			result = true;
		}
		
		if(leftNode != null && rightNode != null) {
			result = (leftNode.element.equals(rightNode.element)) && isSymmetricRecursive(leftNode.left, rightNode.right) && isSymmetricRecursive(leftNode.right, rightNode.left);
		}
		
		return result;
	}
	
	public boolean isSymmetricIterative() {
		
		if(root == null) {
			return true;
		}
		
		boolean result = false;
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root.left);
		queue.offer(root.right);
		
		while(!queue.isEmpty()) {
			Node left = queue.poll();
			Node right = queue.poll();
			
			if(left == null && right == null) {
				
				result = true;
			} else if (left == null || right == null || left.element != right.element) {
				
				result = false;
				break;
			} else {
				queue.offer(left.left);
				queue.offer(right.right);
				
				queue.offer(left.right);
				queue.offer(right.left);
			}
		}
		
		return result;
	}
}
