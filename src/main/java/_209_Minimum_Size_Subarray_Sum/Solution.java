package _209_Minimum_Size_Subarray_Sum;

class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int slow = 0;
    int fast = 0;
    int currentSum = 0;
    int minLen = Integer.MAX_VALUE;
    while (fast < nums.length) {
      currentSum += nums[fast++];
      while (currentSum >= target) {
        minLen = Math.min(minLen, fast - slow);
        currentSum -= nums[slow];
        slow++;
      }
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
}