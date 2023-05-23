package offer06;


import java.util.Stack;

class Solution {
  public int[] reversePrint(ListNode head) {
    Stack<Integer> stack = new Stack<>();
    ListNode index = head;
    while (index != null) {
      stack.add(index.val);
      index = index.next;
    }
    int[] ans = new int[stack.size()];
    int i = 0;
    while (!stack.isEmpty()) {
      ans[i] = stack.pop();
      i++;
    }
    return ans;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
