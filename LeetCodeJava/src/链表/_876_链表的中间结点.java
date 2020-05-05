package 链表;

import java.util.Arrays;

public class _876_链表的中间结点 {
    
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(Arrays.asList(1,2,3,4,5,6,7));
        new _876_链表的中间结点().middleNode(head).printListNode();
    }
}