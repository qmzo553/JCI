package Ch13.BinarySearchSuccessor;

public class MAin {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        BinarySearchTree bt = new BinarySearchTree();

        bt.buildTreeSample();
        
        bt.inOrderSuccessor();
        bt.preOrderSuccessor();
        bt.postOrderSuccessor();
	}
}
