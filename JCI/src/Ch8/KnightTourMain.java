package Ch8;

public class KnightTourMain {
	
	public static final int GRID_SIZE = 5;

	public static void main(String[] args) {
		
		KnightTour knightTour = new KnightTour(GRID_SIZE);
		
		int visited[][] = new int[GRID_SIZE][GRID_SIZE];
		
		int cell = 1;
		
		knightTour.knightTour(0, 0, cell, visited);
	}

}
