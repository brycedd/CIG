package interview;

import java.util.*;

/**
 * @author Bryce_dd 2023/12/21 22:12
 */
public class Demo {

//    public static void main(String[] args) {
//        Integer[] number = getNumber(new int[]{1, 2, 3, 7, 9, 4, 3, 10, 12});
//        System.out.println(number.toString());
//    }

    // 找出乱序数组中，左边比它小右边比它大的符合条件的数
    public static Integer[] getNumber(int[] arr) {
        if (null == arr || arr.length <= 2)
            return new Integer[]{};
        int max = -Integer.MAX_VALUE;
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (result.empty() || (result.peek() < arr[i] && max < arr[i])) {
                result.push(arr[i]);
                max = Math.max(arr[i], max);
            } else {
                while (arr[i] < max && arr[i] < result.peek())
                    result.pop();
            }
        }
        return result.toArray(new Integer[0]);
    }

//    public static void main(String[] args) {
//        getMinPopStudent(new int[]{1,2,3,10,3,2,1});
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int count = in.nextInt();
//        int[] arr = new int[count];
//        for (int i = 0; i < count; i++) {
//            arr[i] = in.nextInt();
//        }
//        System.out.println(getMinPopStudent(arr, count));
//    }

    // 合唱团  左边比它小，右边比它大，且是左边递增增大，右边递减减小（有序）
    public static int getMinPopStudent(int[] arr, int arrLen) {
        // 找出左边比当前数字小的数字总和
        int[] dp1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }
        // 找出右边比当前数字小的数字总和

        int[] dp2 = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            // 获取当前最大长度
            int len = dp1[i] + dp2[i] - 1;
            result = Math.max(len, result);
        }

        return arrLen - result;
    }

    public static void main(String[] args) {
        List<Integer> item1 = Arrays.asList(2, 3);
        List<Integer> item2 = Arrays.asList(3, 4);
        List<Integer> item3 = Arrays.asList(4, 5);
        List<Integer> item4 = Arrays.asList(5, 6);
        List<List<Integer>> list = Arrays.asList(item1, item2, item3, item4);
        int maxValue = getMaxValue(list, 8);
        System.out.println(maxValue);
    }

    public static int getMaxValue(List<List<Integer>> list, int cap) {
        int[][] dp = new int[cap + 1][list.size() + 1];
        for (int i = 1; i <= cap; i++) {
            for (int j = 1; j <= list.size(); j++) {
                List<Integer> item = list.get(j - 1);
                Integer c = item.get(0);
                Integer v = item.get(1);
                if (i >= c) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - c][j - 1] + v);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[cap][list.size()];
    }
}
