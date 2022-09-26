package netcode;

import java.util.Arrays;

/**
 * @author Bryce_dd 2022/9/25 17:28
 * 最长递增子序列
 */

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 3, 7, 1, 2, 3};
        int aLong = getLong(arr);
    }

    public static int getLong(int[] arr) {
        int res = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
