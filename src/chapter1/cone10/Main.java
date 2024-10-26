package chapter1.cone10;

import java.util.LinkedList;

/**
 * @author Bryce_dd 2022/11/16 22:39
 * 给定数组arr和整数num，共返回有多少个子数组满足如下情况：
 * max(arr[i...j]) - min(arr[i...j]) <= num
 * max(arr[i...j])表示子数组arr[i...j]中的最大值，min(arr[i...j])表示子数组arr[i...j]中的最小值
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 4, 3, 2};
        int num = getNum(arr, 3);
        System.out.println(num);

    }

    /**
     * 解题思路：
     * 1、使用两个双端队列，qMax，qMin来维护arr[i...j] 的最大和最小值
     * 保证每次需要计算差值的时间复杂度都为O(1),维护的时间复杂度也为O(1)
     * 2、本题还有一下两个隐性条件：
     * 2.1:若arr[i...j]满足条件，那么arr[i...j]的所有子数组都满足条件
     * 反正，若，arr[i...j]满足，那么arr[i...j-1] 被去掉的值，可能是最大值，最小值，或非最大最小值，
     * 其都不会影响最大最小差值 <= num
     * 2.2:若arr[i...j]不满足条件，那么所有包含arr[i...j]的子数组都不满足条件
     */
    public static int getNum(int[] arr, int num) {
        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                // 当i做了++之后，跳过第一次的循环，第一次循环最大最小数组的最后一位一定是j
                if (qMin.size() == 0 || qMin.peekLast() != j) {
                    // 维护最大值
                    while (qMax.size() > 0 && arr[qMax.peekLast()] <= arr[j]) {
                        qMax.pollLast();
                    }
                    qMax.add(j);
                    // 维护最小值
                    while (qMin.size() > 0 && arr[qMin.peekLast()] >= arr[j]) {
                        qMin.pollLast();
                    }
                    qMin.add(j);
                }
                // 判断是否已经不满足条件，若不满足条件，当前循环
                if (arr[qMax.peekFirst()] - arr[qMin.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            // 本次窗口执行完后，计算子数组数量
            res += j - i;
            if (qMax.peekFirst() == i) {
                qMax.pollFirst();
            }
            if (qMin.peekFirst() == i) {
                qMin.pollFirst();
            }
            i++;
        }
        return res;
    }
}
