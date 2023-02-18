package netcode.leetcode;

/**
 * @author Bryce_dd 2023/2/15 22:25
 */
public class BestTimeToBuyAndSellStock2_122 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit3(prices));
        System.out.println(maxProfit4(prices));
    }

    /**
     * dp[i][0] 表示第i天手里没有股票时的最大收益，那么和前一天的关系为：
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * 则：
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     * <p>
     * 则初始状态为：dp[0][0] = 0,dp[0][1] = -prices[i]
     */
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 每天的收益只与前一天的收益有关，去掉之前的
     */
    public static int maxProfit3(int[] prices) {
        // 当前持有股票的最大收益
        int dp0 = 0;
        // 当前不持有股票的最大收益
        int dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp0 - prices[i], dp1);
        }
        return dp0;
    }

    /**
     * 贪心
     */
    public static int maxProfit4(int[] prices) {
        int prePrice = prices[0];
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prePrice) {
                totalProfit += prices[i] - prePrice;
            }
            prePrice = prices[i];
        }
        return totalProfit;
    }
}
