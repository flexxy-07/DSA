public class PrimeNumber {
    public static void main(String[] args) {
        int n = 5;
        boolean[] primes = new boolean[n + 1];
        sieve(n,primes);                                   //   Sieve Of Eratosthenes
//        System.out.println(sieve(n,primes));


    }
    static int sieves(int n,boolean[] prime){
        for(int i=2;i*i <= n;i++){
            if(!prime[i]){
                for(int j=i*2;j<=n;j=j+i){
                    prime[j] = true;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(!prime[i]){
                count++;
            }
        }
        return count;
    }

    // False in array means, number is prime
    static void sieve(int n, boolean[] primes) {
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = i * 2; j <= n; j = j + i) {
                    primes[j] = true;

                }
            }

        }
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                System.out.println(i + " ");

            }


        }
    }
}
