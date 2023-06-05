package _165_Compare_Version_Numbers;

class Solution {
  public int compareVersion(String version1, String version2) {
    String[] split1 = version1.split("\\.");
    String[] split2 = version2.split("\\.");
    int i1 = 0;
    int i2 = 0;
    while (i1 < split1.length || i2 < split2.length) {
      int v1 = 0;
      int v2 = 0;
      if (i1 < split1.length) {
        v1 = Integer.parseInt(split1[i1]);
      }
      if (i2 < split2.length) {
        v2 = Integer.parseInt(split2[i2]);
      }
      int compare = Integer.compare(v1, v2);
      if (compare == 0) {
        i1++;
        i2++;
      } else {
        return compare;
      }
    }
    return 0;
  }
}