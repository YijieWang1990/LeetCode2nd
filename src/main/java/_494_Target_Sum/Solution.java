package _494_Target_Sum;

class Solution {
  private int count = 0;
  public int findTargetSumWays(int[] nums, int target) {
    dfs(nums, 0,0, target);
    return count;
  }

  private void dfs(int[] nums, int start,int sum, int target) {
    if (start >= nums.length) {
      if (sum == target) {
        count++;
      }
    } else {
      dfs(nums, start + 1, sum + nums[start], target);
      dfs(nums, start + 1, sum - nums[start], target);
    }
  }
}