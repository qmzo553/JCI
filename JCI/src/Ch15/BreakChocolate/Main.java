package Ch15.BreakChocolate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = Chocolates.breakit(12, 10, 8);
        
        System.out.println("(-1: not possible; 0: no breaks needed; "
                + "1: one break; 2: two breaks): " + result);
	}

}
