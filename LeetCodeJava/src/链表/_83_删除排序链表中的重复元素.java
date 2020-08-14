package 链表;

import Common.ListNode;

import java.util.Arrays;

public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        head.next = deleteDuplicates(head.next);

        return head.val == head.next.val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(Arrays.asList(1,1,2,3,3));
        new _83_删除排序链表中的重复元素().deleteDuplicates(head).printListNode();
    }
}