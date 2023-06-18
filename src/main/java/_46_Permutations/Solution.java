package _46_Permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {

  private final List<List<Integer>> ans = new ArrayList<>();

  private final List<Integer> current = new ArrayList<>();


  public List<List<Integer>> permute(int[] nums) {
    boolean[] visit = new boolean[nums.length];
    dfs(nums, visit);

    return ans;
  }

  private void dfs(int[] nums, boolean[] visit) {
    if (current.size() == nums.length) {
      ans.add(new ArrayList<>(current));
    }

    for (int i = 0; i < nums.length; i++) {
      if(!visit[i]){
        current.add(nums[i]);
        visit[i] = true;
        dfs(nums, visit);
        current.remove(current.size() - 1);
        visit[i] = false;
      }
    }
  }
}