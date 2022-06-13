package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
1813. Sentence Similarity III
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
For example, "Hello World", "HELLO", "hello world hello world" are all sentences. 
Words consist of only uppercase and lowercase English letters.

Two sentences sentence1 and sentence2 are similar if it is possible to insert an arbitrary
sentence (possibly empty) inside one of these sentences such that the two sentences become equal. 
For example, sentence1 = "Hello my name is Jane" and sentence2 = "Hello Jane" can be made equal 
by inserting "my name is" between "Hello" and "Jane" in sentence2.

Given two sentences sentence1 and sentence2, 
return true if sentence1 and sentence2 are similar. Otherwise, return false.

Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
Output: true
Explanation: sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".

Input: sentence1 = "of", sentence2 = "A lot of words"
Output: false
Explanation: No single sentence can be inserted inside one of the sentences to make it equal to the other.

Input: sentence1 = "Eating right now", sentence2 = "Eating"
Output: true
Explanation: sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.
*/

class SentencesSimilar {

    public static void main(String[] args) {
        String s1 = "My name is Haley", s2 = "My Haley";
        System.out.println(areSentencesSimilar(s1, s2));
    }

    public static boolean areSentencesSimilar(String s1, String s2) {
        Deque<String> words1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> words2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));

        while (!words1.isEmpty() && !words2.isEmpty() 
                    && words1.peek().equals(words2.peek())) {
            words1.poll();
            words2.poll();
        }
        while (!words1.isEmpty() && !words2.isEmpty() 
                    && words1.peekLast().equals(words2.peekLast())) {
            words1.pollLast();
            words2.pollLast();
        }

        return words1.isEmpty() || words2.isEmpty();
    }

    public static boolean areSentencesSimilar2(String s1, String s2) {
        String[] words1 = s1.split(" "), words2 = s2.split(" ");
        int i = 0, n1 = words1.length, n2 = words2.length;
        if (n1 > n2) {
            return areSentencesSimilar(s2, s1);
        }
        while (i < n1 && words1[i].equals(words2[i])) {
            ++i;
        }
        while (i < n1 && words1[i].equals(words2[n2 - n1 + i])) {
            ++i;
        }
        return i == n1;
    }
}
