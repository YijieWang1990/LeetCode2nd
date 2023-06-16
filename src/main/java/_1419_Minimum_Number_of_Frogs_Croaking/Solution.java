package _1419_Minimum_Number_of_Frogs_Croaking;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public int minNumberOfFrogs(String croakOfFrogs) {
    int num = 0;
    List<StringBuilder> stringBuilders = new ArrayList<>();
    for (int i = 0; i < croakOfFrogs.length(); i++) {
      char c = croakOfFrogs.charAt(i);
      boolean match = false;
      for (int j = 0; j < stringBuilders.size(); j++) {
        StringBuilder builder = stringBuilders.get(j);
        if (isValid(builder, c)) {
          builder.append(c);
          match = true;
          if (builder.length() == 5) {
            stringBuilders.remove(j);
          }
          break;
        }
      }
      if (!match) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilders.add(stringBuilder);
      }
      num = Math.max(num, stringBuilders.size());
    }
    if (!stringBuilders.isEmpty()) {
      return -1;
    }
    return num;
  }

  private boolean isValid(StringBuilder stringBuilder, char c) {
    return stringBuilder.charAt(stringBuilder.length() - 1) == 'c' && c == 'r' ||
        stringBuilder.charAt(stringBuilder.length() - 1) == 'r' && c == 'o' ||
        stringBuilder.charAt(stringBuilder.length() - 1) == 'o' && c == 'a' ||
        stringBuilder.charAt(stringBuilder.length() - 1) == 'a' && c == 'k';
  }
}