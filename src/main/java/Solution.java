import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      for (int j = i + 1; j < nums.length; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int target = nums[i] + nums[j];
        int k = nums.length - 1;
        while (k > j && target + nums[k] > 0) {
          k--;
        }
        if (j == k) {
          break;
        }
        if (target + nums[k] == 0) {
          ans.add(List.of(nums[i], nums[j], nums[k]));
        }
      }
    }
    return ans;
  }

}
