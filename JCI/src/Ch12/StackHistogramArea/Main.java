package Ch12.StackHistogramArea;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int[] histogram = {4, 2, 8, 6, 5, 3};
        
        int ma = Stacks.maxAreaUsingStack(histogram);
        
        System.out.println("Max area: " + ma);
	}

}
