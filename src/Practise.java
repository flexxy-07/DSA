import java.util.*;

class Practise {
    public static void main(String[] args) {
        int n = 4012;
 //       System.out.println(Arrays.toString(getNoZeroIntegers(n)));
    int[] arr = {287,41,49,287,899,23,23,20677,5,825};
        System.out.println(replaceNonCoprimes(arr));

    }
    public static int[] getNoZeroIntegers(int n) {
        int[] arr = new int[2];
        int l = 1;
        while (l < n){
            int r = n - l;
            if (NotContainsZero(l) && NotContainsZero(r) && l + r == n){
                arr[0] = l;
                arr[1] = r;
                break;
            }
            l++;
        }
        return arr;
    }
    private static boolean NotContainsZero(int n){
        while (n != 0){
            int l = n % 10;
            if (l == 0) return false;
            n /= 10;
        }
        return true;
    }
    public static List<Integer> replaceNonCoprimes(int[] arr) {
        Deque<Long> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        for(int val : arr){
            long curr = val;
            while (!stack.isEmpty() && NotCoprime(stack.peek(),curr)){
                curr = getLCM(stack.poll(),curr);
            }
            stack.push(curr);
        }
        for(long val : stack){
            ans.add((int)val);
        }
        return ans;
    }
    private static boolean NotCoprime(long a, long b){
        return gcd(a , b) > 1;
    }
    private static long gcd(long a , long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private static long getLCM(long a, long b){
        return a / gcd(a , b) * b;
    }
}