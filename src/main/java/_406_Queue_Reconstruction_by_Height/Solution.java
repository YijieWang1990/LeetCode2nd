package _406_Queue_Reconstruction_by_Height;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : -Integer.compare(a[0], b[0]));
    List<int[]> queue = new ArrayList<>();
    for (int[] person : people) {
      queue.add(person[1], person);
    }
    return queue.toArray(new int[queue.size()][]);
  }
}
