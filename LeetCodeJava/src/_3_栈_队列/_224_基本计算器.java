package _3_栈_队列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _224_基本计算器 {
    public int calculate(String s) {

        List<Character> list = new ArrayList<>();
        list.add('(');
        list.add(')');
        list.add('-');
        list.add('+');
        list.add(' ');
        Stack<Character> s1 = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (!list.contains(c)){
                
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new _224_基本计算器().calculate("1-11"));
    }














    // public int calculate(String s) {
    //     Stack<Character> s1 = new Stack<>();
    //     Stack<Integer> s2 = new Stack<>();

    //     for (Character c : s.toCharArray()) {
    //         switch (c) {
    //             case '(':
    //                 s1.push(c);
    //                 break;
    //             case ')':
    //                 char tmp;
    //                 while ('(' != (tmp = s1.pop())) {
    //                     switch (tmp) {
    //                         case '-':
                                
    //                     s2.push(-s2.pop() + s2.pop());
    //                             break;
    //                             case '+':
                                
    //                     s2.push(s2.pop() + s2.pop());
    //                             break;
    //                         default:
    //                             break;
    //                     }
    //                 }
    //                 break;
    //                 case '+':
    //                 while (!s1.isEmpty() && '(' != s1.peek()) {
    //                     char tmp1 = s1.pop();
    //                     switch (tmp1) {
    //                         case '-':
                                
    //                     s2.push(-s2.pop() + s2.pop());
    //                             break;
    //                             case '+':
                                
    //                     s2.push(s2.pop() + s2.pop());
    //                             break;
    //                         default:
    //                             break;
    //                     }
    //                 }
    //                 s1.push(c);
    //                 break;
    //                 case '-':
    //                 while (!s1.isEmpty() && '(' != s1.peek()) {
    //                     char tmp2 = s1.pop();
    //                     switch (tmp2) {
    //                         case '-':
                                
    //                     s2.push(-s2.pop() + s2.pop());
    //                             break;
    //                             case '+':
                                
    //                     s2.push(s2.pop() + s2.pop());
    //                             break;
    //                         default:
    //                             break;
    //                     }
    //                 }
    //                 s1.push(c);
    //                 break;
    //                 case ' ':
                    
    //                 break;
            
    //             default:
    //                 s2.push(Integer.valueOf(String.valueOf(c)));
    //                 break;
    //         }
    //     }

    //     while (!s1.isEmpty()) {
    //         char tmp2 = s1.pop();
    //         switch (tmp2) {
    //             case '-':
                    
    //         s2.push(-s2.pop() + s2.pop());
    //                 break;
    //                 case '+':
                    
    //         s2.push(s2.pop() + s2.pop());
    //                 break;
    //             default:
    //                 break;
    //         }
    //     }

    //     int result = 0;
    //     int i = 1;
    //     while (!s2.isEmpty()) {
    //         result += s2.pop() * i;
    //         i *= 10;
    //     }

    //     return result;
    // }

}