package _904_Fruit_Into_Baskets;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int totalFruit(int[] fruits) {
    int max = 0;
    int slow = 0;
    int fast = 0;
    int currentCount = 0;
    Map<Integer, Integer> fruitsCountMap = new HashMap<>();
    while (fast < fruits.length) {
      if (!fruitsCountMap.containsKey(fruits[fast])) {
        while (fruitsCountMap.size() == 2) {
          removeFruit(fruitsCountMap, fruits[slow]);
          slow++;
          currentCount--;
        }
      }
      addFruit(fruitsCountMap, fruits[fast]);
      currentCount++;
      max = Math.max(max, currentCount);
      fast++;
    }
    return max;
  }

  private void addFruit(Map<Integer, Integer> fruitsCountMap, int fruit) {
    fruitsCountMap.put(fruit, fruitsCountMap.getOrDefault(fruit, 0) + 1);
  }

  private void removeFruit(Map<Integer, Integer> fruitsCountMap, int fruit) {
    Integer count = fruitsCountMap.get(fruit);
    if (count == 1) {
      fruitsCountMap.remove(fruit);
    } else {
      fruitsCountMap.put(fruit, count - 1);
    }
  }
}
