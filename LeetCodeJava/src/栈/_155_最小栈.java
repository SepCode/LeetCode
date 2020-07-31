package 栈;

public class _155_最小栈 {

	Node head;
	// 头插链表
	/** initialize your data structure here. */
    public _155_最小栈() {
    	head = new Node(0, Integer.MAX_VALUE, null);
    }
    
    public void push(int x) {
    	head = new Node(x, Math.min(x, head.min), head);
    }
    
    public void pop() {
    	head = head.next;
    }
    
    public int top() {
    	return head.val;
    }
    
    public int getMin() {
    	return head.min;
    }
	
	private class Node {
		public Node(int val, int min, Node next) {
			super();
			this.val = val;
			this.min = min;
			this.next = next;
		}
		public int val;
		public int min;
		public Node next;
		
	}
	
	
	// 辅助栈
//	Stack<Integer> vStack;
//	Stack<Integer> mStack;
//	
//    /** initialize your data structure here. */
//    public MinStack() {
//    	vStack = new Stack<>();
//    	mStack = new Stack<>();
//    	
//    }
//    
//    public void push(int x) {
//    	vStack.push(x);
//    	if (mStack.isEmpty()) {
//			mStack.push(x);
//		} else if (x < mStack.peek()) {
//			mStack.push(x);
//		} else {
//			mStack.push(mStack.peek());
//		}
//    }
//    
//    public void pop() {
//    	vStack.pop();
//    	mStack.pop();
//    }
//    
//    public int top() {
//    	return vStack.peek();
//    }
//    
//    public int getMin() {
//    	return mStack.peek();
//    }
}
