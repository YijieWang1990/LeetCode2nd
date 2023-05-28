package _121_Best_Time_to_Buy_and_Sell_Stock;

class Solution {
  public int maxProfit(int[] prices) {
    int low = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int price : prices) {
      int currentProfit = price - low;
      maxProfit = Math.max(maxProfit, currentProfit);
      if (price < low) {
        low = price;
      }
    }
    return maxProfit;
  }
}