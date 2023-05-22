package _35_Search_Insert_Position;

class Solution {
  public int searchInsert(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    int ans = high;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int value = nums[mid];
      if (value == target) {
        return mid;
      }
      if (value > target) {
        ans = mid;
        high = mid-1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }
}
