package _1353_Maximum_Number_of_Events_That_Can_Be_Attended;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int maxEvents(int[][] events) {

    Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int res = 0, last = 1, i = 0, n = events.length;
    while (i < n || !pq.isEmpty()) {
      while (i < n && events[i][0] == last) {
        pq.offer(events[i++][1]);
      }
      while (!pq.isEmpty() && pq.peek() < last) {
        pq.poll();
      }
      if (!pq.isEmpty()) {
        pq.poll();
        res++;
      }
      last++;
    }
    return res;
  }

}