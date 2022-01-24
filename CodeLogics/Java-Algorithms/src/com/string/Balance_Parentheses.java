package com.string;

import java.util.Stack;

public class Balance_Parentheses {

    public static void main(String[] args) {

        String s = "((lee(t(c)o)de)";
               s = "lee(t(c)o)de)";
               s = "a)b(c)d";
               s = "))(()";
               s = "(a(b(c)d)";
        System.out.println(s);
        System.out.println("Balanced:"+balanceParentheses(s));
        //System.out.println(balanceParentheses1(s));
        //System.out.println(balanceParentheses2(s));

    }

    public static String balanceParentheses(String s) { // 33ms
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(')
                st.add(i);
            if (sb.charAt(i) == ')') {
                if (!st.empty())
                    st.pop();
                else
                    sb.setCharAt(i, '*');
            }
        }
        while (!st.empty())
            sb.setCharAt(st.pop(), '*');
        return sb.toString().replaceAll("\\*", "");
    }

    public static String balanceParentheses1(String s) { // 51ms
        StringBuilder sb = new StringBuilder(s), sb1 = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(')
                st.add(i + 1);
            if (sb.charAt(i) == ')') {
                if (!st.empty() && st.peek() >= 0)
                    st.pop();
                else
                    st.add(-(i + 1));
            }
        }
        for (int i = 0, j = 0; i < sb.length(); ++i) {
            if (j >= st.size() || i != Math.abs(st.elementAt(j)) - 1) {
                sb1.append(sb.charAt(i));
            } else
                ++j;
        }
        return sb1.toString();
    }

    public static String balanceParentheses2(String s) { // 36ms

        StringBuilder sb = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0)
                    continue;
                open--;
            }
            sb.append(c);

        }
     
        if (open > 0) {
            StringBuilder result = new StringBuilder();
            for (int i = sb.length() - 1; i >= 0; i--) {

                if (sb.charAt(i) == '(' && open-- > 0)
                    continue;
                result.append(sb.charAt(i));
            }
            return result.reverse().toString();
        } else {
            return sb.toString();
        }

    }

}
