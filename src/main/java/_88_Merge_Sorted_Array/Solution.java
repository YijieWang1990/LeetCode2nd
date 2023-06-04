package _88_Merge_Sorted_Array;

class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] ans = new int[m + n];
    int i1 = 0;
    int i2 = 0;
    int curr = 0;
    while (i1 < m || i2 < n) {
      if (i1 == m) {
        ans[curr] = nums2[i2];
        i2++;
      } else if (i2 == n) {
        ans[curr] = nums1[i1];
        i1++;
      } else if (nums1[i1] < nums2[i2]) {
        ans[curr] = nums1[i1];
        i1++;
      } else {
        ans[curr] = nums2[i2];
        i2++;
      }
      curr++;
    }
    if (m + n >= 0) {
      System.arraycopy(ans, 0, nums1, 0, m + n);
    }
  }
}
