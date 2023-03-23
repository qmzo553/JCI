package Ch12.QueueIslands;

import java.util.*;

public final class Queues {
	
	private Queues() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	private static class Cell {
		
		int r, c;
		
		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static final int POSSIBLE_MOVEMENTS = 8;
	
	private static final int[] ROW = {-1, -1, -1, 0, 1, 0, 1, 1};
	private static final int[] COL = {-1, 1, 0, -1, -1, 1, 0, 1};
	
	public static int islands(int[][] matrix) {
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean[][] flagged = new boolean[m][n];
		
		int island = 0;
		for(int i = 0; i < m; i++) {
			for(int  j = 0; j < n; j++) {
				
				if(matrix[i][j] == 1 && !flagged[i][j]) {
					resolve(matrix, flagged, i, j);
					island++;
				}
			}
		}
		
		return island;
	}
	
	private static void resolve(int[][] matrix, boolean[][] flagged, int i, int j) {
		
		Queue<Cell> queue = new ArrayDeque<>();
		queue.add(new Cell(i,j));
		
		flagged[i][j] = true;
		
		while(!queue.isEmpty()) {
			
			int r = queue.peek().r;
			int c = queue.peek().c;
			queue.poll();
			
			for(int k = 0; k < POSSIBLE_MOVEMENTS; k++) {
				if(isValid(matrix, r + ROW[k], c + COL[k], flagged)) {
					flagged[r + ROW[k]][c + COL[k]] = true;
					queue.add(new Cell(r + ROW[k], c + COL[k]));
				}
			}
		}
	}
	
	private static boolean isValid(int[][] matrix, int r, int c, boolean[][] flagged) {
		return (r >= 0) && (r < flagged.length) && (c >= 0) && (c < flagged.length) && (matrix[r][c] == 1  && !flagged[r][c]);
	}
}
