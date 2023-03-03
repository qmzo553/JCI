package Ch8;

public class RobotGridMain {
	
	public static void main(String[] args) {
		int result1 = RobotGrid.countPaths(6, 6);
		int result2 = RobotGrid.countPathsBottomUp(6, 6);
		
		System.out.println("Number of unique paths via plain recursion : " + result1);
		System.out.println("Number of unique paths via Bottom up : " + result2);
	}
}
