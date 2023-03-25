package Ch13.BinarySearchTreeKthLargestElement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        
        bt.insert(40);
        bt.insert(30);
        bt.insert(45);
        bt.insert(15);
        bt.insert(33);
        bt.insert(42);
        bt.insert(56);
        bt.insert(5);
        bt.insert(17);
        bt.insert(41);
        bt.insert(67);             

        bt.kthLargest(3);
	}

}
