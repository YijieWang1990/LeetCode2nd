package offer26;


class Solution {
  public boolean isSubStructure(TreeNode A, TreeNode B) {
    return (A != null && B != null) && (check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
  }

  private boolean check(TreeNode a, TreeNode b) {
    if (b == null) {
      return true;
    }
    if (a == null) {
      return false;
    }
    if (a.val == b.val) {
      return check(a.left, b.left) && check(a.right, b.right);
    }
    return false;
  }


  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}