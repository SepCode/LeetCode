package 链表;

public class _234_回文链表 {
	public boolean isPalindrome(ListNode head) {
//		输入: 1->2->3->2->1->null
//		输出: true
		if (head == null || head.next == null) {
			return true;
		}
		if (head.next.next == null) {
			return head.val == head.next.val;
		}
		// 中间节点
		ListNode midListNode = getMidListNode(head);
		// 反转链表
		ListNode taiListNode = reverseList(midListNode.next);
		// 首尾遍历对比
		while (taiListNode != null) {
			if (head.val != taiListNode.val) {
				return false;
			}
			head = head.next;
			taiListNode = taiListNode.next;
		}
		return true;
    }
	
	private ListNode getMidListNode(ListNode headListNode) {
		ListNode fastListNode = headListNode;
		ListNode slowListNode = headListNode;
		
		while (fastListNode != null && fastListNode.next != null && fastListNode.next.next != null) {
			fastListNode = fastListNode.next.next;
			slowListNode = slowListNode.next;
		}
		
		return slowListNode;
	}
	
	private ListNode reverseList(ListNode heaListNode) {
		ListNode taiListNode = null;
		while (heaListNode != null) {
			ListNode nextListNode = heaListNode.next;
			heaListNode.next = taiListNode;
			taiListNode = heaListNode;
			heaListNode = nextListNode;
		}
		return taiListNode;
	}
	
}
