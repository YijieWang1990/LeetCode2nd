package _543_Diameter_of_Binary_Tree;



class Solution {

  private int max = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return max;
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = dfs(root.left);
    int right = dfs(root.right);
    max = Math.max(max, left + right);
    return Math.max(left, right) + 1;
  }
  public static class TreeNode {
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
