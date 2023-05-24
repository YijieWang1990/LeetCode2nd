package _124_Binary_Tree_Maximum_Path_Sum;

import static _124_Binary_Tree_Maximum_Path_Sum.Solution.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void name() {
    Solution solution = new Solution();
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;

    solution.maxPathSum(treeNode1);
  }
}