package _41_First_Missing_Positive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
  public int firstMissingPositive(int[] nums) {
    Set<Integer> integerSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    int missing = 1;
    while (integerSet.contains(missing)) {
      missing++;
    }
    return missing;
  }
}