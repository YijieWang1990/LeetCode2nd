package _14_Longest_Common_Prefix;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public String longestCommonPrefix(String[] strs) {
    int longest = 0;
    while (true) {
      Set<Character> set = new HashSet<>();
      for (String str : strs) {
        if (longest == str.length()) {
          return str;
        }
        char c = str.charAt(longest);
        set.add(c);
      }
      if (set.size() > 1) {
        break;
      }
      longest++;
    }
    return strs[0].substring(0, longest);
  }
}