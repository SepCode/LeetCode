package 链表;

public class _160_相交链表 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
		// null 1->2->3
		// 	 1->2->3 null
		ListNode curA = headA;
		ListNode curB = headB;
		
		while (curA != curB) {
			
			curA = curA == null ? headB : curA.next;
			curB = curB == null ? headA : curB.next;
		}
		
		return curA;
    }
	
	public static void main(String[] args) {
		new _160_相交链表().getIntersectionNode(null, new ListNode(1));
	}
}
