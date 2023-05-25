package _143_Reorder_List;

import java.util.Stack;

class Solution {
  public void reorderList(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    ListNode dummyHead = new ListNode();
    ListNode p = head;
    while (p != null) {
      stack.push(p);
      p = p.next;
    }
    int count = stack.size();
    p = dummyHead;
    ListNode headIndex = head;
    int size = 0;
    while (true) {
      p.next = headIndex;
      p = p.next;
      headIndex = headIndex.next;
      size++;
      if (size == count) {
        break;
      }
      p.next = stack.pop();
      p = p.next;
      size++;
      if (size == count) {
        break;
      }
    }
    p.next = null;
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
