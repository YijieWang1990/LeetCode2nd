package _22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {

  private final List<String> ans = new ArrayList<>();
  private final List<String> temp = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    dfs(0, 0, n);
    return ans;
  }

  private void dfs(int open, int close, int max) {
    if (temp.size() == 2 * max) {
      ans.add(String.join("", temp));
    }
    if (open < max) {
      temp.add("(");
      dfs(open + 1, close, max);
      temp.remove(temp.size() - 1);
    }
    if (close < open) {
      temp.add(")");
      dfs(open, close + 1, max);
      temp.remove(temp.size() - 1);
    }
  }
}