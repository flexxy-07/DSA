package Hashing;
import java.util.*;
public class LongestConsecutive {
// Url : https://leetcode.com/problems/longest-consecutive-sequence/

    public int longestConsecutive(int[] arr) {
        if(arr.length == 0){
            return 0;
        }
        int maxLength = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int val : arr){
            set.add(val);
        }
        for(int val : set){
            if(!set.contains(val-1)){
                int currLength = 1;
                int currentNum = val;

                while(set.contains(currentNum + 1)){
                    currLength++;
                    currentNum++;
                }
                maxLength = Math.max(maxLength, currLength);

            }
        }
        return maxLength;
    }
}
