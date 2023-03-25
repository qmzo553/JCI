package Ch13.BinaryTreeSpiralTraversal;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        
        bt.insert(47);
        bt.insert(45);
        
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
        bt.insert(5);
        
        bt.insert(21);
        bt.insert(23);
        bt.insert(4);
        bt.insert(1);
        bt.insert(2);
        bt.insert(6);
        bt.insert(77);
        bt.insert(87);
        
        bt.insert(1);
        bt.insert(5);
        bt.insert(8);
          
        bt.spiralOrderTraversalRecursive();
        System.out.println();
        bt.spiralOrderTraversalTwoStacks();
        System.out.println();
        bt.spiralOrderTraversalDeque();
	}

}
