package Ch8;

import java.util.Random;

public class ColorSpotMain {

	public static void main(String[] args) {
		
		int cols = 5;
		int rows = 5;
		int colors = 3;
		
		Random rnd = new Random();
		
		int[][] a = new int[rows][cols];
		
		for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = 1 + rnd.nextInt(colors);
            }
        }
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print("a[i][j]" + " ");
			}
			System.out.println();
		}
		
		ColorSpot spots = new ColorSpot();
		spots.determineBiggestColorSpot(cols, rows, a);
	}

}
