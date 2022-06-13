package com.array;

public class MaxStockProfit_2 { 
    
    // 121. Best Time to Buy and Sell Stock
    // You want to maximize your profit by choosing a single day to buy one stock
    // and choosing a different day in the future to sell that stock.

    public static void main(String[] args) {

        int[] prices = { 10, 7, -3, -10, 4, 2, 8, -2, 4, -5, -6 };

        System.out.println("maxProfit is: " + maxProfit(prices));
        // System.out.println("maxProfit is: " + maxProfit2(prices));

    }

    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    // Kadane's Algorithm
    public static int maxProfit2(int[] prices) {
        int maxCur = 0, maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxProfit = Math.max(maxCur, maxProfit);
        }
        return maxProfit;
    }

}