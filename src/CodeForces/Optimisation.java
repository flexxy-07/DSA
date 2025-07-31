package CodeForces;
import java.util.*;

public class Optimisation {
    public static void main(String[] args) { // 1 2 3 4 5 6 7
        Scanner sc = new Scanner(System.in);
//        int[] op = {0,1,0,1};
//   //     System.out.println(kthCharacter(10,op));
//        int[] players = {4,7,9};
//        int[] trainers = {8,2,5,8};
//
////        String s = "leeetcode";
////        System.out.println(makeFancyString(s));
//        int[] arr = { 3,2,4};
//        int target = 6;
        int[] arr = {1,3,1,2,2};
        System.out.println(countCompleteSubarrays(arr));




    }
    public static char kthCharacter(long k, int[] op) {
        long length = 1;

        for (int val : op) {
            length *= 2;
        }
        int shift = 0;
        for (int i = op.length -1; i >= 0 ; i--) {
            length /= 2;

            if (k > length){
                k -= length;
                if (op[i] == 1){
                    shift++;
                }
            }
        }
        return (char)((shift) % 26 + 'a');
    }

    public static char kthCharacter(int k) {
     //   return generate(new StringBuilder("a"),k);
        int length = 1;
        char base = 'a';
        while (length < k){
            length *= 2;
        }
        while (length > 1){
            length /= 2;
            if (k > length){
                k -= length;
                base++;
            }
        }
        return (char) (base % 26);
    }
    public static StringBuilder generate(StringBuilder s) {
            int l = s.length();
            for (int i = 0; i < l; i++) {
                char ch = s.charAt(i);
                if (ch == 'z'){
                    s.append('a');
                }else{
                    s.append((char) ((ch + 1) ));
                }
            }
        return s;
    }
    public static StringBuilder Double(StringBuilder s){
        return s.append(s);
    }
    public static String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        char prev = ' ';
        int counter = 0;
        for (char ch : s.toCharArray()){
            if (prev == ch) {
                counter++;
            }else{
                counter = 0;
            }
            if (counter < 2){
                ans.append(ch);
            }
            else if (counter >= 2 && prev == ch) {
                counter++;
            }
            else{
                counter = 0;
            }
            prev = ch;
        }
        return ans.toString();
    }
    public static int countCompleteSubarrays(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : arr){
            set.add(val);
        }
        System.out.println(set.size());
        int counter = 0;
        int maxSize = set.size();
        for(int i = 0;i < arr.length; i++){
            HashSet<Integer> pres = new HashSet<>();
            for(int j = i; j < arr.length; j++){
                pres.add(arr[j]);
                if(pres.size() == maxSize){
                    counter++;
                }
            }
            System.out.println(pres.size());
            // System.out.println(pres);
        }
        return counter;
    }



}
