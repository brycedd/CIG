package chapterone.cone05;

import java.util.Stack;

/**
 * @author Bryce_dd 2022/8/29 23:26
 * <p>
 * 对一个整型栈进行排序，使其从栈顶到栈底为从大到小排序； 只能再额外申请一个栈，可以申请额外
 * 的变量，但不能申请额外的数据结构
 */
public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(5);
        stack.push(8);
        stack.push(3);
        stack.push(10);
        stack.push(0);
        System.out.println(stack);
        sortStackByStack(stack);
        System.out.println(stack);
    }

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            Integer pop = stack.pop();
            while (!help.empty() && pop > help.peek()) {
                stack.push(help.pop());
            }
            help.push(pop);
        }
        while (!help.empty()) {
            stack.push(help.pop());
        }
    }

    public static void sortStackByStackD(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            Integer pop = stack.pop();
            if (help.empty()) {
                help.push(pop);
            } else {
                if (pop <= help.peek()) {
                    help.push(pop);
                } else {
                    do {
                        stack.push(help.pop());
                    } while (!help.empty() && pop > help.peek());
                    help.push(pop);
                }
            }
        }
        // 将排好续的元素压回原栈
        while (!help.empty()) {
            stack.push(help.pop());
        }
    }
}
