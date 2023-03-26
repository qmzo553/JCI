package Ch13.BinaryTreeIsBST;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);
        bt.insert(35);
        bt.insert(45);
        bt.insert(30);
        bt.insert(37);
        bt.insert(44);
        bt.insert(48);
        bt.insert(20);               

        System.out.println("\n\nTraversal LEVEL: ");
        bt.print();

        System.out.println("\n\nIs this binary tree BST: " + bt.isBinarySearchTree()); 
	}

}