package _77_Combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
  private final List<List<Integer>> ans = new ArrayList<>();
  private final List<Integer> current = new ArrayList<>();
  public List<List<Integer>> combine(int n, int k) {
    dfs(n, k, 1);
    return ans;
  }

  private void dfs(int n, int k, int start) {
    if (current.size() == k) {
      ans.add(new ArrayList<>(current));
      return;
    }

    for (int i = start; i <= n; i++) {
      current.add(i);
      dfs(n, k, i + 1);
      current.remove(current.size() - 1);
    }
  }
}