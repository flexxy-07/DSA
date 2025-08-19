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
                maxL = Math.max(maxL,r - l + 1);
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
// Url : https://leetcode.com/problems/count-number-of-nice-subarrays/description/

    public int numberOfSubarrays(int[] arr, int k) {
        int equalSum = getSum(arr,k);
        int oneLess = getSum(arr,k - 1 );

        return equalSum - oneLess;
    }
    private int getSum(int[] arr, int k){
        if (k < 0){
            return 0;
        }
        int r = 0, l = 0, sum = 0;
        int count = 0;

        while (r < arr.length){
            sum += arr[r] % 2;
            while (sum > k){
                sum -= arr[l] % 2;
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

// url : https://leetcode.com/problems/subarrays-with-k-different-integers/description/

    public int subarraysWithKDistinct(int[] arr, int k) {
        int lessThanEqual = getCount(arr,k);
        int lessThanEqualOne = getCount(arr,k - 1);

        return lessThanEqual - lessThanEqualOne;
    }
    private int getCount(int[] arr, int k){
        int r = 0, l = 0, count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while (r < arr.length){
          map.put(arr[r],map.getOrDefault(arr[r],0) + 1);

          while (map.size() > k){
              map.put(arr[l],map.get(arr[l]) - 1);
              if (map.get(arr[l]) == 0){
                  map.remove(arr[l]);
              }
              l++;
          }
          count += r - l + 1;
          r++;
        }
        return count;
    }
// Url : https://leetcode.com/problems/minimum-window-substring/description/

//    public String minWindow(String s, String t) {
//       int r = 0, l = 0, count = 0;
//       int startIndex = -1;
//       int minLength = Integer.MAX_VALUE;
//       HashMap<Character,Integer> map = new HashMap<>();
//       for (char ch : t.toCharArray()){
//           map.put(ch,map.getOrDefault(ch , 0) + 1);
//       }
//       while (r < s.length()){
//           if (map.get(s.charAt(r)) > 0){
//               count ++;
//               map.put(s.charAt(r),map.get(s.charAt(r)) - 1);
//           }
//           while (count == t.length()){
//               if ( r - l + 1 < minLength){
//                   minLength = r - l + 1;
//                   startIndex = l;
//               }
//               map.put(s.charAt(l),map.get(s.charAt(l)) - 1);
//               if (map.get(s.charAt(l)) > 0) {
//                   count -- ;
//               }
//           }
//           r++;
//       }
//       return startIndex == -1 ? "" : s.substring(startIndex,minLength);
//    }

    public static int numSubarrayProductLessThanK(int[] arr, int k) {
        int prod = 1;
        int r = 0;
        int l = 0;
        int count = 0;

        while(r < arr.length){
            prod *= arr[r];

            while(prod >= k){
                prod /= arr[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

}
