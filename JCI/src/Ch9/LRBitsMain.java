package Ch9;

public class LRBitsMain {

	public static void main(String[] args) {

		int left = 3;
        int right = 7;

        int result = LRBits.setBetween(left, right);
        System.out.println("Result: " + result
                + "(" + Integer.toBinaryString(result) + ")");

	}

}
