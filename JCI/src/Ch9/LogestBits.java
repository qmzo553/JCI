package Ch9;

public class LogestBits {

	public static void main(String[] args) {
		int n = 67;
		

        int result = LongestBits.sequence(n);

        System.out.println("A sequence of 101 is considered 111!");
        System.out.println("The longest sequence of 1 in "
                + Integer.toBinaryString(n) + " is equal to " + result);

	}

}
