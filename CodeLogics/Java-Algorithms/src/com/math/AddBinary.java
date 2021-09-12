package com.math;

import java.math.BigInteger;

public class AddBinary {
    public static void main(String[] args) {

        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));

        //System.out.println(Integer.toBinaryString(21));
        //System.out.println(1%2);
    }

    //Naive approach
    public String addBinaryNaive(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
      }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            
            sb.append(sum % 2);
            carry = sum / 2;
            
            i--;
            j--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();

    }

    public static String addBinary2(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }

}