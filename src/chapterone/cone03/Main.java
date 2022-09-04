package chapterone.cone03;

import java.util.Stack;

/**
 * @author Bryce_dd 2022/8/28 22:53
 * <p>
 * 利用递归逆序一个栈
 * <p>
 * 本题条件是 逆序的整个过程中，只能有一个栈，不能新创建一个栈
 * 我们利用方法栈的局部变量，将栈中的数据保存起来，再装回去；
 */
public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        Revert.revertStack(stack);
        System.out.println(stack);
    }
}
