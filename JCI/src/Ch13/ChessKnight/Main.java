package Ch13.ChessKnight;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChessKnight ck = new ChessKnight();

        int movesNr = ck.countknightMoves(0, 7, 7, 0, 8);

        System.out.println("Minimum number of needed moves: " + movesNr);
	}

}
