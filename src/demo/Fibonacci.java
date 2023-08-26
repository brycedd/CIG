package demo;

/**
 * @author Bryce_dd 2023/8/1 15:50
 */
public class Fibonacci {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println("f: " + fibonacci(43));
        System.out.println(System.currentTimeMillis() - l);
        long l2 = System.currentTimeMillis();
        System.out.println("dp: " + fibonacciDp(43));
        System.out.println(System.currentTimeMillis() - l2);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int fibonacciDp(Integer n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // dp[n] = dp[n-1] + dp[n-2]
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
