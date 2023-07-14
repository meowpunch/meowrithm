package leetcode.java;

public class Trie {
    public static void main(String[] args) {
        final Trie t = new Trie();

        t.insert("apply");
        System.out.println(t.search("apply"));
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));

        t.insert("app");
        System.out.println(t.search("app"));
    }

    /*
                        a Node()
                    p
                p
            l
        e       y

        only for lowercase -> 26 size of boolean array

     */

    private class Node {
        // represent if the character of the node is last char of the word or not.
        boolean f;

        // 26 characters
        Node[] children;

        Node() {
            this.f = false;
            this.children = new Node[26];
        }
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            final int ic = charToIndex(word.charAt(i));

            if (curr.children[ic] == null)  curr.children[ic] = new Node();

            if (i == word.length() - 1) curr.children[ic].f = true;

            curr = curr.children[ic];
        }
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            final int ic = charToIndex(word.charAt(i));

            if (curr.children[ic] != null) {
                if (i == word.length() - 1 && curr.children[ic].f) return true;
                curr = curr.children[ic];
            }
            else return false;
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            final int ic = charToIndex(prefix.charAt(i));

            if (curr.children[ic] != null) {
                curr = curr.children[ic];
            }
            else return false;
        }

        return true;
    }

    private int charToIndex(char c) {
        final int i = c - 'a';
        if (0 <= i && i < 26) return i;
        else throw new IllegalArgumentException();
    }
}
