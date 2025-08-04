package Greedy;
import java.util.*;
public class JumpGame1 {

// Url : https://leetcode.com/problems/jump-game/description/
    public boolean canJump(int[] arr) {
        int maxL = 0;
        for(int i = 0; i < arr.length; i++){
            if(i > maxL) return false;

            maxL = Math.max(maxL, i + arr[i]);
        }
        return true;
    }

}
