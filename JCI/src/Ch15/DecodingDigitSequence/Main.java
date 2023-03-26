package Ch15.DecodingDigitSequence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
char digits[] = {'1', '2', '3', '2', '1', '1'};                
        
        System.out.println("Recursive approach: " + Digits.decoding(digits, digits.length));
        System.out.println("DP approach: " + Digits.decoding(digits));
	}

}
