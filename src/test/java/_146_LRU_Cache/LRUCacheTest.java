package _146_LRU_Cache;

import org.junit.jupiter.api.Test;

class LRUCacheTest {
  @Test
  void name() {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(2, 1);
    lruCache.put(1,1);
    lruCache.put(2, 3);
    lruCache.put(4, 1);
    lruCache.get(1);
    lruCache.get(2);
  }
}