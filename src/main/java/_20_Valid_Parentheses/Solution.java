package _20_Valid_Parentheses;

import java.util.Set;
import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    Set<Character> bracketSet = Set.of('(', '[', '{');
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (bracketSet.contains(c)) {
        stack.push(c);
      }else {
        if (stack.isEmpty()) {
          return false;
        }else {
          Character pop = stack.pop();
          if ((pop == '(' && c != ')') || (pop == '[' && c != ']') || (pop == '{' && c != '}')) {
            return false;
          }
        }
      }
    }
    return stack.isEmpty();
  }
}