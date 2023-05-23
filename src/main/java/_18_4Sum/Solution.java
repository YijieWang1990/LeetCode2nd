package _18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        for (int k = j + 1; k < nums.length; k++) {
          if (k > j + 1 && nums[k] == nums[k - 1]) {
            continue;
          }
          int m = nums.length - 1;
          while (k < m && (long)nums[i] + nums[j] + nums[k] + nums[m] > target) {
            m--;
          }
          if (k == m) {
            break;
          }
          if ((long)nums[i] + nums[j] + nums[k] + nums[m] == target) {
            ans.add(List.of(nums[i], nums[j], nums[k], nums[m]));
          }
        }
      }
    }
    return ans;
  }
}
