package leetcode;

import util.ListNode;

public class P206_ReverseLinkedList {

  public static void main(String[] args) {
    ListNode listNode = ListNode.fromString("1->5->2->3->4");
    P206_ReverseLinkedList p206_reverseLinkedList = new P206_ReverseLinkedList();
    System.out.println(p206_reverseLinkedList.reverseList(listNode));
  }

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode second = head.next;
    head.next = null;
    ListNode third = second.next; // Nullable

    while (second != null) {
      second.next = head;
      head = second;
      second = third;
      if (third != null) {
        third = third.next;
      }
    }

    return head;
  }
}
