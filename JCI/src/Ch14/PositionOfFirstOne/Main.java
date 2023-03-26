package Ch14.PositionOfFirstOne;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] zerosAndOnes = {0, 0, 1, 1, 1, 1, 1};

        int index = Arrays.firstOneIndex(zerosAndOnes);
        System.out.println("Index: " + index);
	}

}
