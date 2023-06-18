package offer51;

class Solution {
  public int reversePairs(int[] nums) {
    int[] temp = new int[nums.length];

    return countReversePairs(nums, 0, nums.length - 1, temp);
  }

  private int countReversePairs(int[] nums, int start, int end, int[] temp) {
    if (start >= end) {
      return 0;
    }

    int mid = start + (end - start) / 2;

    int leftCount = countReversePairs(nums, start, mid, temp);
    int rightCount = countReversePairs(nums, mid + 1, end, temp);
    if (nums[mid] <= nums[mid + 1]) {
      return leftCount + rightCount;
    }
    int crossCount = mergeAndCount(nums, start, mid, end, temp);
    return leftCount + rightCount + crossCount;
  }

  private int mergeAndCount(int[] nums, int start, int mid, int end, int[] temp) {
    for (int i = start; i <= end; i++) {
      temp[i] = nums[i];
    }

    int i = start;
    int j = mid + 1;
    int count = 0;
    for (int k = start; k <= end; k++) {
      if (i >= mid + 1) {
        nums[k] = temp[j];
        j++;
      } else if (j >= end + 1) {
        nums[k] = temp[i];
        i++;
      } else if (temp[i] <= temp[j]) {
        nums[k] = temp[i];
        i++;
      } else {
        nums[k] = temp[j];
        j++;
        count += (mid - i + 1);
      }
    }
    return count;
  }
}