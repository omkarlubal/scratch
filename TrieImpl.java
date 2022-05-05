import java.util.*;

class Trie {
	public static int ALPHABET_SIZE = 26;
	
	public static class TrieNode {
		TrieNode[] nodes;
		List<String> words;
		
		public TrieNode() {
			this.nodes = new TrieNode[ALPHABET_SIZE + 1];
			this.words = new ArrayList<>();
		}
		
		public void add(String s) {
			addHelper(s, s);
		}
		
		public void addHelper(String originalWord, String subWord) {
			if (subWord.length() == 0) {
				this.words.add(originalWord);
				return;
			}
			
			subWord = subWord.toLowerCase();
			// small case ASCII begins at 97
			int alphabet = (int)subWord.charAt(0) - 96;
			nodes[alphabet] = new TrieNode();
			nodes[alphabet].addHelper(originalWord, subWord.substring(1));
		}
		
		public String suggest(String s) {
			if (s.length() == 0) {
				return "";
			}
			
			return "";
		}
		
		public void printTrie() {
			TrieNode[] children = this.nodes;
			List<String> words = this.words;
			for (int i = 1; i < ALPHABET_SIZE; i++) {
				if (children[i] != null) {
					System.out.println((char)(i + 96));
					System.out.println(" | ");
					// get words at current node
					words = children[i].words;
					children = children[i].nodes;
					i=0;
				}
			}
			System.out.print(words.toString());
		}
		
	}
}

class TrieImpl {
	
	public static void print(Object o) {
		System.out.print(o.toString());
	}
	
	public static void main(String args[]) {
		print("Hello\n");
		Trie.TrieNode trie = new Trie.TrieNode();
		trie.add("APP");
		trie.printTrie();
	}
}