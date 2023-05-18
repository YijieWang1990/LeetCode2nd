package _146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
  private final int capacity;
  private final Map<Integer, Node> cache;
  private final Node head;

  private final Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
    this.cache = new HashMap<>();
  }

  public int get(int key) {
    Node node = cache.get(key);
    if (node == null) {
      return -1;
    }
    remove(node);
    addToHead(node);
    return node.value;
  }

  private void addToHead(Node node) {
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
    node.prev = head;
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public void put(int key, int value) {
    Node existNode = cache.get(key);
    if (existNode != null) {
      existNode.value = value;
      remove(existNode);
      addToHead(existNode);
    }else {
      Node node = new Node(key, value);
      cache.put(key, node);
      addToHead(node);
      if (cache.size() > capacity) {
        Node last = tail.prev;
        cache.remove(last.key);
        remove(last);
      }
    }
  }

  private static class Node {
    int key;

    int value;

    Node next;

    Node prev;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
