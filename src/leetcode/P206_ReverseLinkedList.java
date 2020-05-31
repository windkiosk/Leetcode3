package leetcode;

import util.ListNode;

public class P206_ReverseLinkedList {

  public static void main(String[] args) {
    ListNode listNode = ListNode.fromString("1->5->2->3->4");
    P206_ReverseLinkedList solution = new P206_ReverseLinkedList();
    System.out.println(solution.reverseList(listNode));
  }

  public ListNode reverseList(ListNode head) {
    ListNode last = null;
    while (head != null) {
      ListNode tmp = head.next;
      head.next = last;
      last = head;
      head = tmp;
    }
    return last;
  }
}
