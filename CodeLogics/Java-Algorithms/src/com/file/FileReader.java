package com.file;

import java.util.Scanner;

public class FileReader {
    public static void main(String... args) throws Exception {
        readFile();
    }

    public static void readFile() throws Exception {

        try {
            Scanner myReader = new Scanner("C:\\Users\\rajan\\Documents\\UAN.txt");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}