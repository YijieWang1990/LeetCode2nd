package _912_Sort_an_Array;

public class Solution1 {
  public int[] sortArray(int[] nums) {
    heapSort(nums);
    return nums;
  }

  private void heapSort(int[] nums) {
    for (int i = nums.length / 2 - 1; i >= 0; i--) {
      heapify(nums, i, nums.length);
    }
    int len = nums.length;
    for (int i = nums.length - 1; i >= 0; i--) {
      swap(nums, 0, i);
      len--;
      heapify(nums, 0, len);
    }
  }

  private void heapify(int[] nums, int i, int len) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest = i;
    if (left < len && nums[left] > nums[largest]) {
      largest = left;
    }
    if (right < len && nums[right] > nums[largest]) {
      largest = right;
    }
    if (largest != i) {
      swap(nums, largest, i);
      heapify(nums, largest, len);
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
