package _1101_The_Earliest_Moment_When_Everyone_Become_Friends;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Solution {

  private final Map<Integer, Set<Integer>> map = new HashMap<>();
  public int earliestAcq(int[][] logs, int n) {
    Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));
    for (int i = 0; i < n; i++) {
      Set<Integer> set = new HashSet<>();
      set.add(i);
      map.put(i, set);
    }
    for (int[] log : logs) {
      int personA = log[1];
      int personB = log[2];
      Set<Integer> personASet = map.get(personA);
      Set<Integer> personBSet = map.get(personB);
      if (!Objects.equals(personASet, personBSet)) {
        personASet.addAll(personBSet);
        if (personASet.size() == n) {
          return log[0];
        }
        personBSet.forEach(person -> map.put(person, personASet));
      }
    }
    return -1;
  }
}
