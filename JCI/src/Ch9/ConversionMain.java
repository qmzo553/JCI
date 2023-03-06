package Ch9;

public class ConversionMain {

	public static void main(String[] args) {
		
		int q = 290932;
		int p = 352345;
	
		int result = Conversion.count(q, p);
	
		System.out.println("q: " + Integer.toBinaryString(q));
		System.out.println("p: " + Integer.toBinaryString(p));
	
		System.out.println("\nResult: " + result);

	}

}
