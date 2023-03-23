package Ch12.ShortestSafeRoute;

import java.util.*;

public class Sensors {
	
	private Sensors() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	private static class Cell {
		
		int r;
		int c;
		int distance;
		
		Cell(int r, int c, int distance){
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
	};
	
	private static final int M = 10;
	private static final int N = 10;
	
	private static final int ROW_4[] = {-1, 0, 0, 1};
	private static final int COL_4[] = {0, -1, 1, 0};
	
	private static final int ROW_8[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static final int COL_8[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static int shortestPath(int[][] board) {
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < 8; k++) {
					if(board[i][j] == 0 && isValid(i + ROW_8[k], j + COL_8[k])
							&& board[i + ROW_8[k]][j + COL_8[k]] == 1) {
						board[i + ROW_8[k]][j + COL_8[k]] = -1;
					}
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			System.out.println();
			for(int j = 0; j < N; j++) {
				if(board[i][j] == -1) {
					board[i][j] = 0;
				}
				System.out.print(board[i][j] + " ");
			}
		}
		
		return findShortestPath(board);
	}
	
	private static int findShortestPath(int[][] board) {
		
		boolean[][] visited = new boolean[M][N];
		
		Queue<Cell> queue = new ArrayDeque<>();
		
		for(int r1 = 0; r1 < M; r1++) {
			
			if(board[r1][0] == 1) {
				queue.add(new Cell(r1, 0, 0));
				visited[r1][0] = true;
			}
		}
		
		while(!queue.isEmpty()) {
			
			int rIdx = queue.peek().r;
			int cIdx = queue.peek().c;
			int dist = queue.peek().distance;
			
			queue.poll();
			
			if(cIdx == N - 1) {
				return (dist + 1);
			}
			
			for(int k = 0; k < 4; k++) {
				if(isValid(rIdx + ROW_4[k], cIdx + COL_4[k])
						&& isSafe(board, visited, rIdx + ROW_4[k], cIdx + COL_4[k])) {
					visited[rIdx + ROW_4[k]][cIdx + COL_4[k]] = true;
					queue.add(new Cell(rIdx + ROW_4[k], cIdx + COL_4[k], dist + 1));
				}	
			}
		}
		
		return -1;
	}
	
	private static boolean isSafe(int[][] board, boolean visited[][], int r, int c) {
		return (board[r][c] == 1 && !visited[r][c]);
	}
	
	private static boolean isValid(int r, int c) {
		return (r < M && c < N && r >= 0 && c >= 0);
	}
}
