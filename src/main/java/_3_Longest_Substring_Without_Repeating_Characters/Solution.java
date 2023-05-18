package _3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    int slow = 0;
    int fast = 0;
    int longest = 0;
    Map<Character, Integer> characterIndexMap = new HashMap<>();

    while (fast < s.length()) {
      char charAt = s.charAt(fast);
      if (!characterIndexMap.containsKey(charAt)) {
        characterIndexMap.put(charAt, fast);
      } else {
        longest = Math.max(longest, fast - slow);
        int targetIndex = characterIndexMap.get(charAt);
        while (slow <= targetIndex) {
          characterIndexMap.remove(s.charAt(slow));
          slow++;
        }
        characterIndexMap.put(charAt, fast);
      }
      fast++;
    }
    return Math.max(longest, fast - slow);
  }
}
