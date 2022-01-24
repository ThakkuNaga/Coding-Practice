package com.string;

// Java program to print all the permutations
// of the given string
public class StringPermutation {

    public static void main(String[] args) {
        String s = "geek";
        //printPermutn(s, "");
        permutation(s);
    }

    // Function to print all the permutations of str
    static void printPermutn(String str, String ans) {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            printPermutn(ros, ans + ch);
        }
    }

    public static void permutation(String str) { 
        permutation("", str); 
    }
    
    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.print(prefix+" ");
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

}
