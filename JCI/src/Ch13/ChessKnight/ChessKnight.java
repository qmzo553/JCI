package Ch13.ChessKnight;

import java.util.*;

public class ChessKnight {
	
	private class Node {
		
		private final int r;
		private final int c;
		private int distance;
		
		private Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		private Node(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
	}
	
	private static final int[] ROW = {2, 2, -2, -2, 1, 1, -1, -1};
	private static final int[] COL = {-1, 1, 1, -1, 2, -2, 2, -2};
	
	public int countknightMoves(int rs, int cs, int rt, int ct, int n) {
		
		Node startCell = new Node(rs, cs);
		
		Node targetCell = new Node(rt, ct);
		
		return countknightMoves(startCell, targetCell, n);
	}
	
	private int countknightMoves(Node startCell, Node targetCell, int n) {
		
		Set<Node> visited = new HashSet<>();
		
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(startCell);
		
		while(!queue.isEmpty()) {
			
			Node cell = queue.poll();
			
			int r = cell.r;
			int c = cell.c;
			int distance = cell.distance;
			
			if(r == targetCell.r && c == targetCell.c) {
				return distance;
			}
			
			if(!visited.contains(cell)) {
				visited.add(cell);
				
				for(int i = 0; i < 8; ++i) {
					
					int rt = r + ROW[i];
					int ct = c + COL[i];
					
					if(valid(rt, ct, n)) {
						queue.add(new Node(rt, ct, distance + 1));
					}
				}
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	private static boolean valid(int r, int c, int n) {
		
		if(r < 0 || c < 0 || r >= n || c >= n) {
			return false;
		}
		
		return true;
	}
}
