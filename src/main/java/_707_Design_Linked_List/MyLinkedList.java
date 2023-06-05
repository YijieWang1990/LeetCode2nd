package _707_Design_Linked_List;

import java.util.ArrayList;
import java.util.List;

class MyLinkedList {

  private final Node dummyHead;
  private final Node dummyTail;
  private int count;

  public MyLinkedList() {
    dummyHead = new Node(0);
    dummyTail = new Node(0);
    count = 0;
    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;
  }

  public int get(int index) {
    if (index >= count || index < 0) {
      return -1;
    }
    int i = 0;
    Node node = dummyHead.next;
    while (i < index) {
      node = node.next;
      i++;
    }
    return node.value;
  }

  public void addAtHead(int val) {
    Node node = new Node(val);
    node.next = dummyHead.next;
    node.prev = dummyHead;
    dummyHead.next.prev = node;
    dummyHead.next = node;
    count++;
  }

  public void addAtTail(int val) {
    Node node = new Node(val);
    node.next = dummyTail;
    node.prev = dummyTail.prev;
    dummyTail.prev.next = node;
    dummyTail.prev = node;
    count++;
  }

  public void addAtIndex(int index, int val) {
    if (index > count) {
      return;
    }
    int i = 0;
    Node node = dummyHead;
    while (i < index) {
      node = node.next;
      i++;
    }
    Node newNode = new Node(val);
    newNode.next = node.next;
    newNode.prev = node;
    node.next.prev = newNode;
    node.next = newNode;
    count++;
  }

  public void deleteAtIndex(int index) {
    if (index >= count) {
      return;
    }
    int i = 0;
    Node node = dummyHead.next;
    while (i < index) {
      node = node.next;
      i++;
    }
    node.prev.next = node.next;
    node.next.prev = node.prev;
    count--;
  }

  private static class Node{
    int value;
    Node next;
    Node prev;

    public Node(int value) {
      this.value = value;
    }
  }
}