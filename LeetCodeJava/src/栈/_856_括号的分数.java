package 栈;

import java.util.Stack;

public class _856_括号的分数 {
    public int scoreOfParentheses(String S) {

        Stack<Integer> stack = new Stack<>();
        int len = S.length();
        stack.push(0);
        for (int j = 0; j < len; j++) {
            char c = S.charAt(j);
            if (c == '(') {
                stack.push(0);
            } else {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y + Math.max(2 * x, 1));
            }
        }

        return stack.pop();
    }

    // // 相加计算
    // public int scoreOfParentheses(String S) {

    //     int len = S.length();
    //     int i = 0, result = 0;
    //     for (int j = 0; j < len; j++) {
    //         char c = S.charAt(j);
    //         if (c == '(') {
    //             i++;
    //         } else {
    //             i--;
    //             if ('(' == S.charAt(j - 1)) {
    //                 // result += Math.max(2 * i, 1);
    //                 result += ((i != 0) ? (i << 1) : 1);
    //             }
    //         }
    //     }

    //     return result;
    // }


    public static void main(String[] args) {
        System.out.println(new _856_括号的分数().scoreOfParentheses("()((()))"));;
    }
}