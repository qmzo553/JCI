package Ch13.BinaryTreePrintDiagonal;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(1);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(31);
        bt.insert(44);
        bt.insert(52);
        bt.insert(12);
        bt.insert(9);
        bt.insert(5);
        bt.insert(45);
        bt.insert(2);
        bt.insert(1);
        bt.insert(7);
        bt.insert(9);
          
        System.out.println("Recursive approach:");
        bt.printDiagonalRecursive();
        
        System.out.println();
        
        System.out.println("Iterative approach:");
        bt.printDiagonalIterative();
	}

}
