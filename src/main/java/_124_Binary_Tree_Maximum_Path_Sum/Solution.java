package _124_Binary_Tree_Maximum_Path_Sum;



class Solution {
  private int max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    sum(root);
    return max;
  }

  private int sum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftSum = sum(root.left);
    int rightSum = sum(root.right);
    int maxRootSum = Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));
    max = Math.max(max, Math.max(root.val + leftSum + rightSum, maxRootSum));
    return maxRootSum;
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
