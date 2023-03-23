package Ch12.StockSpan;

import java.util.Stack;

public class StockSpan {
	
	private StockSpan() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int[] stockSpan(int[] stockPrices) {
		
		if(stockPrices == null) {
			throw new IllegalArgumentException("Prices array cannot be null");
		}
		
		Stack<Integer> dayStack = new Stack();
		int[] spanResult = new int[stockPrices.length];
		
		spanResult[0] = 1;
		dayStack.push(0);
		
		for(int i = 1; i < stockPrices.length; i++) {
			
			while(!dayStack.empty() && stockPrices[i] > stockPrices[dayStack.peek()]) {
				dayStack.pop();
			}
			
			if(dayStack.empty()) {
				spanResult[i] = i + 1;
			} else {
				spanResult[i] = i - dayStack.peek();
			}
			
			dayStack.push(i);
		}
		
		return spanResult;
	}
}
