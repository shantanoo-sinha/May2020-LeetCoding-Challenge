/*

Reference: https://leetcode.com/problems/implement-trie-prefix-tree/

208. Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Example:
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:
    You may assume that all inputs are consist of lowercase letters a-z.
    All inputs are guaranteed to be non-empty strings.

*/
class Trie {

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(node.nodes[c-'a'] == null)
                node.nodes[c-'a'] = new TrieNode();
            node = node.nodes[c-'a'];
        }
        node.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(node.nodes[c-'a'] == null)
                return false;
            node = node.nodes[c-'a'];
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix==null || prefix.length()<1)
            return false;
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            if(node.nodes[c-'a'] == null)
                return false;
            node = node.nodes[c-'a'];
        }
        return true;
    }
}

class TrieNode {
    boolean isWord = false;
    TrieNode[] nodes = null;
    
    public TrieNode() {
        nodes = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
