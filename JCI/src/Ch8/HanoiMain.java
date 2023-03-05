package Ch8;

public class HanoiMain {
	
	public static void main(String[] args) {
		int n = 4;
		
		Hanoi.moveDisks(n, 'A', 'C', 'B');
	}
}
