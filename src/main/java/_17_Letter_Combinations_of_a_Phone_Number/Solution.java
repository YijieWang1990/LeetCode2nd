package _17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
  private Map<Character, List<Character>> map = Map.of(
      '2', List.of('a', 'b', 'c'),
      '3', List.of('d', 'e', 'f'),
      '4', List.of('g', 'h', 'i'),
      '5', List.of('j', 'k', 'l'),
      '6', List.of('m', 'n', 'o'),
      '7', List.of('p', 'q', 'r', 's'),
      '8', List.of('t', 'u', 'v'),
      '9', List.of('w', 'x', 'y', 'z')
  );
  private StringBuilder builder = new StringBuilder();
  private List<String> ans = new ArrayList<>();
  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) {
      return List.of();
    }
    dfs(digits, 0);
    return ans;
  }

  private void dfs(String digits, int index) {
    if (builder.length() == digits.length()) {
      ans.add(builder.toString());
      return;
    }
    for (int i = index; i < digits.length(); i++) {
      char c = digits.charAt(i);
      List<Character> characters = map.get(c);
      for (Character character : characters) {
        builder.append(character);
        dfs(digits, i + 1);
        builder.deleteCharAt(builder.length() - 1);
      }
    }
  }
}