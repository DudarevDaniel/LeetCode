package medium.removenode;

import medium.ListNode;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        RemoveNthNodeFromEnd main = new RemoveNthNodeFromEnd();
//        ListNode tail = new ListNode(5);
//        ListNode fourth = new ListNode(4, tail);
//        ListNode third = new ListNode(3, fourth);
//        ListNode third = new ListNode(3);
//        ListNode second = new ListNode(2, third);
//        ListNode second = new ListNode(2);
//        ListNode head = new ListNode(1, second);
//        ListNode head = new ListNode(1);

        ListNode third = new ListNode(3);
        ListNode second = new ListNode(2, third);
        ListNode head = new ListNode(1, second);
        ListNode newHead = main.removeNthFromEnd(head, 3);
        System.out.println(newHead);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        int counter = 0;
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        while (firstPointer.next != null) {
            counter++;
            firstPointer = firstPointer.next;
            if (counter > n) {
                secondPointer = secondPointer.next;
            }
        }
        if (counter - n < 0) {
            // remove head
            return secondPointer.next;
        }
        if (secondPointer.next.next != null) {
            secondPointer.next = secondPointer.next.next;
        } else {
            secondPointer.next = null;
        }
        return head;
    }
}
