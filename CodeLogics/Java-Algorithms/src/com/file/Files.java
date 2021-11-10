package com.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class Files {
    public static void main(String... args) throws Exception {
        readFile();
    }

    public static void readFile() throws Exception {
        FileReader file = new FileReader("C:\\Users\\rajan\\Documents\\temp.txt");
        BufferedReader fileInput = new BufferedReader(file);

        // Print first 3 lines of file
        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());

        fileInput.close();
    }

}