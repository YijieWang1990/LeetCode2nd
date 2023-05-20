package _7_Reverse_Integer;

class Solution {
  public int reverse(int x) {
    int sum = 0;
    while (x != 0) {
      if (sum < Integer.MIN_VALUE / 10 || sum > Integer.MAX_VALUE / 10) {
        return 0;
      }
      int value = x % 10;
      sum = sum * 10 + value;
      x /= 10;
    }
    return sum;
  }
}
