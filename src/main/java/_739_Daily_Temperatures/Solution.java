package _739_Daily_Temperatures;

import java.util.Stack;

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] ans = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      int temperature = temperatures[i];
      while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
        Integer index = stack.pop();
        ans[index] = i - index;
      }
      stack.add(i);
    }
    return ans;
  }
}