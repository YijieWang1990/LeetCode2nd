package offer62;

class Solution {
  public int lastRemaining(int n, int m) {
    int ans = 0;
    for (int i = 2; i <= n; i++) {
      ans = (m + ans) % i;
    }
    return ans;
  }
}