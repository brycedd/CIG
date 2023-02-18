package netcode.leetcode;

/**
 * @author Bryce_dd 2023/2/18 19:02
 * <p>
 * 只能购买卖两次，并不能同时持有多笔交易
 */
public class BestTimeToBuyAndSellStock3_123 {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }

    public static int maxProfit(int[] prices) {
        int fb = Integer.MIN_VALUE;
        int fs = 0;
        int sb = Integer.MIN_VALUE;
        int ss = 0;
        for (int i = 0; i < prices.length; i++) {
            fb = Math.max(fb, -prices[i]);
            fs = Math.max(fs, fb + prices[i]);
            sb = Math.max(sb, fs - prices[i]);
            ss = Math.max(ss, sb + prices[i]);
        }
        return ss;
    }

    public static int maxProfit2(int[] prices) {
        int[][][] dp = new int[prices.length + 1][3][3];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1][1] = Math.max(dp[i - 1][1][1], - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
        }
        return dp[prices.length - 1][2][0];
    }
}
