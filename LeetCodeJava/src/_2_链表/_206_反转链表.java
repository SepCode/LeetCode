package _2_链表;

import Common.ListNode;

import java.util.Arrays;

public class _206_反转链表 {
    // 递归
     public ListNode reverseList1(ListNode head) {
         if (head == null || head.next == null) {
             return head;
         }

         ListNode next = head.next;
         next.next = head;

         ListNode newHead = reverseList1(next);
         head.next = null;
         return newHead;

     }
	
	// 1->2->3->4->null
	// 4->3->2->1->null

    // 遍历
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
        return newHead;

    }

    public static void main(final String[] args) {
        
        ListNode head = new ListNode(Arrays.asList(4,1,5,9));

        ListNode head1 = head;
        while (head1 != null) {
            System.out.println(head1.val);
            head1 = head1.next;
        }

        _206_反转链表 foo = new _206_反转链表();
        
       
        ListNode head2 = foo.reverseList(head);


        System.out.println("\n");

        while (head2 != null) {
            System.out.println(head2.val);
            head2 = head2.next;
        }

    }



}