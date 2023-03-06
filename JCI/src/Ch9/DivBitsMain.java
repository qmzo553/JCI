package Ch9;

public class DivBitsMain {

	public static void main(String[] args) {
		
		int q = 23;
        int p = 7;

        long result1 = DivBits.divideWithRemainder(q, p);        
        System.out.println(q + "(" + Long.toBinaryString(q) + ")" + " / "
                + p + "(" + Long.toBinaryString(p) + ")" + " = " + result1
                + "(" + Long.toBinaryString(result1) + ")");
        
        System.out.println("-------------------------------------------------");
        
        long result2 = DivBits.divideWithoutRemainder(q, p);
        System.out.println(q + "(" + Long.toBinaryString(q) + ")" + " / "
                + p + "(" + Long.toBinaryString(p) + ")" + " = " + result2
                + "(" + Long.toBinaryString(result2) + ")");        

	}

}
