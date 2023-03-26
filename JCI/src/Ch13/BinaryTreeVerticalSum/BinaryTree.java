package Ch13.BinaryTreeVerticalSum;

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

        root = new Node(21);
        root.left = new Node(14);
        root.right = new Node(45);
        root.left.left = new Node(7);
        root.left.right = new Node(3);
        root.left.left.left = new Node(5);
        root.left.left.right = new Node(2);
        root.right.right = new Node(44);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(6);
        root.right.right.left.left = new Node(11);
    }
	
	public void verticalSum() {
		
		buildTree();
		
		Map<Integer, Integer> map = new TreeMap<>();
		
		verticalSum(root, map, 0);
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}
	
	private void verticalSum(Node root, Map<Integer, Integer> map, int dist) {
		
		if(root == null) {
			return;
		}
		
		if(!map.containsKey(dist)) {
			map.put(dist, 0);
		}
		
		map.put(dist, map.get(dist) + root.element);
	
		verticalSum(root.left, map, dist - 1);
		verticalSum(root.right, map, dist + 1);
	}
}
