package Ch9;

public class RotateBitsMain {

	public static void main(String[] args) {
		
		int number = 423099897;
        int bits = 10;

        int resultLeft = RotateBits.leftRotate(number, bits);
        int resultRight = RotateBits.rightRotate(number, bits);

        System.out.println("Initial:\t" + Integer.toBinaryString(number));
        System.out.println("Result-left:\t" + Integer.toBinaryString(resultLeft));
        
        System.out.println();

        System.out.println("Initial:\t" + Integer.toBinaryString(number));
        System.out.println("Result-right:\t" + Integer.toBinaryString(resultRight));
	}

}
