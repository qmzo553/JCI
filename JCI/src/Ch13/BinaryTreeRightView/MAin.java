package Ch13.BinaryTreeRightView;

public class MAin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
        
        System.out.println("Iterative approach:");
        bt.printRightViewIterative();
        
        System.out.println("\n\nRecursive approach:");
        bt.printRightViewRecursive();
	}

}
