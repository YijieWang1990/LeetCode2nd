package _179_Largest_Number;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
  public String largestNumber(int[] nums) {
    String str = Arrays.stream(nums)
        .boxed()
        .sorted(this::customOrder)
        .map(String::valueOf)
        .collect(Collectors.joining(""));
    int i = 0;
    while (i < nums.length - 1) {
      if (str.charAt(i) != '0') {
        break;
      }
      i++;
    }
    return str.substring(i);

  }

  private int customOrder(int a, int b) {
    String s1 = String.valueOf(a) + b;
    String s2 = String.valueOf(b) + a;
    if (s1.length() > s2.length()) {
      return 1;
    } else if (s1.length() < s2.length()) {
      return -1;
    } else {
      int i = 0;
      while (i < s1.length()) {
        int compare = -Integer.compare(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        if (compare == 0) {
          i++;
        } else {
          return compare;
        }
      }
    }
    return 0;
  }

}