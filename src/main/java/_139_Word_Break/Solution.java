package _139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordsSet = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        boolean isMatch = dp[j] && isMatch(s, wordsSet, i, j);
        if (isMatch) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  private boolean isMatch(String s, Set<String> wordsSet, int i, int j) {
    String substring = s.substring(j, i);
    return wordsSet.contains(substring);
  }
}