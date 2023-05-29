package _347_Top_K_Frequent_Elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> -Integer.compare(a.getValue(), b.getValue()));
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    map.entrySet().forEach(queue::add);
    int[] ans = new int[k];
    int i = 0;
    while (i < k) {
      ans[i] = queue.poll().getKey();
      i++;
    }
    return ans;
  }
}
