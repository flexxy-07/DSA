package Recursion;
import java.util.*;
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans =  new ArrayList<>();
        List<String> track = new ArrayList<>();
        Breaker(ans,s,0,new ArrayList<>());
        return ans;
    }
    private void Breaker(List<List<String>> ans, String s , int index, List<String> track){
        if (index == s.length()){
            ans.add(new ArrayList<>(track));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s,index,i)){
                track.add(s.substring(index,i + 1));
                Breaker(ans,s,i + 1,track);
                track.remove(track.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
