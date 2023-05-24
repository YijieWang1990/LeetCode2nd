package _239_Sliding_Window_Maximum;

import java.util.PriorityQueue;

class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k <= 1) {
      return nums;
    }
    int[] ans = new int[nums.length - k + 1];
    PriorityQueue<Helper> priorityQueue = new PriorityQueue<>((a, b) -> -Integer.compare(a.value, b.value));
    for (int i = 0; i < k; i++) {
      priorityQueue.add(new Helper(nums[i], i));
    }
    ans[0] = priorityQueue.peek().value;
    int ansIndex = 1;
    for (int i = k; i < nums.length; i++) {
      priorityQueue.add(new Helper(nums[i], i));
      while (!priorityQueue.isEmpty() && priorityQueue.peek().index <= i - k) {
        priorityQueue.poll();
      }
      ans[ansIndex] = priorityQueue.peek().value;
      ansIndex++;
    }
    return ans;
  }

  private static class Helper {
    int value;
    int index;

    public Helper(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }

}
