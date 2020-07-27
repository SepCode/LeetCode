package 链表;

public class _86_分隔链表 {
	public ListNode partition(ListNode head, int x) {
//		输入: head = 1->4->3->2->5->2, x = 3
//		输出: 1->2->2->4->3->5
		if (head == null) {
			return null;
		}
		ListNode dummyl = new ListNode(0);
		ListNode taill = dummyl;
		ListNode dummyr = new ListNode(0);
		ListNode tailr = dummyr;
		
		while (head != null) {
			if (head.val >= x) {
				tailr.next = head;
				tailr = head;
			} else {

				taill.next = head;
				taill = head;
			}
			head = head.next;
		}
		tailr.next = null;
		taill.next = dummyr.next;
		
		return dummyl.next;
    }
}
