package _96_Unique_Binary_Search_Trees;

class Solution {
  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      int sum = 0;
      for (int j = 0; j < i; j++) {
        sum += dp[j] * dp[i - 1 - j];
      }
      dp[i] = sum;
    }
    return dp[n];
  }

}
