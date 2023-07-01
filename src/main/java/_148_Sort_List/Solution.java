package _148_Sort_List;


class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode midPrev = findMid(head);
    ListNode secondHalf = midPrev.next;
    midPrev.next = null;
    ListNode first = sortList(head);
    ListNode second = sortList(secondHalf);
    return merge(first, second);
  }



  private ListNode merge(ListNode first, ListNode second) {
    ListNode dummyHead = new ListNode();
    ListNode node = dummyHead;
    ListNode n1 = first;
    ListNode n2 = second;
    while (n1 != null || n2 != null) {
      if (n1 == null) {
        node.next = n2;
        n2 = n2.next;
      } else if (n2 == null) {
        node.next = n1;
        n1 = n1.next;
      } else {
        if (n1.val < n2.val) {
          node.next = n1;
          n1 = n1.next;
        } else {
          node.next = n2;
          n2 = n2.next;
        }
      }
      node = node.next;
    }
    return dummyHead.next;
  }

  private ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;
    while (fast != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      }
    }
    return prev;
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