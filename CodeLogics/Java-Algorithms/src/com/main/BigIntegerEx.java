package com.main;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerEx {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        BigInteger a =new BigInteger(inp.nextLine());
        System.out.println(a);
        BigInteger b =new BigInteger(inp.nextLine());
        System.out.println(b);
        
        inp.close();
        
        
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
        
    }
}