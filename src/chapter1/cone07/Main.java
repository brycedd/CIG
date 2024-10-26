package chapter1.cone07;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 *
 * @author Bryce_dd 2022/9/4 19:51
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int[] maxWindow = getMaxWindow(arr, 3);
        System.out.println(Arrays.toString(maxWindow));
        System.out.println(Arrays.toString(getMaxWindowD(arr, 3)));
        System.out.println(Arrays.toString(getMaxWindow3(arr, 3)));
    }

    // 时间复杂度 O(n * w)
    public static int[] getMaxWindowD(int[] arr, int w) {
        int[] res = new int[arr.length - w + 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < w - 1) continue;
            int max = -Integer.MAX_VALUE;
            for (int k = 0; k < w; k++) {
                max = Math.max(arr[i - k], max);
            }
            res[j++] = max;
        }
        return res;
    }

    /**
     * 时间复杂度 O(n)
     * 首先创建一个双端链表
     * 再遍历整个数组
     * 1'当链表为空时，直接将索引存入链表
     * 2'遍历元素时，比较链表尾索引数据大小，若链表尾更大，将当前索引存入链表尾；
     * 3'当前数据比链表尾大，则弹出链表尾的值，在做比较，直到将当前值存入链表为止
     * 4'每次循环时，做完上述操作，判断表头的index是否已经不在当前窗口范围内，若不在则弹出；最后取出队首元素，此为当前窗口最大
     */
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        // 创建窗口与数量相同的结果数组
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                // 若队尾索引值 小于等于当前值，则取出
                qmax.pollLast();
            }
            // 若qmax为空，直接存入index， 若当前值小于qmax存储值， 也将其存入队尾
            qmax.addLast(i);
            if (qmax.peekFirst() == (i - w)) {
                // 若当前队首index已不属于当前窗口，弹出
                qmax.pollFirst();
            }
            if (i >= (w - 1)) {
                // 当出现第一个窗口，开始存储每个窗口最大值
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }


    public static int[] getMaxWindow3(int[] arr, int w) {
        LinkedList<Integer> maxQueue = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        for (int i = 0; i < arr.length; i++) {
            if (maxQueue.size() == 0 || arr[maxQueue.peekLast()] > arr[i]) {
                maxQueue.add(i);
            } else {
                while (maxQueue.size() > 0 && arr[maxQueue.peekLast()] <= arr[i]) {
                    maxQueue.pollLast();
                }
                maxQueue.add(i);
            }
            if (i >= w - 1) {
                while (maxQueue.peekFirst() < i - w + 1) {
                    maxQueue.pollFirst();
                }
                res[i - w + 1] = arr[maxQueue.peekFirst()];
            }
        }
        return res;
    }


}
