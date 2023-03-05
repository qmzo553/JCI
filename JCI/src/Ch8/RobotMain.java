package Ch8;

import java.awt.Point;
import java.util.*;

public class RobotMain {

	public static void main(String[] args) {
		Set<Point> path = new LinkedHashSet<>();
		
		boolean[][] maze = new boolean[6][6];
		maze[2][0] = true;
		maze[3][0] = true;
		maze[3][1] = true;
		maze[3][2] = true;
		maze[3][3] = true;
		
		RobotGrid.computePath(5, 5, maze, path);
		
		System.out.println("Computed path (plain recursion) :");
		path.forEach(System.out::println);
		
		Set<Point> visited = new HashSet<>();
		
		RobotGrid.computePath(5,  5, maze, path, visited);
		
		System.out.println("\nComputed path (Memoziation) : ");
		path.forEach(System.out::println);
	}

}
