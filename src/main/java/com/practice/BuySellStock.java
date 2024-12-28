package com.practice;

public class BuySellStock {

//    Input: prices = [7,1,5,3,6,4]
//    Output: 5
    public int maxProfitBruteForce(int[] prices) {

        int l = 0,r = 0, profit = 0;
        for(int i=0; i< prices.length; i++){
            for(int j = l; j< prices.length; j++) {
                r = r+1;
                if(r >=prices.length) break;;
                if(prices[r] > prices[l]) {
                    profit = Math.max(profit, prices[r] - prices[l]);
                }
            }
            l = l+1;
            r = l;
        }
        return profit;
    }

    public int maxProfit(int[] prices) {

        int profit = 0, mini = prices[0];
        for(int i=1; i<prices.length; i++) {
            profit = Math.max(profit, (prices[i] - mini));
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        long startTime = System.currentTimeMillis();
        BuySellStock buySellStock = new BuySellStock();
        int profit = buySellStock.maxProfit(prices);

        long endTime = System.currentTimeMillis();

        System.out.println("Max profit for this input is :: " + profit);
        System.out.println("Program Executed in  :: "+ (endTime-startTime) +" ms");
    }
}
