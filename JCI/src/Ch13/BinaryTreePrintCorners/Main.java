package Ch13.BinaryTreePrintCorners;

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
        bt.insert(23);
        bt.insert(2);
        bt.insert(4);
        bt.insert(1);        
                          
        bt.printCorners();                        
	}

}
