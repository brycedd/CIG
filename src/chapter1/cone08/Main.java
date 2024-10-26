package chapter1.cone08;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Bryce_dd 2022/9/19 22:48
 * 单调结构栈
 * 给定一个不含重复值的数组arr，找到每个i位置左边和右边离i位置最近且值比arr[i]小的位置，返回所有位置相应信息
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        int[][] nearLessNoRepeat = getNearLessNoRepeat(arr);
        for (int[] ints : nearLessNoRepeat) {
            System.out.println("【" + ints[0] + ":" + ints[1] + "】");
        }
        System.out.println("=====================================");

        int[] arr2 = {3, 1, 3, 4, 3, 5, 3, 2, 2};
        int[][] nearLessRepeat = getNearLessRepeat(arr2);
        for (int[] ints : nearLessRepeat) {
            System.out.println("【" + ints[0] + ":" + ints[1] + "】");
        }
    }

    /**
     * 时间复杂度O(n) (每个元素进出栈一次)
     * 解题思路：
     * 构建一个栈，由于数组没有重复元素，循环数组，将数组中的元素的index压入栈中，
     * 题目为位置最近且小于目标元素，所以栈按照栈底到栈定依次从大到小去压栈
     * 当栈为空时，将值压入栈，当当前元素大于栈顶元素index值时，直接压入栈
     * 当当前值小于栈顶index值时，则当前循环到的位置，栈顶弹出，弹出后的栈栈顶index为左边靠近弹出值index
     * 的index，当前循环到的i为右边最近且小于当前弹出值的index
     */
    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] result = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && arr[stack.peek()] > arr[i]) {
                Integer pop = stack.pop();
                result[pop][0] = stack.empty() ? -1 : stack.peek();
                result[pop][1] = i;
            }
            stack.push(i);
        }
        // 将未弹出值处理掉
        while (!stack.empty()) {
            Integer pop = stack.pop();
            result[pop][0] = stack.empty() ? -1 : stack.peek();
            result[pop][1] = -1;
        }
        return result;
    }

    /**
     * 若数组为有重复值的情况
     */
    public static int[][] getNearLessRepeat(int[] arr) {
        int[][] result = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && arr[stack.peek().get(0)] > arr[i]) {
                // 当前栈不为空，并且当前栈顶index的值大于当前数组index的值
                List<Integer> pop = stack.pop();
                // 获取最近一次压入栈的index值
                int left = stack.empty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                // 当前弹出也可能是重复的多个index
                for (Integer data : pop) {
                    result[data][0] = left;
                    result[data][1] = i;
                }
            }
            if (!stack.empty() && arr[stack.peek().get(0)] == arr[i]) {
                // 值相等，将值一起压入
                stack.peek().add(i);
            } else {
                // 当前栈已空
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        // 清空栈
        while (!stack.empty()) {
            List<Integer> list = stack.pop();
            int left = stack.empty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer data : list) {
                result[data][0] = left;
                result[data][1] = -1;
            }
        }
        return result;
    }
}
