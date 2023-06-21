package _934_Shortest_Bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void name() {
    Solution solution = new Solution();
    solution.shortestBridge(new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 1}});
  }
}