package _934_Shortest_Bridge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public int shortestBridge(int[][] grid) {
    boolean found = false;
    Island firstIsland = new Island(0, 0);
    for (int i = 0; i < grid.length && !found; i++) {
      for (int j = 0; j < grid[i].length && !found; j++) {
        if (grid[i][j] == 1) {
          firstIsland.x = i;
          firstIsland.y = j;
          found = true;
        }
      }
    }

    List<Island> firstIslands = getFirstIslands(firstIsland, grid);

    return getMinDistance(firstIslands, grid);
  }

  private int getMinDistance(List<Island> firstIslands, int[][] grid) {
    boolean[][] visit = new boolean[grid.length][grid[0].length];
    Queue<Island> queue = new LinkedList<>();
    for (Island island : firstIslands) {
      queue.add(island);
      visit[island.x][island.y] = true;
    }
    int count = 0;
    do {
      List<Island> next = new ArrayList<>();
      while (!queue.isEmpty()) {
        next.add(queue.poll());
      }
      for (Island currentIsland : next) {
        if (currentIsland.x > 0 && !visit[currentIsland.x - 1][currentIsland.y]) {
          Island island = new Island(currentIsland.x - 1, currentIsland.y);
          if (grid[island.x][island.y] == 1) {
            return count;
          }
          queue.add(island);
          visit[currentIsland.x - 1][currentIsland.y] = true;
        }
        if (currentIsland.x < grid.length - 1 && !visit[currentIsland.x + 1][currentIsland.y]) {
          Island island = new Island(currentIsland.x + 1, currentIsland.y);
          if (grid[island.x][island.y] == 1) {
            return count;
          }
          queue.add(island);
          visit[currentIsland.x + 1][currentIsland.y] = true;
        }
        if (currentIsland.y > 0 && !visit[currentIsland.x][currentIsland.y - 1]) {
          Island island = new Island(currentIsland.x, currentIsland.y - 1);
          if (grid[island.x][island.y] == 1) {
            return count;
          }
          queue.add(island);
          visit[currentIsland.x][currentIsland.y - 1] = true;
        }
        if (currentIsland.y < grid[0].length - 1 && !visit[currentIsland.x][currentIsland.y + 1]) {
          Island island = new Island(currentIsland.x, currentIsland.y + 1);
          if (grid[island.x][island.y] == 1) {
            return count;
          }
          queue.add(island);
          visit[currentIsland.x][currentIsland.y + 1] = true;
        }
      }
      count++;
    } while (!queue.isEmpty());
    return count;
  }

  private List<Island> getFirstIslands(Island firstIsland, int[][] grid) {
    List<Island> firstIslands = new ArrayList<>();
    boolean[][] visit = new boolean[grid.length][grid[0].length];
    visit[firstIsland.x][firstIsland.y] = true;
    Queue<Island> queue = new LinkedList<>();
    queue.add(firstIsland);
    firstIslands.add(firstIsland);
    do {
      List<Island> next = new ArrayList<>();
      while (!queue.isEmpty()) {
        next.add(queue.poll());
      }
      for (Island currentIsland : next) {
        if (currentIsland.x > 0 && grid[currentIsland.x - 1][currentIsland.y] == 1 && !visit[currentIsland.x - 1][currentIsland.y]) {
          Island island = new Island(currentIsland.x - 1, currentIsland.y);
          queue.add(island);
          visit[currentIsland.x - 1][currentIsland.y] = true;
          firstIslands.add(island);
        }
        if (currentIsland.x < grid.length - 1 && grid[currentIsland.x + 1][currentIsland.y] == 1 && !visit[currentIsland.x + 1][currentIsland.y]) {
          Island island = new Island(currentIsland.x + 1, currentIsland.y);
          queue.add(island);
          visit[currentIsland.x + 1][currentIsland.y] = true;
          firstIslands.add(island);
        }
        if (currentIsland.y > 0 && grid[currentIsland.x][currentIsland.y - 1] == 1 && !visit[currentIsland.x][currentIsland.y - 1]) {
          Island island = new Island(currentIsland.x, currentIsland.y - 1);
          queue.add(island);
          visit[currentIsland.x][currentIsland.y - 1] = true;
          firstIslands.add(island);
        }
        if (currentIsland.y < grid[0].length - 1 && grid[currentIsland.x][currentIsland.y + 1] == 1 && !visit[currentIsland.x][currentIsland.y + 1]) {
          Island island = new Island(currentIsland.x, currentIsland.y + 1);
          queue.add(island);
          visit[currentIsland.x][currentIsland.y + 1] = true;
          firstIslands.add(island);
        }
      }
    } while (!queue.isEmpty());
    return firstIslands;
  }

  private static class Island {
    int x;
    int y;

    public Island(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

}