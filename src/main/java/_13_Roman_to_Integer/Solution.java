package _13_Roman_to_Integer;

import java.util.Map;

class Solution {
  public int romanToInt(String s) {
    Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50,
        'C', 100, 'D', 500, 'M', 1000);
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      int value = map.get(s.charAt(i));
      if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
        sum -= value;
      } else {
        sum += value;
      }
    }
    return sum;
  }
}
