package Ch9;

import java.util.*;

public class SetsMain {

	public static void main(String[] args) {
		
		char[] set = {'a', 'b', 'c'};
        
        Set<Set<Character>> subsets = Sets.powerSet(set);
        
        System.out.println("Result: " + subsets);

	}

}
