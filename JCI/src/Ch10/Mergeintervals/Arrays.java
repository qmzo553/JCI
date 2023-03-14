package Ch10.Mergeintervals;

import java.util.*;

public final class Arrays {
	
	private Arrays() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static void mergeIntervals(Interval[] intervals) {
		
		if(intervals == null) {
			throw new IllegalArgumentException("The given array of intervals cannot be null");
		}
		
		java.util.Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		Stack<Interval> stackOfIntervals = new Stack();
		
		for(Interval interval : intervals) {
			
			if(stackOfIntervals.empty() || interval.start > stackOfIntervals.peek().end) {
				stackOfIntervals.push(interval);
			}
			
			if(stackOfIntervals.peek().end < interval.end) {
				stackOfIntervals.peek().end = interval.end;
			}
		}
		
		while(!stackOfIntervals.empty()) {
			System.out.print(stackOfIntervals.pop() + " ");
		}
	}
	
	public static void mergeIntervalsOptimized(Interval intervals[]) {
		
		if(intervals == null) {
			throw new IllegalArgumentException("The given array of intervals cannot be null");
		}
		
		java.util.Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i2.start - i1.start;
			}
		});
		
		int index = 0;
		
		for(int i = 0; i < intervals.length; i++) {
			
			if(index != 0 && intervals[index - 1].start <= intervals[i].end) {
				while(index != 0 && intervals[index - 1].start <= intervals[i].end) {
					
					intervals[index - 1].end = Math.max(intervals[index - 1].end, intervals[i].end);
					intervals[index - 1].start = Math.min(intervals[index - 1].start, intervals[i].start);
					
					index --;
				}
			} else {
				intervals[index] = intervals[i];
			}
			
			index++;
		}
		
		for(int i = 0; i < index; i++) {
			System.out.print(intervals[i] + " ");
		}
	}
}
