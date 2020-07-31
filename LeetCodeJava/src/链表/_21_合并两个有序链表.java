package 链表;

public class _21_合并两个有序链表 {
	
	
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (l1 != null && l2 != null) {			
			if (l1.val <= l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
        tail.next = (l1 == null) ? l2 : l1; 
        
        return dummy.next;
    }
	
	
	
	
	
	
	
	
	
	// 被数组搞混了
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        
//        while (l1 != null || l2 != null) {
//			if (l1 == null) {
//				tail.next = l2;
//				tail = tail.next;
//				l2 = l2.next;
//				continue;
//			}
//			
//			if (l2 == null) {
//				tail.next = l1;
//				tail = tail.next;
//				l1 = l1.next;
//				continue;
//			}
//			
//			if (l1.val <= l2.val) {
//				tail.next = l1;
//				l1 = l1.next;
//			} else {
//				tail.next = l2;
//				l2 = l2.next;
//			}
//
//			tail = tail.next;
//		}
//        tail.next = null;
//        
//        return dummy.next;
//    }
}
