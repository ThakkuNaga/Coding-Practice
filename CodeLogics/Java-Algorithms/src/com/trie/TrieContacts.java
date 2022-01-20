package com.trie;

public class TrieContacts {

    private Trie trie;

    public TrieContacts() {
        trie = new Trie();
    }

    public static void main(String[] args) {
        TrieContacts solution = new TrieContacts();
        String strs[]= {"add ed","add eddie","add edward","find ed","add edwina","find edw","find a"}; 
        for ( String str: strs ) {
            solution.process(str);
        }
    }

    private void process(String strOperation) {
        String[] arrStrOperation = strOperation.split(" ");
        String operation = arrStrOperation[0];
        String input = arrStrOperation[1];

        switch (operation) {
            case "add":
                trie.add(input);
                System.out.println(input+" added...");
                break;
            case "find":
                System.out.println("Find "+input+": "+trie.find(input));
                break;
            default:
                System.err.println("Unknown operation!");
        }
    }

    private static class Trie {
        public Node head;

        public Trie() {
            head = new Node(null);
        }

        public void add(String input) {
            if (input == null)
                return;
            int inLen = input.length();
            if (inLen == 0)
                return;

            Node node = head;
            for (int i = 0; i < inLen; i++) {
                char inChar = input.charAt(i);
                int idxInChar = (int) inChar - (int) 'a';
                if (node.next[idxInChar] == null)
                    node.next[idxInChar] = new Node(inChar);
                else
                    node.next[idxInChar].prefixes++;
                node = node.next[idxInChar];
            }
        }

        public int find(String input) {
            if (input == null)
                return 0;
            int inLen = input.length();
            if (inLen == 0)
                return 0;

            Node node = head;
            int i = 0;
            while (i < inLen) {
                char inChar = input.charAt(i);
                int idxInChar = (int) inChar - (int) 'a';
                if (node.next[idxInChar] == null)
                    break;
                node = node.next[idxInChar];
                i++;
            }
            return (i == inLen) ? node.prefixes : 0;
        }
    }

    private static class Node {
        public Character c;
        public int prefixes;
        public Node[] next;

        public Node(Character c) {
            this.c = c;
            prefixes = 1;
            next = new Node[26];
        }
    }
}