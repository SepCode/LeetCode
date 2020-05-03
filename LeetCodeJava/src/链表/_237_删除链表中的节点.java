package 链表;

public class _237_删除链表中的节点 {
    
    
    public static void main(final String[] args) {
        final ListNode head = new ListNode(4);
        final ListNode next1 = new ListNode(1);
        final ListNode next2 = new ListNode(5);
        final ListNode next3 = new ListNode(9);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
    }


    public void deleteNode(final ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}