package _142_Linked_List_Cycle_II;



public class Solution {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    boolean hasCycle = false;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast == null) {
        break;
      }
      fast = fast.next;
      if (slow == fast) {
        hasCycle = true;
        break;
      }
    }
    if (!hasCycle) {
      return null;
    }
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}