package Ch15.VisitToggle100Doors;

public final class Doors {
	
	private static final int DOORS = 100;
	
	private Doors() {
		throw new AssertionError("Cannot be instantiated");
	}
	
	public static int[] visitToggle() {
		
		int[] doors = new int[DOORS];
		
		for(int i = 0; i <= (DOORS - 1); i++) {
			doors[i] = 0;
		}
		
		for(int i = 0; i <= (DOORS - 1); i++) {
			for(int j = 0; j <= (DOORS - 1); j++) {
				
				if((j + 1) % (i + 1) == 0) {
					if(doors[i] == 0) {
						doors[j] = 1;
					} else {
						doors[j] = 0;
					}
				}
			}
		}
		
		return doors;
	}
}
