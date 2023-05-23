package _26_Remove_Duplicates_from_Sorted_Array;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int removeDuplicates(int[] nums) {
    int slow = 1;
    int fast = 1;
    while (fast < nums.length) {
      if (nums[fast] != nums[fast - 1]) {
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    return slow;
  }
}