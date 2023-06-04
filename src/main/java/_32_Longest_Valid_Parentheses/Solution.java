package _32_Longest_Valid_Parentheses;

import java.util.Stack;

class Solution {
  public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.add(-1);
    int max = 0;
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char c = charArray[i];
      if (c == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.add(i);
        }
        max = Math.max(max, i - stack.peek());
      }
    }
    return max;
  }
}