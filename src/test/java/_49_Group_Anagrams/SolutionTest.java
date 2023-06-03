package _49_Group_Anagrams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void name() {
    Solution solution = new Solution();
    solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
  }
}