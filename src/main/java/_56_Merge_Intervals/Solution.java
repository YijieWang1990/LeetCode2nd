package _56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    List<int[]> ans = new ArrayList<>();

    int slow = 0;
    int fast = 1;
    while (fast < intervals.length) {
      if (intervals[slow][1] < intervals[fast][0]) {
        ans.add(intervals[slow]);
        slow = fast;
      } else if (intervals[slow][1] >= intervals[fast][0] && intervals[slow][1] < intervals[fast][1]) {
        intervals[slow][1] = intervals[fast][1];
      }
      fast++;
    }
    ans.add(intervals[slow]);
    return ans.toArray(new int[][]{});
  }
}