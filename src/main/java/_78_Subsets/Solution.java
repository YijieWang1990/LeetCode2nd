package _78_Subsets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Solution {

  private final List<List<Integer>> ans = new ArrayList<>();

  private final List<Integer> current = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    dfs(nums, 0);

    return ans;
  }

  private void dfs(int[] nums, int start) {
    if (start == nums.length) {
      ans.add(new ArrayList<>(current));
      return;
    }

    current.add(nums[start]);
    dfs(nums, start + 1);
    current.remove(current.size() - 1);
    dfs(nums, start + 1);
  }
}