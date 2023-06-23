package _23_Merge_k_Sorted_Lists;



class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    return merge(lists, 0, lists.length - 1);
  }

  private ListNode merge(ListNode[] lists, int start, int end) {
    if (start == end) {
      return lists[start];
    }
    if (start + 1 == end) {
      return mergeTwoList(lists[start], lists[end]);
    }

    int mid = start + (end - start) / 2;
    ListNode firstHalf = merge(lists, start, mid);
    ListNode secondHalf = merge(lists, mid + 1, end);
    return mergeTwoList(firstHalf, secondHalf);
  }

  private ListNode mergeTwoList(ListNode node1, ListNode node2) {
    ListNode index1 = node1;
    ListNode index2 = node2;
    ListNode dummyHead = new ListNode();
    ListNode index = dummyHead;

    while (index1 != null || index2 != null) {
      if (index1 == null) {
        index.next = index2;
        index2 = index2.next;
      } else if (index2 == null) {
        index.next = index1;
        index1 = index1.next;
      } else {
        if (index1.val < index2.val) {
          index.next = index1;
          index1 = index1.next;
        } else {
          index.next = index2;
          index2 = index2.next;
        }
      }
      index = index.next;
    }

    return dummyHead.next;
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
