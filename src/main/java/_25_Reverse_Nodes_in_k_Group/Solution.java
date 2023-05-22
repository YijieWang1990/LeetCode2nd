package _25_Reverse_Nodes_in_k_Group;

import java.util.Stack;

class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummyHead = new ListNode();
    dummyHead.next = head;
    ListNode current = dummyHead.next;
    ListNode prev = dummyHead;
    while (current != null) {
      ListNode nextStart = getNextStart(current, k);
      prev.next = reverse(current, k, nextStart);
      while (current != nextStart) {
        prev = current;
        current = current.next;
      }
    }
    return dummyHead.next;
  }

  private ListNode getNextStart(ListNode index, int k) {
    if (index == null) {
      return null;
    }
    ListNode nextStart = index;
    while (k > 0) {
      nextStart = nextStart.next;
      k--;
      if (nextStart == null) {
        break;
      }
    }
    return nextStart;
  }

  private ListNode reverse(ListNode node, int k, ListNode nextStart) {
    ListNode dummyHead = new ListNode();
    dummyHead.next = node;
    ListNode index = dummyHead;
    Stack<ListNode> stack = new Stack<>();
    while (stack.size() < k && node != null) {
      stack.push(node);
      node = node.next;
    }
    if (stack.size() < k) {
      return dummyHead.next;
    }
    while (!stack.isEmpty()) {
      index.next = stack.pop();
      index = index.next;
    }
    index.next = nextStart;
    return dummyHead.next;
  }

  public static class ListNode {
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
