public class JosephusMethod {
    public static void main(String[] args) {
        System.out.println(findwinner(6,5));

    }
    static int findwinner(int n , int k){
        return josephus(n,k) + 1; // converting 0 based index to 1 based index
    }
     static int josephus(int n, int k) {
        if (n == 1) return 0; // the last person standing

         return (josephus(n-1,k)+k)%n;
    }
}
