public class RangeXOR {
    public static void main(String[] args) {
        // range xor for (a,b) = xor(b) ^ xor(a-1)
        int a = 3;
        int b =9;
        int ans = xor(b) ^ xor(a-1);
        System.out.println(ans);


    }
    // this gives xor from 0 to n
    static int xor(int n){
        if(n % 4 == 0)
            return n;
        if(n % 4 == 1)
            return 1;
        if(n % 4 == 2)
            return n+1;

        return 0;
    }
}
