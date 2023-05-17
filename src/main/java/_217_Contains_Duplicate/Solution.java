package _217_Contains_Duplicate;

import static java.util.stream.Collectors.toSet;

import java.util.Arrays;

class Solution {
  public boolean containsDuplicate(int[] nums) {
    return Arrays.stream(nums).boxed().collect(toSet()).size() == nums.length;
  }
}
