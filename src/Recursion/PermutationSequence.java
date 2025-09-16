package Recursion;
import java.util.*;
public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPerm(3,1));
    }
    // Backtracking, TC = O(n!);
    static int count = 0;
    static boolean check = false;
    public static String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder();
        RecursiveCave(n,k,new boolean[n],new StringBuilder(),ans);
        return ans.toString();
    }
    private static void RecursiveCave(int n, int k,boolean[] map,StringBuilder str,StringBuilder ans){
        if (check) return;
        if (str.length() == n){
            count++;
            if (count == k){
                ans.append(str);
                check = true;
            }
            return;
        }
        for (int i = 1 ; i <= n ; i++) {
            if (!map[i - 1]){
                map[i - 1] = true;
                str.append(i);
                RecursiveCave(n,k,map,str,ans);
                str.deleteCharAt(str.length() - 1);
                map[i - 1] = false;
            }
        }
    }
    // Optimized using Maths and Factorial stuff
    private static String getPerm(int n, int k){
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            num.add(i);
        }
        int[] facts = new int[n + 1];
        facts[0] = 1;
        for (int i = 1; i <= n ; i++) {
            facts[i] = facts[i - 1] * i;
        }
        k--;

        StringBuilder ans = new StringBuilder();
        for (int i = n; i >= 1 ; i--) {
            int index =  k / facts[i - 1];
            k = k % facts[i - 1];
            ans.append(num.get(index));
            num.remove(index);
        }
        return ans.toString();
    }
}
