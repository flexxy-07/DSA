package DynamicProgramming;
import java.util.*;

// Url : https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 45;
        int[] steps = new int[n + 1];
        Arrays.fill(steps,-1);
        System.out.println(CalorieReducer(n,steps));
    }
    private static int CalorieReducer(int n, int[] steps){
        if (n <= 1) return 1;

        if (steps[n] != -1) return steps[n];

        int oneSteps = CalorieReducer(n - 1, steps);
        int twoSteps = CalorieReducer(n - 2, steps);

        steps[n] = oneSteps + twoSteps;
        return steps[n];
    }


}
