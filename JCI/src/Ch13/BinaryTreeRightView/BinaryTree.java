package Ch13.BinaryTreeRightView;

import java.util.*;

public class BinaryTree<T> {
	
	private Node root = null;
	
	private class Node {
		
		private Node left;
		private Node right;
		
		private final int element;
		
		private Node(int element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}
		
		private Node(Node left, Node right, int element) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
	
	private void buildTree() {

        root = new Node(40);
        root.left = new Node(47);
        root.right = new Node(45);
        root.left.left = new Node(11);
        root.left.right = new Node(3);
        root.right.left = new Node(44);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(5);
        root.left.right.right = new Node(9);
        root.left.left.left.left = new Node(2);
    }
	
	public void printRightViewIterative() {
		
		buildTree();
		printRightViewIterative(root);
	}
	
	private void printRightViewIterative(Node node) {
		
		if(root == null) {
			return;
		}
		
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		
		Node currentNode;
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			int i = 0;
			
			while(i < size) {
				
				i++;
				currentNode = queue.poll();
				
				if(i == size) {
					System.out.print(currentNode.element + " ");
				}
				
				if(currentNode.left != null) {
					queue.add(currentNode.left);
				}
				
				if(currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}
		}
	}
	
	public void printRightViewRecursive() {
		
		buildTree();
		
		Map<Integer, Integer> map = new HashMap<>();
		
		printRightViewRecursive(root, 1, map);
		
		for(int i = 1; i <= map.size(); i++) {
			System.out.print(map.get(i) + " ");
		}
	}
	
	private void printRightViewRecursive(Node root, int level, Map<Integer, Integer> map) {
		
		if(root == null) {
			return;
		}
		
		map.put(level, root.element);
		
		printRightViewRecursive(root.left, level + 1, map);
		printRightViewRecursive(root.right, level + 1, map);
	}
}
