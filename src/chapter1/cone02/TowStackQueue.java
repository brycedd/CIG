package chapter1.cone02;

import java.util.Stack;

/**
 * @author Bryce_dd 2022/8/28 22:27
 */
public class TowStackQueue {
    public Stack<Integer> stackPop;
    public Stack<Integer> stackPush;

    public TowStackQueue(Stack<Integer> stackPop, Stack<Integer> stackPush) {
        this.stackPop = stackPop;
        this.stackPush = stackPush;
    }

    // push栈将数据倒入pop栈
    private void pushToPop() {
        // 若弹出栈为空，将压入栈数据全部倒入弹出栈
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int newNum) {
        // 新数据压入栈
        stackPush.push(newNum);
        // 尝试将数据倒入弹出栈
        pushToPop();
    }

    public int poll() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }

    public boolean isEmpty() {
        return (stackPop.empty() && stackPush.empty());
    }
}
