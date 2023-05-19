package offer03;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int findRepeatNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) {
        return num;
      } else {
        set.add(num);
      }
    }
    return 0;
  }
}
