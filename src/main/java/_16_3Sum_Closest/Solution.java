package _16_3Sum_Closest;

import java.util.Arrays;

class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int ans = Integer.MAX_VALUE;
    int closest = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == target) {
          return target;
        }
        if (Math.abs(target - sum) < closest) {
          ans = sum;
          closest = Math.abs(target - sum);
        }
        if (sum > target) {
          right--;
        } else {
          left++;
        }

      }

    }
    return ans;
  }
}