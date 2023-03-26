package Ch14.WordSearch;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board
        = {
            {'T', 'A', 'C'},
            {'A', 'B', 'L'},
            {'X', 'I', 'E'}
        };               

		boolean resultTable = Words.exist(board, "TABLE");
		boolean resultTaxi = Words.exist(board, "TAXI");

		System.out.println("Found 'TABLE'? " + resultTable);
		System.out.println("Found 'TAXI'? " + resultTaxi);
	}

}
