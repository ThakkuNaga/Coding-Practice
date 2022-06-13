package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

class TextJustification {

    /*
     * Input: words = ["This", "is", "an", "example", "of", "text",
     * "justification."], maxWidth = 16
     * Output:
     * [
     * "This    is    an",
     * "example  of text",
     * "justification.  "
     * ]
     * 
     * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth =
     * 16
     * Output:
     * [
     * "What   must   be",
     * "acknowledgment  ",
     * "shall be        "
     * 
     * ]
     * 
     * Input: words =
     * ["Science","is","what","we","understand","well","enough","to","explain","to",
     * "a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
     * Output:
     * [
     * "Science  is  what we",
     * "understand      well",
     * "enough to explain to",
     * "a  computer.  Art is",
     * "everything  else  we",
     * "do                  "
     * ]
     */

    public static void main(String[] args) {

        // String[] words = { "This", "is", "an", "example", "of", "text",
        // "justification." };
        // int maxWidth = 16;

        // String[] words = { "What", "must", "be", "acknowledgment", "shall", "be" };
        // int maxWidth = 16;

        String[] words = { "Science", "is", "what", "we", "understand", "well",
                "enough", "to", "explain", "to",
                "a", "computer.", "Art", "is", "everything", "else", "we", "do" };
        int maxWidth = 20;

        System.out.println(justifyText(words, maxWidth));

    }

    private static String justifyText(String[] words, int maxWidth) {
        StringBuilder txt = new StringBuilder();

        List<String> result = new ArrayList<>();
        int width = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            System.out.println("word-> " + word);
            width += word.length() + 1;
            if (width < maxWidth) {
                txt.append(word + " ");
            } else if (width == maxWidth) {
                if (word.indexOf(" ") == 1)
                    word += word.substring(0, word.length() - 1);
                txt.append(word + "\n");
                width = 0;
            } else if (width > maxWidth) {

                int lineWdh = txt.length();
                System.out.println("lineWdh-> " + lineWdh);
                int spaces = maxWidth - lineWdh;

                if (spaces > 0) {

                    System.out.println("spaces-> " + spaces);
                    int lastidx = txt.toString().lastIndexOf(" ");
                    String text = txt.toString().substring(0, lastidx).replaceAll(" ", "  ");
                    txt.delete(0, txt.length());
                    txt.append(text);
                    while (spaces > 0) {
                        System.out.println("inside while...");
                        if (lineWdh == maxWidth) {
                            break;
                        }
                        txt.replace(txt.indexOf(" "), txt.indexOf(" "), "  ");
                        lineWdh = txt.length();
                        spaces = maxWidth - lineWdh;
                    }
                }

                txt.append("\n");
                width = 0;
                i--;
            }
            System.out.println("Wdh-> " + width);
            System.out.println("txt-> " + txt);
        }

        System.out.println("Length: " + txt.length());

        return txt.toString();
    }

}
