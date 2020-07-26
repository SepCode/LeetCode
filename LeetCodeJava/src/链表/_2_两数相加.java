package 链表;

public class _2_两数相加 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//		输出：7 -> 0 -> 8
//		原因：342 + 465 = 807
		
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int carry = 0;
		
		while (l1 != null || l2 != null) {
			int v1 = 0;
			if (l1 != null) {
				v1 = l1.val;
				l1 = l1.next;
			}
			int v2 = 0;
			if (l2 != null) {
				v2 = l2.val;
				l2 = l2.next;
			}
			int result = v1 + v2 + carry;
			carry = result / 10;
			tail.next = new ListNode(result % 10);
			tail = tail.next;
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}

		return dummy.next;
    }
}
