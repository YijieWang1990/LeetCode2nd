package _2402_Meeting_Rooms_III;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int mostBooked(int n, int[][] meetings) {
    int[] count = new int[n];
    PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      availableRooms.offer(i);
    }
    PriorityQueue<Room> busyRooms = new PriorityQueue<>((r1, r2) -> {
      int endTimeCompare = Long.compare(r1.endTime, r2.endTime);
      if (endTimeCompare == 0) {
        return Integer.compare(r1.number, r2.number);
      }
      return endTimeCompare;
    });
    Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

    for (int[] meeting : meetings) {
      long start = meeting[0];
      long end = meeting[1];
      while (!busyRooms.isEmpty() && busyRooms.peek().endTime <= start) {
        availableRooms.offer(busyRooms.poll().number);
      }
      int number;
      if (availableRooms.isEmpty()) {
        Room earliestEndRoom = busyRooms.poll();
        end += earliestEndRoom.endTime - start;
        number = earliestEndRoom.number;
      } else {
        number = availableRooms.poll();
      }
      count[number]++;
      busyRooms.add(new Room(number, end));

    }
    int ans = 0;
    for (int i = 0; i < count.length; i++) {
      if (count[i] > count[ans]) {
        ans = i;
      }
    }
    return ans;
  }


  private static class Room {
    long endTime;
    int number;

    public Room(int number, long endTime) {
      this.number = number;
      this.endTime = endTime;
    }
  }

}