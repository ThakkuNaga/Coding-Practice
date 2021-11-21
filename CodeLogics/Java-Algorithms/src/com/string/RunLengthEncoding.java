package com.string;

class RunLengthEncoding {

    public static void main(String[] args) {
        String inp = "aaaabbbbcccc";
        if (inp == null || inp.length() == 0) {
            System.out.println("Invalid input");
        } else {
            char[] charArr = inp.toCharArray();
            char prevChar = charArr[0];
            int counter = 0;
            StringBuilder sb = new StringBuilder();

            for (char c : charArr) {
                if (c == prevChar) {
                    counter++;
                } else {
                    if (prevChar != 0) {
                        sb.append(counter).append(prevChar);
                        prevChar = c;
                        counter = 1;
                    }
                }

            }
            sb.append(counter).append(prevChar);
            System.out.println(sb.toString());
        }
    }

}