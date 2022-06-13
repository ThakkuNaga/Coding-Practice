package com.array;

public class MaxStockProfit { // 122. Best Time to Buy and Sell Stock II
    // On each day, you may decide to buy and/or sell the stock. You can only hold
    // at most one share of the stock at any time. However, you can buy it then
    // immediately sell it on the same day.

    public static void main(String[] args) {

        int[] prices = { 10, 7, -3, -10, 4, 2, 8, -2, 4, -5, -6 };
        // prices={7,6,4,3,1};
        // prices={1,2,3,4,5};

        //System.out.println("maxProfit is: " + maxProfit(prices));
         System.out.println("maxProfit is: " + maxProfit2(prices));

    }

    // Approach #1 (Peak/Valley) [Accepted]
    public static int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    // Approach #2 (Math.max) [Accepted]
    public static int maxProfit2(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxprofit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxprofit;
    }

}