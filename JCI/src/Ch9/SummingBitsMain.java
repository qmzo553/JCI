package Ch9;

public class SummingBitsMain {

	public static void main(String[] args) {
		
		int q = 23;
		int p = 45;
		
		int result = SummingBits.sum(q, p);
		
		System.out.println(q + "(" + Integer.toBinaryString(q) + ")" + " + "
                + p + "(" + Integer.toBinaryString(p) + ")" + " = " + result
                + "(" + Integer.toBinaryString(result) + ")");

		System.out.println();
	}

}
