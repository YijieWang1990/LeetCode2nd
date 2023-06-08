package _45_Jump_Game_II;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int jump(int[] nums) {
    int count = 0;
    int longest = 0;
    int index = 0;
    while (longest < nums.length) {
      count++;
      int nextLongest = longest;
      while (index <= longest) {
        nextLongest = Math.max(nextLongest, index + nums[index]);
        index++;
      }
      if (nextLongest >= nums.length - 1) {
        return count;
      }
      longest = nextLongest;
    }
    return count;
  }

}