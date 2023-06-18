package _977_Squares_of_a_Sorted_Array;

class Solution {
  public int[] sortedSquares(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] >= 0) {
        break;
      }
      i++;
    }
    int left = i - 1;
    int right = i;
    int[] ans = new int[nums.length];
    i = 0;
    while (left >= 0 || right < nums.length) {
      if (left < 0) {
        ans[i] = nums[right] * nums[right];
        right++;
      } else if (right >= nums.length) {
        ans[i] = nums[left] * nums[left];
        left--;
      } else {
        if (nums[left] * nums[left] < nums[right] * nums[right]) {
          ans[i] = nums[left] * nums[left];
          left--;
        } else {
          ans[i] = nums[right] * nums[right];
          right++;
        }
      }
      i++;
    }
    return ans;
  }
}