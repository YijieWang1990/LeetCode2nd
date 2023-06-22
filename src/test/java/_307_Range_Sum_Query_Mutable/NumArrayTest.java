package _307_Range_Sum_Query_Mutable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumArrayTest {
  @Test
  void name() {
    NumArray numArray = new NumArray(new int[]{1, 3, 5});
    numArray.sumRange(0, 2);
    numArray.update(1, 2);
    numArray.sumRange(0, 2);
  }
}