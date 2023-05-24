package _31_Next_Permutation;

class Solution {
  public void nextPermutation(int[] nums) {
    int index = nums.length - 1;
    while (index > 0) {
      if (nums[index] > nums[index - 1]) {
        break;
      }
      index--;
    }
    if (index == 0) {
      flip(nums, 0, nums.length - 1);
      return;
    }
    int target = index - 1;
    int index1 = nums.length - 1;
    while (index1 >= index ) {
      if (nums[index1] > nums[target]) {
        break;
      }
      index1--;
    }
    int temp = nums[target];
    nums[target] = nums[index1];
    nums[index1] = temp;
    flip(nums, index, nums.length - 1);

  }

  private void flip(int[] nums, int start, int end) {
    while (start <= end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

}