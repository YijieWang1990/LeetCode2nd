package _136_Single_Number;

class Solution {
  public int singleNumber(int[] nums) {
    int start = 0;
    for (int num : nums) {
      start = start ^ num;
    }
    return start;
  }
}
