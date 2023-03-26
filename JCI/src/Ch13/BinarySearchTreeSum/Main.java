package Ch13.BinarySearchTreeSum;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bt = new BinarySearchTree();
        
        bt.insert(50);
        bt.insert(45);
        bt.insert(62);
        bt.insert(43);
        bt.insert(46);
        bt.insert(68);
        bt.insert(6);
        bt.insert(49);
        bt.insert(65);
        bt.insert(71);       
                  
        boolean found1 = bt.findPairSumHashing(133);
        boolean found2 = bt.findPairSumTwoStacks(133);
        System.out.println("\nPair found? " + found1 + "  |  " + found2);
	}

}
