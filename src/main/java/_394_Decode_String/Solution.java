package _394_Decode_String;

import java.util.Stack;

class Solution {

  public String decodeString(String s) {
    return decode(s);
  }

  private String decode(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = 0;
    while (i < s.length()) {
      if (Character.isDigit(s.charAt(i))) {
        int indexOfPosBracket = getIndexOfPosBracket(s, i);
        int repeatNumber = Integer.parseInt(s.substring(i, indexOfPosBracket));
        int indexOfRelatedNegBracket = getIndexOfNegBracket(s, indexOfPosBracket);
        String str = decode(s.substring(indexOfPosBracket + 1, indexOfRelatedNegBracket));
        stringBuilder.append(str.repeat(repeatNumber));
        i = indexOfRelatedNegBracket;
      } else {
        stringBuilder.append(s.charAt(i));
      }
      i++;
    }
    return stringBuilder.toString();
  }

  private int getIndexOfNegBracket(String s, int indexOfPosBracket) {
    Stack<Character> stack = new Stack<>();
    int i = indexOfPosBracket;
    while (i < s.length()) {
      if (s.charAt(i) == '[') {
        stack.add('[');
      } else if (s.charAt(i) == ']') {
        stack.pop();
      }

      if (stack.isEmpty()) {
        break;
      }
      i++;
    }
    return i;
  }

  private int getIndexOfPosBracket(String s, int start) {
    int i = start;
    while (s.charAt(i) != '[') {
      i++;
    }
    return i;
  }
}
