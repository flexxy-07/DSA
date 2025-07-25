import java.math.*;

public class BigIntegerMath {
    public static void main(String[] args) {
        String n = "325948";
        System.out.println(minPartitions(n));
    }
    static int minPartition(String n) {                // This method got TLE on LeetCode..will try to avoid using this
        BigInteger val = new BigInteger(n);
        int maxD = 0;
        while(val.compareTo(BigInteger.ZERO) > 0){
            int l = val.mod(BigInteger.TEN).intValue();
            if (maxD < l){
                maxD = l;
            }
            val = val.divide(BigInteger.TEN);
        }
        return maxD;
    }
    static int minPartitions(String n){
        int max =0 ;
        for(char c : n.toCharArray()){
            int dig = c - '0';
            if (dig > max){
                max = dig;
            }
            if(max == 9) return 9;
        }
        return max;
    }
}
