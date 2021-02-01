package practice.datastructures;
import java.util.*;

class Trie {
    public class TrieNode {
        public Map<Character, TrieNode> map;
        public boolean isEndOfWord;

        TrieNode(boolean isEndOfWord) {
            this.map = new HashMap<>();
            this.isEndOfWord = isEndOfWord;
        }
    }

    public TrieNode root = new TrieNode(false);

    public TrieNode insertChar(TrieNode node, char c, boolean isEndOfWord) {
        if (!node.map.containsKey(c)) {
            node.map.put(c, new TrieNode(isEndOfWord));
        }

        return node.map.get(c);
    }

    public void insert(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            node = insertChar(node, c, i == (s.length()-1) );
        }
    }

    public static void main(String[] args) {
        Trie s = new Trie();
        s.insert("abcd");
        s.insert("bcd");
        System.out.println(s.root.map.get('b').map.get('c').isEndOfWord);
    }
}