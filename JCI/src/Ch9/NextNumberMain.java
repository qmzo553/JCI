package Ch9;

public class NextNumberMain {

	public static void main(String[] args) {
		int number = 124344;      
        
        int resultNext = NextNumber.next(number);
        int resultPrev = NextNumber.previous(number);

        System.out.println("Number:\t\t" + number + "\t" + Integer.toBinaryString(number));
        System.out.println("Next:\t\t" + resultNext + "\t" + Integer.toBinaryString(resultNext));
        System.out.println("Previous:\t" + resultPrev + "\t" + Integer.toBinaryString(resultPrev));
	}

}
