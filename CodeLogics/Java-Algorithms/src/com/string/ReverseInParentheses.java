package com.string;

import java.util.Stack;

class ReverseInParentheseses {

    public static void main(String[] args) {
        String s = "foo(bar(baz))blim";
        // out -> foobazrabblim
        System.out.println(reverseParentheses(s, s.length()));
    }

    static String reverseParentheses(String str, int len) {
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < len; i++) {

            if (str.charAt(i) == '(') {
                st.push(i);
            }

            else if (str.charAt(i) == ')') {
                char[] A = str.toCharArray();
                swap(A, st.peek() + 1, i);
                str = String.copyValueOf(A);
                st.pop();
            }
        }

        String res = "";
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != ')' && str.charAt(i) != '(') {
                res += (str.charAt(i));
            }
        }
        return res;
    }

    static void swap(char A[], int l, int h) {
        if (l < h) {
            char ch = A[l];
            A[l] = A[h];
            A[h] = ch;
            swap(A, l + 1, h - 1);
        }
    }
}