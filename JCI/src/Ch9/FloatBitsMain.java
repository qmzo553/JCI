package Ch9;

public class FloatBitsMain {

	public static void main(String[] args) {

		float n = -404.0324f;

        int tobinary = FloatBits.toBinary(n);
        float tofloat = FloatBits.toFloat(tobinary);
        
        System.out.println("N:      " + n);
        System.out.println();
        
        System.out.println("Result: " + Integer.toBinaryString(tobinary));
        System.out.println("Test:   " + Integer.toBinaryString(Float.floatToRawIntBits(n)));

        System.out.println("Float:  " + tofloat);

	}

}
