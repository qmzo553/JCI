package Ch13.BinaryTreeBalanced;

public class BinaryTree<T extends Comparable<T>> {
	
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
		
		if(contains(element)) {
			return false;
		}
		
		root = insert(root, element);
		
		return true;
	}
	
	private Node insert(Node current, T element) {
		
		if(current == null) {
			return new Node(null, null, element);
		}
		
		if(element.compareTo(current.element) < 0) {
			current.left = insert(current.left, element);
		} else {
			current.right = insert(current.right, element);
		}
		
		return current;
	}
	
	public boolean contains(T element) {
		
		return contains(root, element);
	}
	
	public boolean contains(Node current, T element) {
		
		if(current == null || element == null) {
			return false;
		}
		
		if(element.compareTo(current.element) == 0) {
			return true;
		}
		
		return element.compareTo(current.element) < 0
				? contains(current.left, element)
				: contains(current.right, element);
	}
	
	public boolean isBalanced1() {
		return isBalanced(root);
	}
	
	private boolean isBalanced(Node root) {
		
		if(root == null) {
			return true;
		}
		
		if(Math.abs(height(root.left) - height(root.right)) > 1){
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	private int height(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		return Math.max(height(root.left), height(root.right)) + 1;
	}
	
	public boolean isBalanced2() {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	private int checkHeight(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
