package Trie;


public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void Insert(String word){
        TrieNode node = root;
        for (char ch : word.toCharArray()){
            int index = ch - 'a';
            if (node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    public boolean Search(String word){
        TrieNode node = root;
        for (char ch : word.toCharArray()){
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;
        for (char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if (node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}
