package algo.tree;

import java.util.Stack;
import util.TreeNode;
import util.TreeNodePrinter;

public class PostOrder {

  public static void main(String[] args) {
    TreeNode treeNode = TreeNode.SAMPLE_0;
    TreeNodePrinter.printNode(treeNode);

    PostOrder postOrder = new PostOrder();
    postOrder.postOrder(treeNode);
    System.out.println("---");
    postOrder.postOrderRecur(treeNode);
  }

  void postOrder(TreeNode root) {
    if (root == null) return;

    postOrder(root.left);
    postOrder(root.right);
    System.out.println(root.val);
  }

  void postOrderRecur(TreeNode root) {
    if (root == null) return;

    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> ret = new Stack<>();

    TreeNode node = root;
    while (node != null) {
      ret.push(node.val);
      stack.push(node);
      node = node.right;
    }

    while (!stack.isEmpty()) {
      node = stack.pop();
      if (node.left != null) {
        node = node.left;
        while (node != null) {
          ret.push(node.val);
          stack.push(node);
          node = node.right;
        }
      }
    }

    while (!ret.isEmpty()) {
      System.out.println(ret.pop());
    }
  }
}
