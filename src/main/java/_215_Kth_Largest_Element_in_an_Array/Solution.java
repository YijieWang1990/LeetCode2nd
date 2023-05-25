package _215_Kth_Largest_Element_in_an_Array;

class Solution {
  public int findKthLargest(int[] nums, int k) {
    int start = 0;
    int end = nums.length - 1;
    while (true) {
      int partition = partition(nums, start, end);
      if (partition - start == k - 1) {
        return nums[partition];
      } else if (partition - start > k - 1) {
        end = partition - 1;
      } else {
        k -= (partition - start + 1);
        start = partition + 1;
      }
    }
  }

  private int partition(int[] nums, int start, int end) {
    int i = start;
    int j = start;
    int pivot = nums[end];
    while (j < end) {
      if (nums[j] > pivot) {
        swap(nums, i, j);
        i++;
      }
      j++;
    }
    swap(nums, i, end);
    return i;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
