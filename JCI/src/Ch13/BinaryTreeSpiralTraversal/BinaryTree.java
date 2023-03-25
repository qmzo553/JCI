package Ch13.BinaryTreeSpiralTraversal;

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
	
	public void spiralOrderTraversalRecursive() {
		
		if(root == null) {
			return;
		}
		
		int level = 1;
		boolean flip = false;
		
		while(printLevel(root, level++, flip = !flip)) {
			
		};
	}
	
	private boolean printLevel(Node root, int level, boolean flip) {
		
		if(root == null) {
			return false;
		}
		
		if(level == 1) {
			System.out.print(root.element + " ");
			return true;
		}
		
		if(flip) {
			boolean left = printLevel(root.left, level - 1, flip);
			boolean right = printLevel(root.right, level - 1, flip);
			
			return left || right;
		} else {
			boolean right = printLevel(root.right, level - 1, flip);
			boolean left = printLevel(root.left, level - 1, flip);
			
			return right || left;
		}
	}
	
	public void spiralOrderTraversalTwoStacks() {
		
		if(root == null) {
			return;
		}
		
		printSpiralTwoStacks(root);
	}
	
	private void printSpiralTwoStacks(Node node) {
		
		if(node == null) {
			return;
		}
		
		Stack<Node> rl = new Stack<>();
		Stack<Node> lr = new Stack<>();
		
		rl.push(node);
		
		while(!rl.empty() || !lr.empty()) {
			while(!rl.empty()) {
				
				Node temp = rl.peek();
				rl.pop();
				
				System.out.print(temp.element + " ");
				
				if(temp.right != null) {
					lr.push(temp.right);
				}
				
				if(temp.left != null) {
					lr.push(temp.left);
				}
			}
			
			while(!lr.empty()) {
				Node temp = lr.peek();
				lr.pop();
				
				System.out.print(temp.element + " ");
				
				if(temp.left != null) {
					rl.push(temp.left);
				}
				
				if(temp.right != null) {
					rl.push(temp.right);
				}
			}
		}
	}
	
	public void spiralOrderTraversalDeque() {
		
		if(root == null) {
			return;
		}
		
		printSpiralDeque(root);
	}
	
	private void printSpiralDeque(Node root) {
		
		if(root == null) {
			return;
		}
		
		Deque<Node> deque = new ArrayDeque<>();
		
		deque.addFirst(root);
		
		boolean oddEvenFlag = false;
		
		while(!deque.isEmpty()) {
			
			int nodesNo = deque.size();
			
			if(oddEvenFlag) {
				while(nodesNo > 0) {
					
					Node currentNode = deque.pollFirst();
					
					System.out.print(currentNode.element + " ");
					
					if(currentNode.left != null) {
						deque.addLast(currentNode.left);
					}
					
					if(currentNode.right != null) {
						deque.addLast(currentNode.right);
					}
					
					nodesNo--;
				}
			} else {
				
				while(nodesNo > 0) {
					
					Node currentNode = deque.pollLast();
					
					System.out.print(currentNode.element + " ");
					
					if(currentNode.right != null) {
						deque.addFirst(currentNode.right);
					}
					
					if(currentNode.left != null) {
						deque.addFirst(currentNode.left);
					}
					
					nodesNo--;
				}
			}
			
			oddEvenFlag = !oddEvenFlag;
		}
	}
}
