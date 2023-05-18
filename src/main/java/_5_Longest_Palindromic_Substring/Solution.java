package _5_Longest_Palindromic_Substring;

class Solution {
  private String ans = "";

  public String longestPalindrome(String s) {
    if (s.length() == 1) {
      return s;
    }
    for (int i = 0; i < s.length() - 1; i++) {
      check(s, i, i);
      check(s, i, i + 1);
    }
    return ans;
  }

  private void check(String s, int left, int right) {

    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) != s.charAt(right)) {
        break;
      }
      left--;
      right++;
    }
    String temp = s.substring(left + 1, right);
    if (temp.length() > ans.length()) {
      ans = temp;
    }
  }
}
