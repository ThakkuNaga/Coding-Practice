package com.interviews.java.generics;

public class GenericsTester {
    public static void main(String[] args) {
        MyGenClass<Double,Double> intBox = new MyGenClass<Double,Double>();
        intBox.add(10.544,11.4);
        intBox.get(); 
        
        MyGenClass<String,String> strBox = new MyGenClass<String,String>();
        strBox.put("Hello");
        strBox.get();    
    }

    }