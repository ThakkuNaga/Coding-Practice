package com.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

class StockPrice {

    static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    static int cur = 0;
    static int min = 0;
    static int max = 0;
    TreeMap<Integer, Integer> record = new TreeMap<>();
    TreeMap<Integer, Set<Integer>> vals = new TreeMap<>();

    public StockPrice() {

        map = new LinkedHashMap<>();
        cur = 0;
        min = 0;
        max = 0;
        record = new TreeMap<>();
        vals = new TreeMap<>();

    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();

        ArrayList<String> qLst = new ArrayList<>(
                Arrays.asList(
                        "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"

                ));

        System.out.println("qLst size:" + qLst.size());
        ArrayList<int[]> vLst = new ArrayList<>();
        vLst.add(new int[] { 1, 10 });
        vLst.add(new int[] { 2, 5 });
        vLst.add(new int[] {});
        vLst.add(new int[] {});
        vLst.add(new int[] { 1, 3 });
        vLst.add(new int[] {});
        vLst.add(new int[] { 4, 2 });
        vLst.add(new int[] {});

        System.out.println("vLst size:" + vLst.size());

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

        System.out.println(map);

        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        stockPrice.current();
        stockPrice.maximum();
        stockPrice.update(1, 3);
        stockPrice.maximum();
        stockPrice.update(4, 2);
        stockPrice.minimum();

        stockPrice.current();

    }

    public void update(int timestamp, int price) {
        if (record.containsKey(timestamp)) {
            int prevPrice = record.get(timestamp);
            Set<Integer> book = vals.get(prevPrice);
            book.remove(timestamp);
            if (book.isEmpty()) {
                vals.remove(prevPrice);
            }
        }
        vals.putIfAbsent(price, new HashSet<>());
        vals.get(price).add(timestamp);
        record.put(timestamp, price);
    }

    public int current() {
        return record.lastEntry().getValue();
    }

    public int maximum() {
        return vals.lastKey();
    }

    public int minimum() {
        return vals.firstKey();
    }
}
