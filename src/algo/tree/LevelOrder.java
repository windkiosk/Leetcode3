package algo.tree;

import java.util.LinkedList;
import util.TreeNode;
import util.TreeNodePrinter;

public class LevelOrder {

  public static void main(String[] args) {
    TreeNode treeNode = TreeNode.SAMPLE_0;
    TreeNodePrinter.printNode(treeNode);
    LevelOrder levelOrder = new LevelOrder();
    levelOrder.levelOrder(treeNode);
  }

  void levelOrder(TreeNode root) {
    if (root == null) return;

    LinkedList<TreeNode> list = new LinkedList<>();
    list.offer(root);
    int count = 1;
    int newCount = 0;
    while (count > 0) {
      TreeNode node = list.poll();
      System.out.println(node.val);
      if (node.left != null) {
        list.offer(node.left);
        newCount ++;
      }
      if (node.right != null) {
        list.offer(node.right);
        newCount ++;
      }
      count --;
      if (count == 0) {
        count = newCount;
        newCount = 0;
      }
    }
  }
}
