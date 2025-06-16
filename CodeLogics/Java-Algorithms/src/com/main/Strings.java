package com.main;

class Strings {
    public static void main(String[] args) {

        System.out.println("getWrongAnswers: "+ getWrongAnswers(3, "ABA"));
        System.out.println();

        String s = "dog";
        countOfChars(s);
        System.out.println();

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        System.out.println("isPalindrome: "+isPalindrome(s2));
        System.out.println();

        String s3 = "aaabbbcccaddbb";
        System.out.println("runLengthEncoding: "+runLengthEncoding(s3));
    }

    private static String getWrongAnswers(int N, String C) {
        
        String out = "";    
        for (int i = 0; i < N; i++) {
            System.out.println(C.charAt(i));
            char ch = (C.charAt(i) == 'A') ? 'B' : 'A';
            
            out = out + String.valueOf(ch);
            System.out.println("char "+i+" = "+ch);
            System.out.println("output "+out);
        }

        return out;        
    }

    private static String runLengthEncoding(String s) {

        int i = 1, cnt = 1;
        StringBuilder sb = new StringBuilder();

        for (i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else {
                sb = sb.append(s.charAt(i - 1)).append(cnt);
                cnt = 1;
            }
        }
        sb = sb.append(s.charAt(i - 1)).append(cnt);

        return sb.toString();
    }

    public static boolean isPalindrome(String s) {

        if (s.length() == 0)
            return false;
        if (s.length() == 1 && s.equalsIgnoreCase(" "))
            return true;

        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }
        String org = sb.toString();
        System.out.println("Org:" + org);
        String revStr = sb.reverse().toString();
        System.out.println("Rev:" + revStr);

        System.out.println("Result:" + org.equalsIgnoreCase(revStr));

        return org.equalsIgnoreCase(revStr);
    }

    private static void countOfChars(String s) {
        int nonACount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'a' && s.charAt(i) != 'A') {
                ++nonACount;
            }
        }
        // Get the count of a's in the string
        int aCount = s.length() - nonACount;
        System.out.println(
                (nonACount * 2 + 2) - aCount);
    }

}