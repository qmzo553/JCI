package Ch10.TrapRainWater;

import java.util.*;

public final class Bars {
	
	private Bars() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int trapViaArray(int[] bars) {
		
		if(bars == null || bars.length == 0) {
			return 0;
		}
		
		int n = bars.length - 1;
		int water = 0;
		
		int[] left = new int[n];
		left[0] = Integer.MIN_VALUE;
		
		for(int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], bars[i - 1]);
		}
		
		int right = Integer.MIN_VALUE;
		
		for(int i = n - 1; i >= 1; i--) {
			
			right = Math.max(right, bars[i + 1]);
			
			if(Math.min(left[i], right) > bars[i]) {
				water += Math.min(left[i], right) - bars[i];
			}
		}
		
		return water;
	}
	
	public static int trapViaStack(int[] bars) {
		
		if(bars == null || bars.length == 0) {
			return 0;
		}
		
		int water = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < bars.length; i++) {
			
			while(!stack.empty() && bars[i] > bars[stack.peek()]) {
				
				int topBar = stack.pop();
				
				if(stack.empty()) {
					continue;
				}
				
				int width = i - stack.peek() - 1;
				int height = Math.min(bars[i], bars[stack.peek()]) - bars[topBar];
				
				water += width * height;
			}
			
			stack.push(i);
		}
		
		return water;
	}
	
	public static int trapOptimized(int[] bars) {
		
		int left = 0;
		int right = bars.length - 1;
		
		int water = 0;
		
		int maxBarLeft = bars[left];
		int maxBarRight = bars[right];
		
		while(left < right) {
			
			if(bars[left] <= bars[right]) {
				left++;
				maxBarLeft = Math.max(maxBarLeft, bars[left]);
				water += (maxBarLeft - bars[left]);
			} else {
				right--;
				maxBarRight = Math.max(maxBarRight, bars[right]);
				water += (maxBarRight - bars[right]);
			}
		}
		
		return water;
	}
}
