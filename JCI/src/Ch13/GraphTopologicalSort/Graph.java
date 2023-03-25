package Ch13.GraphTopologicalSort;

import java.util.*;

public class Graph<T> {
	
	private final Map<T, List<T>> adjacencyList;
	
	public Graph() {
		this.adjacencyList = new HashMap<>();
	}
	
	public boolean addEdge(T from, T to) {
		
		if(from == null || to == null) {
			return false;
		}
		
		List<T> adjacents = adjacencyList.get(from);
		
		if(adjacents == null) {
			
			List list = new ArrayList<>();
			list.add(to);
			
			adjacencyList.put(from, list);
		} else {
			adjacents.add(to);
		}
		
		return true;
	}
	
	public Stack<T> topologicalSort(T startElement) {
		
		Set<T> visited = new HashSet<>();
		Stack<T> stack = new Stack<>();
		topologicalSort(startElement, visited, stack);
		
		return stack;
	}
	
	private void topologicalSort(T currentElement, Set<T> visited, Stack<T> stack ) {
		
		visited.add(currentElement);
		
		List<T> adjacents = adjacencyList.get(currentElement);
		if(adjacents != null) {
			for(T t : adjacents) {
				if(t != null && !visited.contains(t)) {
					topologicalSort(t, visited, stack);
					visited.add(t);
				}
			}
		}
		
		stack.push(currentElement);
	}
}
