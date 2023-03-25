package Ch13.ListPerBinaryTreeLevel;

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
	
	public List<List<T>> fetchAllLevels() {
		
		if(root == null) {
			return Collections.emptyList();	
		}
		
		List<List<T>> allLevels = new ArrayList<>();
		
		Queue<Node> currentLevelOfNodes = new ArrayDeque<>();
		List<T> currentLevelOfElements = new ArrayList<>();
		
		currentLevelOfNodes.add(root);
		currentLevelOfElements.add(root.element);
		
		while(!currentLevelOfNodes.isEmpty()) {
			
			Queue<Node> previousLevelOfNodes = currentLevelOfNodes;
			allLevels.add(currentLevelOfElements);
			
			currentLevelOfNodes = new ArrayDeque<>();
			currentLevelOfElements = new ArrayList<>();
			
			for(Node parent : previousLevelOfNodes) {
				
				if(parent.left != null) {
					currentLevelOfNodes.add(parent.left);
					currentLevelOfElements.add(parent.left.element);
				}
				
				if(parent.right != null) {
					currentLevelOfNodes.add(parent.right);
					currentLevelOfElements.add(parent.right.element);
				}
			}
		}
		
		return allLevels;
	}
}
