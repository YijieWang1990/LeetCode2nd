package _2_Add_Two_Numbers;

public class Solution {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode();
    ListNode p = dummyHead;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int v1 = 0;
      int v2 = 0;
      if (l1 != null) {
        v1 = l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        v2 = l2.val;
        l2 = l2.next;
      }
      int v = v1 + v2 + carry;
      carry = v / 10;
      p.next = new ListNode(v % 10);
      p = p.next;
    }
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
