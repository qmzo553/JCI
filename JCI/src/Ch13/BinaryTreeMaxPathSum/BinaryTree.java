package Ch13.BinaryTreeMaxPathSum;

import java.util.*;

public class BinaryTree {
	
	private Node root = null;
	private int max;
	
	private class Node {
		
		private Node left;
		private Node right;
		
		private final int element;
		
		public Node(int element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}
		
		public Node(Node left, Node right, int element) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
	
	public boolean insert(int element) {
		
		if(root == null) {
			root = new Node(element);
			
			return true;
		}
		
		insert(root, element);
		
		return true;
	}
	
	private void insert(Node node, int element) {
		
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
	
	public int maxPathSum() {
		
		maxPathSum(root);
		
		return max;
	}
	
	private int maxPathSum(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int left = Math.max(0,  maxPathSum(root.left));
		
		int right = Math.max(0, maxPathSum(root.right));
		
		max = Math.max(max, left + right + root.element);
		
		return Math.max(left, right) + root.element;
	}
}
