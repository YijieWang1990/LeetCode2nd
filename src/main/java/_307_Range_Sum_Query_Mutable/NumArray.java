package _307_Range_Sum_Query_Mutable;

class NumArray {

  private final SegmentTreeNode root;
  public NumArray(int[] nums) {
    this.root = buildSegmentTree(nums, 0, nums.length - 1);
  }


  public void update(int index, int val) {
    updateSegmentTree(this.root, index, val);
  }

  private void updateSegmentTree(SegmentTreeNode root, int index, int val) {
    if (root.start == index && root.end == index) {
      root.val = val;
      return;
    }
    int mid = root.start + (root.end - root.start) / 2;
    if (index <= mid) {
      updateSegmentTree(root.left, index, val);
    }else {
      updateSegmentTree(root.right, index, val);
    }
    root.val = root.left.val + root.right.val;
  }

  public int sumRange(int left, int right) {
    return segmentTreeSumRange(this.root, left, right);
  }

  private int segmentTreeSumRange(SegmentTreeNode root, int left, int right) {
    if (root.start == left && root.end == right) {
      return root.val;
    }
    int mid = root.start + (root.end - root.start) / 2;
    if (right <= mid) {
      return segmentTreeSumRange(root.left, left, right);
    }
    if (left > mid) {
      return segmentTreeSumRange(root.right, left, right);
    }
    return segmentTreeSumRange(root.left, left, mid) + segmentTreeSumRange(root.right, mid + 1, right);
  }

  private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
    if (start == end) {
      return new SegmentTreeNode(start, end, nums[start]);
    }
    int mid = start + (end - start) / 2;
    SegmentTreeNode left = buildSegmentTree(nums, start, mid);
    SegmentTreeNode right = buildSegmentTree(nums, mid + 1, end);
    return new SegmentTreeNode(start, end, left.val + right.val, left, right);
  }

  private static class SegmentTreeNode {
    int start;
    int end;

    int val;

    SegmentTreeNode left;
    SegmentTreeNode right;

    public SegmentTreeNode(int start, int end, int val, SegmentTreeNode left, SegmentTreeNode right) {
      this.start = start;
      this.end = end;
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public SegmentTreeNode(int start, int end, int val) {
      this.start = start;
      this.end = end;
      this.val = val;
    }
  }
}
