package CodeForces;
import java.util.*;

public class MagicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] pedo = new int[n];
//        for (int i = 0; i < n; i++) {
//            pedo[i] = sc.nextInt();
//        }
//        int m = sc.nextInt();
//        int[] ax = new int[m];
//        for (int i = 0; i < m; i++) {
//            ax[i] = sc.nextInt();
//        }
//        System.out.println(maxGear(pedo,ax,n,m));
        int[] arr = {84,93,100,77,93};
        System.out.println(Arrays.toString(maxKDistinct(arr,3)));
    }

    static int maxGear(int[] pedo, int[] ax, int n, int m) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ax[i] % pedo[j] == 0) {
                    int ratio = ax[i] / pedo[j];
                    if (ratio == max) {
                        count++;
                    }
                    if (ratio > max) {
                        max = ratio;
                        count = 1;
                    }
                }
            }
        }
        return count;
    }
    public static int[] maxKDistinct(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int val : nums){
            heap.add(-val);
        }
        HashSet<Integer> set = new HashSet<>();
        int[] ans = new int[k];
        int t = k;

        while (t > 0 && !heap.isEmpty()){
            int val = -heap.poll();
            if(!set.contains(val)){
                ans[k - t] = val;
                set.add(val);
                t--;
            }
        }
        return ans;
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> ditto = new HashSet<>();
        Map<String, String> small = new HashMap<>();
        Map<String, String> vow = new HashMap<>();

        for (String str : wordlist){
            ditto.add(str);

            String low = str.toLowerCase();
            small.putIfAbsent(low , str);

            String deVow = devow(low);
            vow.putIfAbsent(deVow , str);
        }

        String[] ans = new String[queries.length];

        for (int i = 0; i < ans.length; i++) {
            String query = queries[i];

            if (ditto.contains(query)){
                ans[i] = query;
            }else{
                String low = query.toLowerCase();
                if (small.containsKey(low)){
                    ans[i] = small.get(low);
                }
                else{
                    String devowel = devow(low);
                    ans[i] = vow.getOrDefault(devowel , "");
                }
            }
        }
        return ans;
    }
    private String devow(String s){
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (isVowel(ch)){
                ans.append("*");
            }else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}
