package _72_Edit_Distance;

class Solution {
  public int minDistance(String word1, String word2) {
    if (word1.length() * word2.length() == 0) {
      return word1.length() + word2.length();
    }
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i < dp[0].length; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        int v1 = dp[i - 1][j] + 1;
        int v2 = dp[i][j - 1] + 1;
        int v3 = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
        dp[i][j] = Math.min(v1, Math.min(v2, v3));
      }
    }
    return dp[word1.length()][word2.length()];
  }
}
