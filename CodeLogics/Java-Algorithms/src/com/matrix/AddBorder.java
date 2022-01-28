package com.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AddBorder {

    public static void main(String[] args) {
        String[] picture = { "abc", "def" };
        System.out.print(Arrays.toString(addBorder(picture)));
    }

    static String[] addBorder(String[] picture) {
        String startEnd = "";
        for (int i = 0; i < picture[0].length() + 2; i++) {
            startEnd += "*";
        }

        ArrayList<String> list = new ArrayList<>();
        list.add(startEnd);
        for (int i = 0; i < picture.length; i++) {
            list.add("*" + picture[i] + "*");
        }
        list.add(startEnd);
        return list.toArray(new String[list.size()]);
    }

    static String[] addBorder2(String[] picture) {
        int len = picture[0].length() + 2;
        String star = "*";
        List<String> list = new ArrayList<>();

        // adding upper border
        for (int i = 0; i < len; i++) {
            list.add("*");
        }

        // adding stars on the left and right
        for (int i = 0; i < picture.length; i++) {
            list.add(star + picture[i] + star);
        }

        // adding bottom border
        for (int i = 0; i < len; i++) {
            list.add("*");
        }
        return list.toArray(new String[0]);
    }

    private static String[] addBorder3(String[] picture) {
        System.out.println("Len:" + picture[0].length());
        String ast = setAst(picture[0].length());

        String[] ans = new String[picture.length + 2];
        int ind = 0;
        ans[0] = ast;
        for (String word : picture) {
            ind++;
            ans[ind] = "*" + word + "*";
        }
        ans[ind + 1] = ast;
        return ans;
    }

    private static String setAst(int length) {
        String ast = "**";
        for (int cnt = 0; cnt < length; cnt++) {
            ast += "*";
        }
        return ast;
    }

}