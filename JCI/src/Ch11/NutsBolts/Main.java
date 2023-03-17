package Ch11.NutsBolts;

public class Main {

	public static void main(String[] args) {

		char[] nuts = {'$', '%', '&', 'x', '@'};
        char[] bolts = {'%', '@', 'x', '$', '&'};
        
        NutsBolts.match(nuts, bolts);

	}

}
