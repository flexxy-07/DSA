package BitwiseQuestions;

import java.util.HashSet;
import java.util.Map;

public class Questions {
    public static void main(String[] args) {

    }

// Url : https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/?envType=daily-question&envId=2025-07-30

// Notes : Bitwise AND is shrinking process.
//         If we have two numbers, A and B , and A > B, the bitwise AND of both the numbers will be
//         less that A .
//         And Bitwise and of A and A will be A itself;
//
 //

    // Approach : We will find the max Value in the arr and longest subarray of that number only
    public int longestSubarray(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        for (int val : arr){
            if (val > maxVal){
                maxVal = val;
            }
        }
        int maxLength = 0;
        int curr = 0;
        for (int val : arr){
            if (val == maxVal){
                curr++;
                maxLength = Math.max(curr,maxLength);
            }else{
                curr = 0;
            }
        }
        return maxLength;
    }
// Url : https://leetcode.com/problems/bitwise-ors-of-subarrays/?envType=daily-question&envId=2025-07-31

    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();

        for (int val : arr){
            HashSet<Integer> current = new HashSet<>();
            current.add(val);

            for (int num : prev){
                current.add(val | num);
            }
            ans.addAll(current);
            prev = current;
        }
        return ans.size();
    }
}

