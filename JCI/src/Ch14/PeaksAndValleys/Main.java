package Ch14.PeaksAndValleys;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] integers = {4, 5, 8, 3, 2, 1, 7, 8, 5, 9};

        System.out.println("Before sorting: " + Arrays.toString(integers));
        PeaksValleys.sort(integers);
        System.out.println("After sorting: " + Arrays.toString(integers));
	}

}
