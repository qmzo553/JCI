package Ch8;

import java.util.*;

public class FiveTowerMain {

	public static void main(String[] args) {
		
		Set<Integer[]> solutions = new HashSet<>();
		
		FiveTower.buildTowers(0, new Integer[FiveTower.GRID_SIZE], solutions);
		
		System.out.println("Solutions : ");
		for(Integer[] solution : solutions) {
			System.out.println(Arrays.toString(solution));
		}
	}

}
