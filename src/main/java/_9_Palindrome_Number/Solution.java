package _9_Palindrome_Number;

class Solution {
  public boolean isPalindrome(int x) {
    int sum = 0;
    int origin = x;
    while (x > 0) {
      int v = x % 10;
      x = x / 10;
      sum = sum * 10 + v;
    }
    return sum == origin;
  }
}