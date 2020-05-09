package 栈;

import java.util.HashMap;
import java.util.Stack;

public class _20_有效的括号 {

    static HashMap<Character,Character> map = new HashMap<>();
    static {
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
    }
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new _20_有效的括号().isValid("(({}))"));;
    }
}