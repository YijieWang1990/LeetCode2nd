package _21_Merge_Two_Sorted_Lists;

class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode();
    ListNode headIndex = dummyHead;
    ListNode index1 = list1;
    ListNode index2 = list2;
    while (index1 != null || index2 != null) {
      if (index1 != null && index2 != null) {
        if (index1.val < index2.val) {
          headIndex.next = index1;
          index1 = index1.next;
        } else {
          headIndex.next = index2;
          index2 = index2.next;
        }
      } else if (index1 == null) {
        headIndex.next = index2;
        index2 = index2.next;
      } else {
        headIndex.next = index1;
        index1 = index1.next;
      }
      headIndex = headIndex.next;
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
