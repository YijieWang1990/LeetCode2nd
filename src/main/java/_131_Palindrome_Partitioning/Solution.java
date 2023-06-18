package _131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {

  private final List<List<String>> ans = new ArrayList<>();

  private boolean[][] dp;
  private final List<String> current = new ArrayList<>();

  public List<List<String>> partition(String s) {
    dp = new boolean[s.length()][s.length()];

    for (int i = 0; i < s.length(); ++i) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] = true;
      }
    }

    for (int k = 1; k < s.length(); k++) {
      for (int i = 0; i + k < s.length(); i++) {
        dp[i][i + k] = dp[i + 1][i + k - 1] && s.charAt(i) == s.charAt(i + k);
      }
    }

    dfs(s, 0);

    return ans;
  }

  private void dfs(String s, int start) {
    if (start == s.length()) {
      ans.add(new ArrayList<>(current));
    }

    for (int i = start; i < s.length(); i++) {
      if (dp[start][i]) {
        current.add(s.substring(start, i + 1));
        dfs(s, i + 1);
        current.remove(current.size() - 1);
      }
    }
  }
}