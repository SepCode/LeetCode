package _2_链表;

import Common.ListNode;

public class _203_移除链表元素 {
	public ListNode removeElements(ListNode head, int val) {

   // tail->1
//		输入: 1->2->6->3->4->5->6, val = 6
//		输出: 1->2->3->4->5
		
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		while (head != null) {
			if (head.val != val) {
				tail.next = head;
				tail = head;
			}
			head = head.next;
		}
		tail.next = null;
		
		return dummy.next;
    }
}





// 初始版本
//    // 遍历
//    // public ListNode removeElements(ListNode head, int val) {
//        
//    //     ListNode result = null;
//    //     ListNode last = head;
//
//    //     while (head != null){
//    //         if (head.val == val) {
//    //             head = head.next;
//    //             last.next = head;
//                
//    //         } else {
//    //             if (result == null) result = head;
//    //             last = head;
//    //             head = head.next;
//    //         }
//    //     }
//
//    //     return result;
//    // }
//
//    // 递归
//    public ListNode removeElements(ListNode head, int val) {
//        
//        if (head == null) {
//            return head;
//        }
//
//        head.next = removeElements(head.next, val);
//        return head.val == val ? head.next : head;
//    }
//
//    public static void main(String[] args) {
//        ListNode head = new ListNode(Arrays.asList(1,2,3,6,4,5,6));
//        new _203_移除链表元素().removeElements(head, 6).printListNode();
//    }