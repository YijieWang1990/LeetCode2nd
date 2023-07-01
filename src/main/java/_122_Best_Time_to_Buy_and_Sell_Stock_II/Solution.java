package _122_Best_Time_to_Buy_and_Sell_Stock_II;

class Solution {
  public int maxProfit(int[] prices) {
    int prevEmpty = 0;
    int preHold = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      prevEmpty = Math.max(prevEmpty, preHold + prices[i]);
      preHold = Math.max(prevEmpty - prices[i], preHold);
    }
    return prevEmpty;
  }
}