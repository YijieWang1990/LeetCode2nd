package _139_Word_Break;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void name() {
    Solution solution = new Solution();
    solution.wordBreak("aaaaaaa", List.of("aaaa", "aaa"));
  }
}