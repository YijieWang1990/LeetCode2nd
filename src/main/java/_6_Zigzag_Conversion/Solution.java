package _6_Zigzag_Conversion;

class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      int j = i;
      boolean isMid = true;
      while (j < s.length()) {
        stringBuilder.append(s.charAt(j));
        j = getNext(i, j, numRows, isMid);
        isMid = !isMid;
      }
    }
    return stringBuilder.toString();
  }

  private int getNext(int i, int j, int numRows, boolean isMid) {
    if (i == 0 || i == numRows - 1) {
      return j + 2 * numRows - 2;
    }
    if (isMid) {
      return j + 2 * numRows - 2 - i * 2;
    }
    return j + i * 2;

  }
}