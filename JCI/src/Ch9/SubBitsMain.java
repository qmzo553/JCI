package Ch9;

public class SubBitsMain {

	public static void main(String[] args) {
		
		int q = 124;
		int p = 29;
		
		int result = SubBits.subtract(q, p);
		
		System.out.println(q + "(" + Integer.toBinaryString(q) + ")" + " - "
                + p + "(" + Integer.toBinaryString(p) + ")" + " = " + result
                + "(" + Integer.toBinaryString(result) + ")");

        System.out.println();
	}

}
