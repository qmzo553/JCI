package Ch13.TwoBinaryTreesAreIsomorphic;

public class BinaryTree {
	
	private Node rootOne = null;
	private Node rootTwo = null;
	
	private class Node {
		
		private Node left;
		private Node right;
		
		private final String element;
		
		private Node(String element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}
		
		private Node(Node left, Node right, String element) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
	
	private void shapeTwoIsomorphicTrees() {
		rootOne = new Node("A");
        Node nOne1 = new Node("B");
        Node nOne2 = new Node("C");
        Node nOne3 = new Node("D");
        Node nOne4 = new Node("E");
        Node nOne5 = new Node("G");
        Node nOne6 = new Node("F");
        Node nOne7 = new Node("H");

        rootOne.left = nOne1;
        rootOne.right = nOne2;
        nOne1.left = nOne3;
        nOne1.right = nOne4;
        nOne2.left = nOne5;
        nOne4.left = nOne6;
        nOne5.left = nOne7;

        rootTwo = new Node("A");
        Node nTwo1 = new Node("C");
        Node nTwo2 = new Node("B");
        Node nTwo3 = new Node("G");
        Node nTwo4 = new Node("E");
        Node nTwo5 = new Node("D");
        Node nTwo6 = new Node("H");
        Node nTwo7 = new Node("F");

        rootTwo.left = nTwo1;
        rootTwo.right = nTwo2;
        nTwo1.left = nTwo3;
        nTwo2.left = nTwo4;
        nTwo2.right = nTwo5;
        nTwo3.right = nTwo6;
        nTwo4.left = nTwo7;
	}
	
	public boolean isIsomorphic() {
		
		shapeTwoIsomorphicTrees();
		
		return isIsomorphic(rootOne, rootTwo);
	}
	
	private boolean isIsomorphic(Node treeOne, Node treeTwo) {
		
		if(treeOne == null && treeTwo == null) {
			return true;
		}
		
		if((treeOne == null || treeTwo == null)) {
			return false;
		}
		
		if(!treeOne.element.equals(treeTwo.element)) {
			return false;
		}
		
		return (isIsomorphic(treeOne.left, treeTwo.right)
				&& isIsomorphic(treeOne.right, treeTwo.left)
				|| isIsomorphic(treeOne.left, treeTwo.left)
				&& isIsomorphic(treeOne.right, treeTwo.right));
				
	}
}
