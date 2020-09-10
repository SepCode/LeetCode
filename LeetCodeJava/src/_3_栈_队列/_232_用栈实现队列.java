package _3_栈_队列;

import java.util.LinkedList;
// 面试题_03_04_化栈为队
public class _232_用栈实现队列 {
	LinkedList<Integer> stack1;
	LinkedList<Integer> stack2;
	/** Initialize your data structure here. */
    public _232_用栈实现队列() {
    	stack1 = new LinkedList<>();
    	stack2 = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	
    	stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	
    	if (!stack2.isEmpty()) {
    		return stack2.pop();
		} else {
			if (stack1.isEmpty()) {
				return -1;
			} else {
				while (!stack1.isEmpty()) {
	    			stack2.push(stack1.pop());				
				}
			}
		}
    	return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	if (!stack2.isEmpty()) {
    		return stack2.peek();
		} else {
			if (stack1.isEmpty()) {
				return -1;
			} else {
				while (!stack1.isEmpty()) {
	    			stack2.push(stack1.pop());				
				}
			}
		}
    	return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return stack1.isEmpty() && stack2.isEmpty();
    }
}
