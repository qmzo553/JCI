package Ch10.matrixWithZeros;

public final class Arrays {
	
	private Arrays() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static void alignZeros(int[][] m) {
		if(m == null || m.length == 0) {
			throw new IllegalArgumentException("The given matrix cannot be null or empty");
		}
	
		boolean firstRowHasZeros = false;
		boolean firstColumnHasZeros = false;
		
		for(int j = 0; j < m[0].length; j++) {
			if(m[0][j] == 0) {
				firstRowHasZeros = true;
				break;
			}
		}
		
		for(int i = 0; i < m.length; i++) {
			if(m[i][0] == 0) {
				firstColumnHasZeros = true;
				break;
			}
		}
		
		for(int i = 1; i < m.length; i++) {
			for(int j = 1; j < m[0].length; j++) {
				if(m[i][j] == 0) {
					m[i][0] = 0;
					m[0][j] = 0;
				}
			}
		}
		
		for (int i = 1; i < m.length; i++) {
            if (m[i][0] == 0) {
                setRowOfZero(m, i);
            }
        }
		
		for(int j = 1; j < m[0].length; j++) {
			if(m[0][j] == 0) {
				setColumnOfZero(m, j);
			}
		}
		
		if(firstRowHasZeros) {
			setRowOfZero(m, 0);
		}
		
		if(firstColumnHasZeros) {
			setColumnOfZero(m, 0);
		}
	}
	
	private static void setRowOfZero(int[][] m, int r) {
		for(int j = 0; j < m[0].length; j++) {
			m[r][j] = 0;
		}
	}
	
	private static void setColumnOfZero(int[][]m, int c) {
		for(int i = 0; i < m.length; i++) {
			m[i][c] = 0;
		}
	}
	
	
}
