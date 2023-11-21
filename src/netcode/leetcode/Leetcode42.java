package netcode.leetcode;

import java.util.Stack;

/**
 * @author Bryce_dd 2023/11/21 22:32
 * 接雨水
 */
public class Leetcode42 {

    public static void main(String[] args) {

    }

    public static int test(int[] arr) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < arr.length) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[index]) {
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                Integer peek = stack.peek();
                // 计算距离
                int dis = index - peek - 1;
                // 计算高度
                int hight = Math.min(arr[peek], arr[index]);
                // 计算面积
                sum += dis * (hight - arr[pop]);
            }
            stack.push(index);
            index++;
        }
        return sum;
    }
}
