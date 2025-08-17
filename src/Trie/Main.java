package Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.Insert("cat");
        trie.Insert("cab");
        trie.Insert("gyat");

        System.out.println(trie.Search("cat"));
    }
}
