package Ch13.BinaryTreeDistanceFromLeaf;

import java.util.*;

public class BinaryTree<T> {
	
	private Node root = null;
	
	private class Node{
		
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
	
	public void leafDistance(int dist) {
		
		buildTree();
		
		List<Node> pathToLeaf = new ArrayList<>();
		
		Set<Node> nodesAtDist = new HashSet<>();
		
		leafDistance(root, pathToLeaf, nodesAtDist, dist);
		
		for(Node nd: nodesAtDist) {
			System.out.print(nd.element + " ");
		}
	}
	
	private void leafDistance(Node node, List<Node> pathToLeaf, Set<Node> nodesAtDist, int dist) {
		
		if(node == null) {
			return;
		}
		
		if(isLeaf(node) && pathToLeaf.size() >= dist) {
			nodesAtDist.add(pathToLeaf.get(pathToLeaf.size() - dist));
			
			return;
		}
		
		pathToLeaf.add(node);
		
		leafDistance(node.left, pathToLeaf, nodesAtDist, dist);
		leafDistance(node.right, pathToLeaf, nodesAtDist, dist);
		
		pathToLeaf.remove(node);
	}
	
	private boolean isLeaf(Node node) {
		return (node.left == null && node.right == null);
	}
}
