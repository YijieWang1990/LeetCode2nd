package _39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

class Solution {

  private final List<List<Integer>> ans = new ArrayList<>();

  private final List<Integer> batch = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    combination(candidates, target, 0, 0);

    return ans;
  }

  private void combination(int[] candidates, int target, int sum, int start) {
    if (sum == target) {
      ans.add(new ArrayList<>(batch));
    } else if (sum > target) {
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      sum += candidates[i];
      batch.add(candidates[i]);
      combination(candidates, target, sum, i);
      sum -= candidates[i];
      batch.remove(batch.size() - 1);
    }
  }
}
