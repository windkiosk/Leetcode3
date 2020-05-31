package leetcode;

import java.util.HashSet;
import java.util.Set;
import util.TreeNode;

public class P653_TwoSumIV {

  public static void main(String[] args) {
    TreeNode root = TreeNode.SAMPLE_0;
    P653_TwoSumIV solution = new P653_TwoSumIV();
    System.out.println(solution.findTarget(root, 17));
  }

  private final Set<Integer> set = new HashSet<>();

  private boolean findTarget(TreeNode root, int k) {
    if (root == null) {
      return false;
    }

    if (set.contains(k - root.val)) {
      return true;
    } else {
      set.add(root.val);
    }

    return findTarget(root.left, k) || findTarget(root.right, k);
  }
}
