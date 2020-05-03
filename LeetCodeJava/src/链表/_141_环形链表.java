package 链表;

public class _141_环形链表 {

    public static void main(final String[] args) {
        final ListNode head = new ListNode(4);
        final ListNode next1 = new ListNode(1);
        final ListNode next2 = new ListNode(5);
        final ListNode next3 = new ListNode(9);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next1;
        
        final _141_环形链表 cyc = new _141_环形链表();
        System.out.println(cyc.hasCycle(head));
    }

    public boolean hasCycle(final ListNode head) {
        // if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}