import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void name() {
    Solution solution = new Solution();
    solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
  }
}