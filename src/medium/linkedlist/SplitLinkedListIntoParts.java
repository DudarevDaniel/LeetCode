package medium.linkedlist;

import medium.ListNode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/split-linked-list-in-parts/">LeetCode</a>
 */
public class SplitLinkedListIntoParts {

    public static void main(String[] args) {
        SplitLinkedListIntoParts main = new SplitLinkedListIntoParts();
//        ListNode tail = new ListNode(10);
//        ListNode elem9 = new ListNode(9, tail);
//        ListNode elem8 = new ListNode(8, elem9);
//        ListNode elem7 = new ListNode(7, elem8);
//        ListNode elem6 = new ListNode(6, elem7);
//        ListNode elem5 = new ListNode(5, elem6);
//        ListNode elem4 = new ListNode(4, elem5);
//        ListNode elem3 = new ListNode(3, elem4);
        ListNode elem3 = new ListNode(3);
        ListNode elem2 = new ListNode(2, elem3);
        ListNode head = new ListNode(1, elem2);

        ListNode[] result = main.splitListToParts(head, 5);
        System.out.println(Arrays.toString(result));
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        if (head == null) return result;
        ListNode current = head;
        int size = 1;
        while (current.next != null) {
            current = current.next;
            size++;
        }
        current = head;
        int partSize = size / k;
        int remain = size % k;
        for (int index = 0; index < k; index++) {
            result[index] = current;
            int currentPartSize = remain > 0 ? partSize + 1 : partSize;
            remain--;
            ListNode prev = current;
            for (int i = 0; i < currentPartSize; i++) {
                prev = current;
                current = current.next;
            }
            if (prev != null) {
                prev.next = null;
            }
        }
        return result;
    }
}

