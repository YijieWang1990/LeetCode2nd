package _1110_Delete_Nodes_And_Return_Forest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

  private final List<TreeNode> ans = new ArrayList<>();

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

    Set<Integer> deleteSet = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());

    if (!deleteSet.contains(root.val)) {
      ans.add(root);
    }
    dfs(root, deleteSet);


    return ans;
  }

  private TreeNode dfs(TreeNode root, Set<Integer> deleteSet) {
    if (root == null) {
      return null;
    }

    root.left = dfs(root.left, deleteSet);
    root.right = dfs(root.right, deleteSet);

    if (deleteSet.contains(root.val)) {
      if (root.left != null) {
        ans.add(root.left);
      }
      if (root.right != null) {
        ans.add(root.right);
      }
      root = null;
    }
    return root;
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
