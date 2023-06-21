package _1101_The_Earliest_Moment_When_Everyone_Become_Friends;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void name() {
    Solution solution = new Solution();
    solution.earliestAcq(new int[][]{new int[]{20190101,0,1},
        new int[]{20190104,3,4},
        new int[]{20190107,2,3},
        new int[]{20190211,1,5},
        new int[]{20190224,2,4},
        new int[]{20190301,0,3},
        new int[]{20190312,1,2},
        new int[]{20190322,4,5},
    }, 6);
  }
}
