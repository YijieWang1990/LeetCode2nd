package _2458_Height_of_Binary_Tree_After_Subtree_Removal_Queries;


import java.util.HashMap;
import java.util.Map;

class Solution {

  private final Map<TreeNode, Integer> nodeHeightMap = new HashMap<>();
  private final Map<Integer, Integer> otherPartHeight = new HashMap<>();
  public int[] treeQueries(TreeNode root, int[] queries) {
    getHeight(root);
    dfs(root, -1, 0);
    int[] ans = new int[queries.length];
    int ansIndex = 0;
    for (int query : queries) {
      ans[ansIndex] = otherPartHeight.get(query);
      ansIndex++;
    }
    return ans;
  }

  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    int height = Math.max(leftHeight, rightHeight) + 1;
    nodeHeightMap.put(root, height);
    return height;
  }

  private void dfs(TreeNode root, int depth, int restHeight) {
    if (root == null) {
      return;
    }
    depth++;
    otherPartHeight.put(root.val, restHeight);
    dfs(root.left, depth, Math.max(restHeight, depth + nodeHeightMap.getOrDefault(root.right, 0)));
    dfs(root.right, depth, Math.max(restHeight, depth + nodeHeightMap.getOrDefault(root.left, 0)));
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
