package leetcode;

import util.ListNode;

public class P25_ReverseKGroup {

  public static void main(String[] args) {
    ListNode head = ListNode.fromString("1->2");
    P25_ReverseKGroup solution = new P25_ReverseKGroup();
    System.out.println(solution.reverseKGroup(head, 2));
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null || k < 2) {
      return head;
    }

    ListNode last = head.next;
    ListNode lastTail = null;
    ListNode ret = null;
    int count = 1;
    while (true) {
      last = last.next;
      count++;
      if (count == k) {
        ListNode newHead = reverse(head, count);
        if (lastTail == null) {
          ret = newHead;
        } else {
          lastTail.next = newHead;
        }
        lastTail = head;
        head = last;
        count = 0;
      }

      if (last == null) {
        lastTail.next = head;
        break;
      }
    }

    return ret;
  }

  ListNode reverse(ListNode head, int k) {
    if (k < 2) {
      return head;
    }
    ListNode second = head.next;
    head.next = null;
    int count = 1;
    while (count < k) {
      ListNode third = second.next;
      second.next = head;
      head = second;
      second = third;
      count++;
    }
    return head;
  }
}
