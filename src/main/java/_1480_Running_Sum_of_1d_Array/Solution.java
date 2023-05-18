package _1480_Running_Sum_of_1d_Array;

class Solution {
  public int[] runningSum(int[] nums) {
    int[] ans = new int[nums.length];
    ans[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      ans[i] = ans[i - 1] + nums[i];
    }
    return ans;
  }
}
