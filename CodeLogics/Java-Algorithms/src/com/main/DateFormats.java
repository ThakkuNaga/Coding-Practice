package com.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

class DateFormats {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss a");

        String d = "12:05:45 AM";

        System.out.println(formatter.format(sdf.parse(d)));
    }

    

}