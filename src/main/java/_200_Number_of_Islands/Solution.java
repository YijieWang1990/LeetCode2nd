package _200_Number_of_Islands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public int numIslands(char[][] grid) {
    boolean[][] vis = new boolean[grid.length][grid[0].length];
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (!vis[i][j] && grid[i][j] == '1') {
          count++;
          bfs(grid, vis, i, j);
        }
      }
    }
    return count;
  }

  private void bfs(char[][] grid, boolean[][] vis, int i, int j) {
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(i, j));
    do {
      List<Point> points = new ArrayList<>();
      while (!queue.isEmpty()) {
        Point current = queue.poll();
        if (current.x > 0 && !vis[current.x - 1][current.y] && grid[current.x - 1][current.y] == '1') {
          vis[current.x - 1][current.y] = true;
          points.add(new Point(current.x - 1, current.y));
        }
        if (current.y > 0 && !vis[current.x][current.y - 1] && grid[current.x][current.y - 1] == '1') {
          vis[current.x][current.y - 1] = true;
          points.add(new Point(current.x, current.y - 1));
        }
        if (current.x < grid.length - 1 && !vis[current.x + 1][current.y] && grid[current.x + 1][current.y] == '1') {
          vis[current.x + 1][current.y] = true;
          points.add(new Point(current.x + 1, current.y));
        }
        if (current.y < grid[i].length - 1 && !vis[current.x][current.y + 1] && grid[current.x][current.y + 1] == '1') {
          vis[current.x][current.y + 1] = true;
          points.add(new Point(current.x, current.y + 1));
        }
      }
      queue.addAll(points);
    } while (!queue.isEmpty());
  }

  private static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}