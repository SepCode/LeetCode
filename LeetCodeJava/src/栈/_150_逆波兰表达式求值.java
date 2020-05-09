package 链表;

import java.util.Stack;

public class _150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String key : tokens) {
            switch (key) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y / x);
                    break;
            
                default:
                    stack.push(Integer.valueOf(key));
                    break;
            }
            
        }

        return stack.pop();
    }
    

    public static void main(String[] args) {
        System.out.println(new _150_逆波兰表达式求值().evalRPN(new String[]{"2","1","+","3","*"}));
    }
}