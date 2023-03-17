package Ch10.ReplaceElementWithRank;

public class Main {

	public static void main(String[] args) {

		int[] m = {7, 11, -5, 13, 15, -4, -3, -2, 0, 14, 3, 42};

        System.out.println("Before: " + java.util.Arrays.toString(m));
        
        Arrays.replace(m);
        
        System.out.println("After: " + java.util.Arrays.toString(m));

	}

}
