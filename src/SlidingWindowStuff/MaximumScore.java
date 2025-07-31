package SlidingWindowStuff;

public class MaximumScore {
// Url : https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = k -1; i >= 0; i--) {
            leftSum += cardPoints[i];
        }
        int maxSum = leftSum;
        int i = k - 1;
        int r = cardPoints.length - 1;
        while (k-- > 0){
            leftSum -= cardPoints[i--];
            rightSum += cardPoints[r--];
            maxSum = Math.max(maxSum,rightSum + leftSum);
        }
        return maxSum;
    }
}
