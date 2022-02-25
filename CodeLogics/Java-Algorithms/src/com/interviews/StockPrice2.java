package com.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

class StockPrice2 {

    static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    static int cur = 0;
    static int min = 0;
    static int max = 0;

    public StockPrice2() {

        map = new LinkedHashMap<>();
        cur = 0;
        min = 0;
        max = 0;
    }

    public static void main(String[] args) {
        StockPrice2 stockPrice = new StockPrice2();
        // stockPrice.update(1, 10);
        // stockPrice.update(2, 5);
        // stockPrice.current();
        // stockPrice.maximum();
        // stockPrice.update(1, 3);
        // stockPrice.maximum();
        // stockPrice.update(4, 2);
        // stockPrice.minimum();

        // System.out.println(map);
        // System.out.println(map.size());
        // stockPrice.current();
        

        ArrayList<String> qLst = new ArrayList<>(
                Arrays.asList(

                "update", "maximum", "current", "minimum", "maximum", "maximum", "maximum", "minimum",
                "minimum", "maximum", "update", "maximum", "minimum", "update", "maximum", "minimum", 
                "current", "maximum", "update", "minimum", "maximum", "update",  "maximum", "maximum",
                "current", "update", "current", "minimum", "update", "update", "minimum",
                "minimum", "update", "current", "update", "maximum", "update", "minimum"

                // "update","update","current","maximum","update","maximum","update","minimum"
                
                ));

        //System.out.println("qLst size:" + qLst.size());
        ArrayList<int[]> vLst = new ArrayList<>();
        // vLst.add(new int[] { 1, 10 });
        // vLst.add(new int[] { 2, 5 });
        // vLst.add(new int[] {});
        // vLst.add(new int[] {});
        // vLst.add(new int[] { 1, 3 });
        // vLst.add(new int[] {});
        // vLst.add(new int[] { 4, 2 });
        // vLst.add(new int[] {});

        
        vLst.add(new int[] { 38, 2308 });
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] { 47, 7876 });
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] { 58, 1866 });
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] { 43, 121 });
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] { 40, 5339 });
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] { 32, 5339 });
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] { 43, 6414 });
        vLst.add(new int[] { 49, 9369 });
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] { 36, 3192 });
        vLst.add(new int[] {});
        vLst.add(new int[] { 48, 1006 });
        vLst.add(new int[] {});
        vLst.add(new int[] { 53, 8013 });
        vLst.add(new int[] {});

        //System.out.println("vLst size:" + vLst.size());

        for (int i = 0; i < qLst.size(); i++) {

            if (qLst.get(i).equals("maximum")) {
                stockPrice.maximum();

            } else if (qLst.get(i).equals("minimum")) {
                stockPrice.minimum();

            } else if (qLst.get(i).equals("current")) {
                stockPrice.current();

            } else {
                stockPrice.update(vLst.get(i)[0], vLst.get(i)[1]);
            }
        }

       //System.out.println(map);

    }

    public void update(int timestamp, int price) {
        map.put(timestamp, price);
    }

    public int current() {        
        int key = (Collections.max(map.keySet()));        
        return map.get(key);
    }

    public int maximum() {        
        max = (Collections.max(map.values()));
        System.out.println("max:" + max);
        return max;
    }

    public int minimum() {
        min = (Collections.min(map.values())); 
        System.out.println("min:" + min);
        return min;
    }
}
