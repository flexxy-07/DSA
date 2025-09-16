package DynamicProgramming;
import java.util.*;
public class Fibo {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        System.out.println(f(5,dp));
    }

    // Memoization
    private static int f(int n, int[] dp){
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        dp[n] = f(n - 1, dp) + f(n - 2, dp);
        return dp[n];
    }
}
