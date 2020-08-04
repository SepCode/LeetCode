package 栈;

import java.util.LinkedList;

public class _剑指_Offer_09_用两个栈实现队列 {
	LinkedList<Integer> stack1;
	LinkedList<Integer> stack2;
	public _剑指_Offer_09_用两个栈实现队列() {
		stack1 = new LinkedList<>();
    	stack2 = new LinkedList<>();
    }
    
    public void appendTail(int value) {
    	stack1.push(value);
    }
    
    public int deleteHead() {
    	
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
}
