package _349_Intersection_of_Two_Arrays;

import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.Set;

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(toSet());
    Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(toSet());
    set1.retainAll(set2);
    return set1.stream().mapToInt(i -> i).toArray();
  }
}
