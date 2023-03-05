package Ch8;

public class JosephusMain {

	public static void main(String[] args) {
		int n = 15;
		int k = 3;
		
		System.out.println("Using recursion! Survivor : " + Josephus.josephus(n, k) + "\n");
		Josephus.printJosephus(n, k);

	}

}
