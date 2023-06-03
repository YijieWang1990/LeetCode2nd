package _912_Sort_an_Array;

import java.util.Random;

class Solution {
  public int[] sortArray(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
    return nums;
  }

  private void quickSort(int[] nums, int start, int end) {
    if (start >= end) {
      return;
    }
    int pivot = partition(nums, start, end);
    quickSort(nums, start, pivot - 1);
    quickSort(nums, pivot+1, end);
  }

  private int partition(int[] nums, int start, int end) {
    int i = start;
    int j = start;
    int randomNumber = getRandomNumber(start, end);
    swap(nums, randomNumber, end);
    while (j < end) {
      if (nums[j] < nums[end]) {
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

  private int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }
}