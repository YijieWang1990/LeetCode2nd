package _4_Median_of_Two_Sorted_Arrays;

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int size = nums1.length + nums2.length;
    if (size % 2 == 0) {
      return ((double) findKthNum(nums1, nums2, size / 2) + (double) findKthNum(nums1, nums2, size / 2 + 1)) / 2;
    }
    return findKthNum(nums1, nums2, size / 2 + 1);
  }

  private int findKthNum(int[] nums1, int[] nums2, int k) {
    int index1 = 0;
    int index2 = 0;
    int m = k / 2;
    while (true) {
      if (index1 >= nums1.length) {
        return nums2[index2 + k - 1];
      }
      if (index2 >= nums2.length) {
        return nums1[index1 + k - 1];
      }
      if (k == 1) {
        return Math.min(nums1[index1], nums2[index2]);
      }
      int targetIndex1 = Math.min(index1 + m, nums1.length) - 1;
      int targetIndex2 = Math.min(index2 + m, nums2.length) - 1;
      int n1 = nums1[targetIndex1];
      int n2 = nums2[targetIndex2];
      if (n1 <= n2) {
        k -= (targetIndex1 - index1 + 1);
        index1 = targetIndex1 + 1;
      } else {
        k -= (targetIndex2 - index2 + 1);
        index2 = targetIndex2 + 1;
      }
      m = k / 2;
    }
  }

}
