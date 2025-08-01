package SlidingWindowStuff;

import java.util.*;



public class LongestSubstring {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
// Url :  https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
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
// Url : https://leetcode.com/problems/max-consecutive-ones-iii/description/

    public int longestOnes(int[] arr, int k) {
        int r = 0;
        int l = 0;
        int zeros = 0;
        int maxL = 0;
        while (r < arr.length){
            if (arr[r] == 0){
                zeros++;
            }
            if (zeros > k ){
                if (arr[l] == 0) zeros--;
                l++;
            }
            if (zeros <= k ){
                currL = r - l + 1;
                maxL = Math.max(maxL,currL);
            }
            r++;
        }
        return maxL;
    }

// Url : https://leetcode.com/problems/fruit-into-baskets/description/
    public int totalFruit(int[] fruits) {
        int r = 0,l = 0,maxL = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while (r < fruits.length){
            map.put(fruits[r],map.getOrDefault(fruits[r],0) + 1);
            if (map.size() > 2){
                map.put(fruits[l],map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if (map.size() <= 2){
                maxL = Math.max(maxL,r - l + 1);
            }
            r++;
        }
        return maxL;
    }
// Url : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen,-1);
        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            int min = Math.min(lastSeen[0],lastSeen[1]);
            int fin = Math.min(min,lastSeen[2]);

            count += 1 + fin;
        }
        return count;
    }

// Url : https://leetcode.com/problems/longest-repeating-character-replacement/description/

    public int characterReplacement(String s, int k) {
        int r=0,l=0,maxL=0;
        int[] freq = new int[26];
        int maxFreq = 0;
        while (r < s.length()){
            char ch = s.charAt(r);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            if (r - l + 1 - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxL = Math.max(maxL,r - l + 1);
            r++;
        }
        return maxL;
    }

// Url : https://leetcode.com/problems/binary-subarrays-with-sum/description/
    public int numSubarraysWithSum(int[] arr, int goal) {
        int ans = lessthanGoal(arr,goal);
        int val = lessthanGoal(arr,goal - 1);
        return ans - val;
    }
    private int lessthanGoal(int[] arr, int goal){
        if (goal < 0){
            return 0;
        }
        int count = 0;
        int r = 0;
        int l = 0;
        int sum = 0;
        while (r < arr.length){
            sum += arr[r];
            while (sum > goal){
                sum -= arr[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

}
