package com.interviews;

import java.util.*;

class DivisorGame {
    // 1025. Divisor Game
    /*
     * Alice and Bob take turns playing a game, with Alice starting first.
     * 
     * Initially, there is a number n on the chalkboard. On each player's turn, that
     * player makes a move consisting of:
     * 
     * Choosing any x with 0 < x < n and n % x == 0.
     * Replacing the number n on the chalkboard with n - x.
     * Also, if a player cannot make a move, they lose the game.
     * 
     * Return true if and only if Alice wins the game, assuming both players play
     * optimally.
     */
    public static void main(String[] args) {
        int n = 3;
        System.out.println(divisorGame(n));
    }

    public static boolean divisorGame(int n) {
        return n % 2 == 0;
        //return (n & 1) == 0;   
    }

    public static boolean divisorGame1(int n) {
        boolean[] a = new boolean[n + 2];
        a[1] = false;
        a[2] = true;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && !a[i - j]) {
                    a[i] = true;
                    break;
                }
            }
        }
        return a[n];
    }
}