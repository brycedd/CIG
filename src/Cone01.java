/**
 * @author Bryce_dd 2022/8/28 21:45
 */

import java.util.Stack;

/**
 * 实现一个特殊栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 */
public class Cone01 {

    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1(Stack<Integer> stackData, Stack<Integer> stackMin) {
            this.stackData = stackData;
            this.stackMin = stackMin;
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getMin()) {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;
        }

        private int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            return this.stackMin.peek();
        }
    }
}
