package Ch10.RotateMatrix;

public final class Arrays {
	
	private Arrays() {
		throw new AssertionError("Cannot be instantitaed");
	}
	
	public static int[][] rotateInNew(int[][] m) {

        if (m == null || m.length == 0) {
            throw new IllegalArgumentException("The given matrix cannot be null or empty");
        }

        if (m.length != m[0].length) {
            throw new IllegalArgumentException("The given matrix must be of type nxn");
        }

        int r[][] = new int[m.length][m.length];

        int offset = m.length - 1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                r[offset - j][i] = m[i][j];
            }
        }

        return r;
    }
	
	public static boolean rotateWithTranspose(int m[][]) {
		
		if(m == null || m.length == 0) {
			throw new IllegalArgumentException("The given matrix cannot ve null or empty");
		}
		
		if(m.length != m[0].length) {
			throw new IllegalArgumentException("The given matrix must be of type nxn");
		}
		
		transpose(m);
		
		for(int i = 0; i < m[0].length; i++) {
			for(int j = 0, k = m[0].length - 1; j < k; j++,k--) {
				int temp = m[j][i];
				m[j][i] = m[k][i];
				m[k][i] = temp;
			}
		}
		
		return true;
	}
	
	private static void transpose(int m[][]) {
		
		for(int i = 0; i < m.length; i++) {
			for(int j = i; j < m[0].length; j++) {
				int temp = m[j][i];
				m[j][i] = m[i][j];
				m[i][j] = temp;
			}
		}
	}
	
	public static boolean rotateRing(int[][] m) {
		
		if (m == null || m.length == 0) {
            throw new IllegalArgumentException("The given matrix cannot be null or empty");
        }

        if (m.length != m[0].length) {
            throw new IllegalArgumentException("The given matrix must be of type nxn");
        }
        
        int len = m.length;
        
        for(int i = 0; i < len / 2; i++) {
        	for(int j = i; j < len - i - 1; j++) {
        		
        		int temp = m[i][j];
        		
        		m[i][j] = m[j][len - 1 - i];
        		
        		m[j][len - 1 - i] = m[len - 1 - i][len - 1 - i];
        		
        		m[len - 1 - i][len - 1 - j] = m[len - 1 - j][i];
        		
        		m[len - 1 - j] [i] = temp;
        	}
        }
        
        return true;
	}
	
}
