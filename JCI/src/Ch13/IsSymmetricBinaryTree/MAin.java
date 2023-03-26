package Ch13.IsSymmetricBinaryTree;

public class MAin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);
        bt.insert(47);
        bt.insert(47);
        bt.insert(11);
        bt.insert(3);
        bt.insert(3);
        bt.insert(11);

        System.out.println("Symmetry check recursive: " + bt.isSymmetricRecursive());
        System.out.println("Symmetry check iterative: " + bt.isSymmetricIterative());
	}

}
