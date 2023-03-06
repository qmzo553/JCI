package Ch9;

public class SwapBitsMain {

	public static void main(String[] args) {

		int number = 663;        

        int result = SwapBits.swap(number);
        
        System.out.println("Initial:\t\t" + Integer.toBinaryString(number));
        System.out.println("Swapped:\t\t" + Integer.toBinaryString(result));        

	}

}
