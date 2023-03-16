package Ch10.TrapRainWater;

public class Main {

	public static void main(String[] args) {

		int[] bars = {1, 0, 0, 4, 0, 2, 0, 1, 6, 2, 3};
		
		int water1 = Bars.trapViaArray(bars);
        int water2 = Bars.trapViaStack(bars);
        int water3 = Bars.trapOptimized(bars);
        System.out.println("Result: " + water1 + " | " + water2 + " | " + water3);
	}

}
