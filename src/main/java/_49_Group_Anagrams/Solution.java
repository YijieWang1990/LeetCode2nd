package _49_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    String[] copy = Arrays.copyOf(strs, strs.length);

    List<String> copyString = Arrays.stream(copy).map(s -> {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      return String.valueOf(chars);
    }).toList();
    Map<String, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < copyString.size(); i++) {
      if (map.containsKey(copyString.get(i))) {
        map.get(copyString.get(i)).add(i);
      } else {
        map.put(copyString.get(i), new ArrayList<>(List.of(i)));
      }
    }
    return map.values().stream().map(item -> item.stream().map(i -> strs[i]).collect(Collectors.toList())).collect(Collectors.toList());
  }
}
