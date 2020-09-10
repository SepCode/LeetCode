package _4_字符串;

import java.util.LinkedList;

public class _32_最长有效括号 {

    public int longestValidParentheses(String s) {
//        输入: ")()())"
        //       ⬆️
//        输出: 4
//        解释: 最长有效括号子串为 "()()"

        if (s == null || s.length() == 0) return 0;

        char[] cs = s.toCharArray();
        int[] dp = new int[cs.length];

        int max = 0;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == ')') {
                if (cs[i - 1] == '(') {
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (i - (dp[i - 1]) - 1 >= 0 && cs[i - (dp[i - 1]) - 1] == '('){ // (dp[i - 1]) 中间匹配的括号
                    if (i - (dp[i - 1]) - 2 >= 0) {
                        dp[i] = dp[i - (dp[i - 1]) - 2] + 2 + (dp[i - 1]);
                    } else {
                        dp[i] = 2 + (dp[i - 1]);
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public int longestValidParentheses1(String s) {
//        输入: ")()())"
        //       ⬆️
//        输出: 4
//        解释: 最长有效括号子串为 "()()"

        if (s == null || s.length() == 0) return 0;

        LinkedList<Integer> stack = new LinkedList<>();
        char[] cs = s.toCharArray();
        int max = 0;
        for (int i = 0; i < cs.length; i++) {

            char c = cs[i];

            // （
            if (c == '(' || stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            //  ）
            if (cs[stack.peek()] == '(') {

                stack.pop();
                max = Math.max(max, i - (stack.isEmpty() ? -1 : stack.peek()));
            } else {
                stack.push(i);
            }


        }
        return max;
    }

    public int longestValidParentheses2(String s) {
//        输入: ")()())"
        //       ⬆️
//        输出: 4
//        解释: 最长有效括号子串为 "()()"

        if (s == null || s.length() == 0) return 0;

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        char[] cs = s.toCharArray();
        int max = 0;
        for (int i = 0; i < cs.length; i++) {

            char c = cs[i];
            // （
            if (c == '(') {
                stack.push(i);
            } else { // )
                stack.pop();
                if (stack.isEmpty()) { // 第一个位置是）括号
                    stack.push(i);
                }
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }
}
