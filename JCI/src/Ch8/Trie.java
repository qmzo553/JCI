package Ch8;

public class Trie {
	
	private static final int CHAR_SIZE = 26;
	
	private final Node head;
	
	public Trie() {
		this.head = new Node();
	}
	
	private static class Node {
		
		private boolean leaf;
		private final Node[] next;
		
		private Node() {
			this.leaf = leaf;
			this.next = new Node[CHAR_SIZE];
		}
	};
	
	public void insertTrie(String str) {
		
		if(str == null) {
			throw new IllegalArgumentException("The given string cannot be null");
		}
		
		Node node = head;
		
		for(int i = 0; i < str.length(); i++) {
			if(node.next[str.charAt(i) - 'a'] == null) {
				node.next[str.charAt(i) - 'a'] = new Node();
			}
			
			node = node.next[str.charAt(i) - 'a'];
		}
		
		node.leaf = true;
	}
	
	public boolean breakIt(String str) {
		boolean[] table = new boolean[str.length() + 1];
		table[0] = true;
		
		for(int i = 0; i < str.length(); i++) {
			
			if(table[i]) {
				Node node = head;
				for(int j = i; j < str.length(); j++) {
					if(node == null) {
						break;
					}
					
					node = node.next[str.charAt(i) - 'a'];
					
					if(node != null&& node.leaf) {
						table[j + 1] = true;
					}
				}
			}
		}
		
		return table[str.length()];
	}
}
