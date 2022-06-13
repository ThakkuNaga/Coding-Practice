package com.leetcode.medium;

import java.util.LinkedHashSet;
import java.util.Set;

public class ValidSudoku {
    /*
     * 36. Valid Sudoku
     * 
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need
     * to be validated according to the following rules:
     * 
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain
     * the digits 1-9 without repetition.
     * 
     * Note:
     * A Sudoku board (partially filled) could be valid but is not necessarily
     * solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     */

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println(isValidSudoku1(board));
    }

    private static boolean isValidSudoku1(char[][] board) {

        Set<String> seen = new LinkedHashSet<String>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }

        for (String str : seen) {
            System.out.println(str + " ");
        }
        return true;

    }

    public static boolean isValidSudoku2(char[][] board) {
        Set<String> seen = new LinkedHashSet<String>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i / 3 + b + j / 3))
                        return false;
                }
            }
        }

        for (String str : seen) {
            System.out.println(str + " ");
        }

        return true;
    }

}