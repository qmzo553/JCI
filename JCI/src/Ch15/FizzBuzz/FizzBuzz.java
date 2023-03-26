package Ch15.FizzBuzz;

public final class FizzBuzz {

	private FizzBuzz() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static void print(int n) {
		
		for(int i = 1; i <= n; i++) {
			if(((i % 5) == 0) && ((i % 7) == 0)) {
				System.out.println("fizzbuzz");
			} else if((i % 5) == 0) {
				System.out.println("fizz");
			} else if((i % 7) == 0) {
				System.out.println("buzz");
			} else {
				System.out.println(i);
			}
		}
	}
}
