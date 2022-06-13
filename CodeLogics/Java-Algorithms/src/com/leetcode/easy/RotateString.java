package com.leetcode.easy;

public class RotateString {

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString2(s, goal));
    }

    public static boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    public static boolean rotateString1(String s, String goal) {

        int len = s.length();
        System.out.println("> " + s + " <");

        for (int i = 0; i < s.length(); i++) {

            System.out.print(" " + s.substring(1, s.length()) + " " + s.charAt(0));

            s = s.substring(1, s.length()) + s.charAt(0);
            System.out.println(" ->" + s);
            if (s.equalsIgnoreCase(goal))
                return true;
        }

        return false;
    }

    public static boolean rotateString2(String s, String goal) {
        // corner case and meta-check
        if (s == null || goal == null || s.length() != goal.length()) {
            return false;
        }

        char[] charS = s.toCharArray();
        char[] charGoal = goal.toCharArray();

        // boolean flag = false;
        for (int diff = 0; diff < charS.length; diff++) {
            int i = 0;
            boolean flag = true;
            while (i < charS.length) {
                flag = flag && (charS[i] == charGoal[(i + diff) % charS.length]);
                i++;
            }
            if (flag) {
                return flag;
            }
        }

        return false;

    }

    public static boolean rotateString3(String s, String goal) {

        if(s.length() != goal.length()){
            return false;
        }
        
        int partition = 1;
        for(int i=partition; i<s.length(); i++){
            String cut = s.substring(0, i);
            
            String cur = s.substring(i, s.length());
			cur = cur + cut;
            
            if(cur.equals(goal)){
                return true;
            }
            
        }
        return false;
    }

}