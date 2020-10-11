package _2_链表;

//import Common.ListNode;

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


	public static void main(String[] args) {
		ListNode n3 = new ListNode(1);
		ListNode n2 = new ListNode(2, n3);
		ListNode n1 = new ListNode(3, n2);

		ListNode n4 = new _86_分隔链表().partition(n1, 2);
		System.out.println(n4);
	}


}

class ListNode {
	ListNode next;
	int val;

	ListNode(int val){
		this.val = val;
		this.next = null;
	}

	ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;
	}
}