package _343_Integer_Break;

class Solution {
  public int integerBreak(int n) {
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }
    if (n == 4) {
      return 4;
    }
    int mul = 1;
    while (n > 4) {
      n -= 3;
      mul *= 3;
    }
    return mul*n;
  }
}