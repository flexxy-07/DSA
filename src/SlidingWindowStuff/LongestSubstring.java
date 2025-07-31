package SlidingWindowStuff;

import java.util.*;



public class LongestSubstring {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
// Url :  https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        int l = 0;
        int r = 0;
        HashSet<Character> set = new HashSet<>();
        int maxLen = 1;
        while (r < s.length()){
            while (set.contains(s.charAt(r))){
               set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            maxLen = Math.max(maxLen,r - l);
        }
        return maxLen;
}
}
