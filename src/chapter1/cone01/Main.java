package chapter1.cone01;

import java.util.Stack;

/**
 * @author Bryce_dd 2022/8/28 21:45
 * <p>
 * 实现一个特殊栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 */
public class Main {
    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1(new Stack<>(), new Stack<>());
        myStack1.push(8);
        myStack1.push(7);
        myStack1.push(1);
        myStack1.push(9);
        myStack1.push(0);
        myStack1.push(10);
        myStack1.push(6);
        for (int i = 0; i <= 6; i++) {
            System.out.println("==============================");
            System.out.println("第 " + (i + 1) + "次 pop");
            System.out.println("min:" + myStack1.getMin());
            System.out.println("pop:" + myStack1.pop());
            System.out.println("==============================");
        }

    }
}
