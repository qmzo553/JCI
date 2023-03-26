package Ch14.GroupSortAnagrams;

import java.util.*;

public class Anagrams implements Comparator<String> {
	
	private final static int RANGE_a_z = 26;
	
	@Override
	public int compare(String word1, String word2) {
		return sortWordChars(word1).compareTo(sortWordChars(word2));
	}
	
	public void printAnagrams(String words[]) {
		
		Map<String, List<String>> result = new HashMap<>();
		
		for(int i = 0; i < words.length; i++) {
			
			String word = words[i];
			String sortedWord = sortWordChars(word);
			
			if(result.containsKey(sortedWord)) {
				result.get(sortedWord).add(word);
			} else {
				List<String> anagrams = new ArrayList<>();
				anagrams.add(word);
				result.put(sortedWord, anagrams);
			}
		}
		
		System.out.println(result.values());
	}
	
	public void printAnagramsOptimized(String[] words) {
		
		Map<String, List<String>> result = new HashMap<>();
		
		for(int i = 0; i < words.length; i++) {
			
			String word = words[i];
			char[] wordToChar = new char[RANGE_a_z];
			
			for(int j = 0; j < word.length(); j++) {
				wordToChar[word.charAt(j) - 'a']++;
			}
			
			String computedWord = String.valueOf(wordToChar);
			
			if(result.containsKey(computedWord)) {
				result.get(computedWord).add(word);
			} else {
				List<String> anagrams = new ArrayList<>();
				anagrams.add(word);
				result.put(computedWord, anagrams);
			}
		}
		
		System.out.println(result.values());
	}
	
	private static String sortWordChars(String word) {
		
		char[] wordToChar = word.toCharArray();
		Arrays.sort(wordToChar);
		
		return String.valueOf(wordToChar);
	}
}
