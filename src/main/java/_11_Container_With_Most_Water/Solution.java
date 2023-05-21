package _11_Container_With_Most_Water;

class Solution {
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while (left < right) {
      int current = (right - left) * Math.min(height[left], height[right]);
      max = Math.max(current, max);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }
}
