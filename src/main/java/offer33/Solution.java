package offer33;

class Solution {
  public boolean verifyPostorder(int[] postorder) {
    return check(postorder, 0, postorder.length - 1);
  }

  private boolean check(int[] postorder, int start, int end) {
    if (start >= end) {
      return true;
    }
    int index = start;
    while (index < end) {
      if (postorder[index] > postorder[end]) {
        break;
      }
      index++;
    }
    int mid = index;
    while (index < end) {
      if (postorder[index] < postorder[end]) {
        break;
      }
      index++;
    }
    boolean left = check(postorder, start, mid-1);
    boolean right = check(postorder, mid, end - 1);
    return index == end && left && right;
  }
}