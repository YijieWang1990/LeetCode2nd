package _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

class Solution {
  public int[] searchRange(int[] nums, int target) {
    int left = binarySearch(nums, target, true);
    int right = binarySearch(nums, target, false);
    if (left == -1) {
      return new int[]{-1, -1};
    }
    return new int[]{left, right};
  }

  private int binarySearch(int[] nums, int target, boolean flag) {
    int low = 0;
    int high = nums.length - 1;
    int ans = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] > target) {
        high = mid - 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        ans = mid;
        if (flag) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }
    return ans;
  }
}
