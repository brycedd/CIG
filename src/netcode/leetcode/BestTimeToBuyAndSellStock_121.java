package netcode.leetcode;

/**
 * @author Bryce_dd 2023/2/15 21:10
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class BestTimeToBuyAndSellStock_121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        // 第i天的最小值只与之前的最小值和当天的值有关
        // dp[i] = min(dp[i-1], prices[i])
        int maxProfit = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 计算当前最小值
            dp[i] = Math.min(dp[i - 1], prices[i]);
            maxProfit = Math.max(prices[i] - dp[i], maxProfit);
        }
        return maxProfit;
    }

    public static int maxProfit1(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int sum = prices[j] - prices[i];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
