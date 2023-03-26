package Ch14.UnknownSizeList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] slArr = {-2, 3, 12, 14, 16, 22, 23, 27};
        SizelessList sl = new SizelessList(slArr);               
        
        System.out.println("Search 2: " + UnknownSizeList.search(sl, 3));
        System.out.println("Search 23: " +UnknownSizeList.search(sl, 23));
        System.out.println("Search 1: " +UnknownSizeList.search(sl, 1));
	}

}
