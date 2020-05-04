package 链表;
import java.util.Arrays;

public class _237_删除链表中的节点 {
    
    public void deleteNode(final ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
    
    
    public static void main(final String[] args) {
        
        final ListNode head = new ListNode(Arrays.asList(4,1,5,9));
        new _237_删除链表中的节点().deleteNode(head.next);
        head.printListNode();
    }
}