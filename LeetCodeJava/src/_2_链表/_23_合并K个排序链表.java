package _2_链表;

import Common.ListNode;

public class _23_合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
//    	输入:
//    		[
//    		  1->4->5,
//    		  1->3->4,
//    		  2->6
//    		]
//		输出: 1->1->2->3->4->4->5->6
    	
    	if (lists == null || lists.length == 0) return null;
    	if (lists.length == 1) return lists[0];
    	
    	return merge(lists, 0, lists.length - 1);
    	
    }
    
    private ListNode merge(ListNode[] lists, int l, int r) {
		if (l == r) return lists[l];
		int mid = (l + r) >> 1;
		
		return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
		
	}
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		while (l1 != null && l2 != null) {
			
			if (l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		tail.next = l1 == null ? l2 : l1;
		
		return dummy.next;
	}
}
