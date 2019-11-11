/* Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * EXAMPLE 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * EXAMPLE 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

import java.util.*; 
  
// BRUTE FORCE
// iterate through the array one by one, check future indexes for max profit
//
// Time complexity: O(n^2).  Loop runs two times
// Space Complexity: O(1). Only two variables, maxprofit and prof are used
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++){
            for (int j = i + 1; j < prices.length; j++){
                int prof = prices[j] - prices[i];
                if (prof > 0 && prof > maxProfit) 
                    maxProfit = prof;
            }
        }
        return maxProfit;
    }
}

// ONE PASS APPROACH
// iterate through the array one by one, record the lowest price seen as we iterate
// calculate current index subtract lowest price and determine max profit
//
// Time complexity : O(n). Only a single pass is needed.
// Space complexity : O(1). Only two variables are used.
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
