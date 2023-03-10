package Ch8;

public class SubsetsMain {

	public static void main(String[] args) {
		
		int[] arr = {5, 1, 6, 10, 7, 11, 2};
		
		int[] subset = new int[arr.length];
		
		System.out.println("Recursive approavch : ");
		Subsets.findSumRecursive(arr, 0, 0, 9, subset);
		
		System.out.println("\n\nDynamic Programming approach : ");
		Subsets.findSumDP(arr, 9);

	}

}
