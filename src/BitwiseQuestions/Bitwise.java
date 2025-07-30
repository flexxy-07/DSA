package BitwiseQuestions;

import java.util.Arrays;

public class Bitwise {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {2,3,3,4,2,6,4};
      //  System.out.println(unique(arr));
      //  System.out.println(magic(n));
     //   System.out.println(1  >> 2); // Left Shift :  a << b = a * 2^b;
                                     // Right Shift : a >> b = a / 2^b ;
        System.out.println(setBit(9,2));


    }
    static int setBit(int n, int BitToSet){
        int ans = n | (1 << BitToSet);
        return ans;
    }
    static int unique(int[] arr){
        int uni =0;
        for(int num : arr){
            uni = uni ^num;
        }
        return uni;
    }

    static boolean isOdd(int n) {
        return ((n & 1) ==1);
    }
    static int magic(int n){
        int base = 5;
        int ans =0;
        while(n > 0){
            int last = n & 1;
            n = n >> 1;
            ans = ans + last * base;
            base = base * 5;
        }
        return ans;
    }
    static int singleNumberr(int[] arr){
        Arrays.sort(arr);
        for (int i = 1; i < arr.length ; i = i+3) {
            if (arr[i] != arr[i-1]){
                return arr[i-1];
            }
        }
        return arr[arr.length-1];
    }
    static int singleNumber(int[] arr) {
        int val = 0;
        for (int i = 0; i <= 31 ; i++) {
            int count = 0;
            for (int j = 0; j < arr.length  ; j++) {
                if ((arr[j] & (1 << i)) != 0){
                    count++;
                }
            }
            if (count % 3 == 1){
                val = val | (1 << i);
            }
        }
        return val;


    }



}
