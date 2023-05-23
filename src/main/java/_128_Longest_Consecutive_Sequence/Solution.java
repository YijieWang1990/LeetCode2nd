package _128_Longest_Consecutive_Sequence;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> integerSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

    int longest = 0;
    int count = 0;
    for (int num : nums) {
      if (!integerSet.contains(num - 1)) {
        int start = num;
        while (integerSet.contains(start)) {
          count++;
          start++;
        }
        longest = Math.max(longest, count);
        count = 0;
      }
    }
    return longest;
  }
}
