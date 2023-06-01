package _416_Partition_Equal_Subset_Sum;

import java.util.Arrays;

class Solution {
  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 != 0) {
      return false;
    }
    int target = sum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int i = 1; i <= nums.length; i++) {
      for (int j = target; j >= nums[i-1]; j--) {
        dp[j] = dp[j]||dp[j - nums[i-1]];
      }
    }
    return dp[target];
  }
}