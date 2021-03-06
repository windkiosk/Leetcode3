package algo.tree;

import java.util.Stack;
import util.TreeNode;
import util.TreeNodePrinter;

public class PreOrder {

  public static void main(String[] args) {
    TreeNode treeNode = TreeNode.SAMPLE_0;
    TreeNodePrinter.printNode(treeNode);

    PreOrder preOrder = new PreOrder();
    preOrder.preOrder(treeNode);
    System.out.println("---");
    preOrder.preOrderRecur(treeNode);
  }

  void preOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    System.out.println(root.val);

    preOrder(root.left);
    preOrder(root.right);
  }

  void preOrderRecur(TreeNode root) {
    if (root == null) return;

    TreeNode node = root;
    Stack<TreeNode> stack = new Stack<>();
    while (node != null) {
      System.out.println(node.val);
      stack.push(node);
      node = node.left;
    }

    while (!stack.isEmpty()) {
      node = stack.pop();
      if (node.right != null) {
        node = node.right;
        while (node != null) {
          System.out.println(node.val);
          stack.push(node);
          node = node.left;
        }
      }
    }
  }
}
