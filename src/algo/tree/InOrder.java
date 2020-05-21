package algo.tree;

import java.util.Stack;
import util.TreeNode;
import util.TreeNodePrinter;

public class InOrder {

  public static void main(String[] args) {
    TreeNode treeNode = TreeNode.SAMPLE_0;
    TreeNodePrinter.printNode(treeNode);

    InOrder inOrder = new InOrder();
    inOrder.inOrder(treeNode);
    System.out.println("---");
    inOrder.inOrderRecur(treeNode);
  }

  void inOrder(TreeNode root) {
    if (root == null) return;

    inOrder(root.left);
    System.out.println(root.val);
    inOrder(root.right);
  }

  void inOrderRecur(TreeNode root) {
    if (root == null) return;

    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while (node != null) {
      stack.push(node);
      node = node.left;
    }

    while (!stack.isEmpty()) {
      node = stack.pop();
      System.out.println(node.val);
      if (node.right != null) {
        node = node.right;
        while (node != null) {
          stack.push(node);
          node = node.left;
        }
      }
    }
  }
}
