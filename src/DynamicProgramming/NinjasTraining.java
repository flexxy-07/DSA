package DynamicProgramming;
import java.util.*;
public class NinjasTraining {

    public void NinjaTraining(int n, int[][] points){
        int[][] dp = new int[n][4];
        Arrays.fill(dp, -1);
//        return getMaxPoints(3,3,)

    }

    private int getMaxPoints(int day, int last, int[][] points, int[][] dp){
        if (day == 0){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != last){
                    max = Math.max(max, points[0][i]);
                }
            }
        }
        if (dp[day][last] != -1) return dp[day][last];
        int max = -1;
        for (int i = 0; i < 3; i++) {
            if (i != last){
                int point = points[day][i] + getMaxPoints(day - 1, i, points,dp);
                max = Math.max(max, point);
            }
        }
        return dp[day][last] = max;
    }

    private int tabulation(int n, int[][] points){
        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][1], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last){
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }

}
