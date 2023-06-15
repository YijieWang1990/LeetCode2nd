package _383_Ransom_Note;

import static java.util.stream.Collectors.counting;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Long> ransomMap
        = ransomNote.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), counting()));

    Map<Character, Long> magazineMap = magazine.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), counting()));

    for (Map.Entry<Character, Long> entry : ransomMap.entrySet()) {
      if (entry.getValue() > magazineMap.getOrDefault(entry.getKey(), 0L)) {
        return false;
      }
    }
    return true;
  }
}