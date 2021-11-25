package data;

import java.util.List;

public class Trie {
    // lowercase letter 26: abcd efgh ijkl mnop qrst uvwxyz
    public Trie[] children;
    public boolean endOfWord;

    Trie() {
        this.children = new Trie[26];
        this.endOfWord = false;
    }

    public Trie(List<String> words) {
        words.forEach(this::add);
    }

    private void add(String word) {
        Trie curr = this;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Trie();
            }

            curr = curr.children[c - 'a'];
        }

        curr.endOfWord = true;
    }
}



