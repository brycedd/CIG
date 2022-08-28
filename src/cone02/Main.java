package cone02;

/**
 * @author Bryce_dd 2022/8/28 22:26
 */

import java.util.Stack;

/**
 * 利用两个栈实现队列基本操作（add,poll,peek）
 *
 * 思路：
 *  将压入栈的数据有序的倒入弹出栈，为保证顺序正确，倒入时要保证弹出栈为空
 *  并一次性倒入
 */
public class Main {

    public static void main(String[] args) {
        TowStackQueue towStackQueue = new TowStackQueue(new Stack<>(), new Stack<>());
        for (int i = 0; i < 10; i++) {
            towStackQueue.add(i);
        }
        System.out.println(towStackQueue.poll());
        towStackQueue.add(10);
        while (!towStackQueue.isEmpty()) {
            System.out.println(towStackQueue.poll());
        }

    }
}
