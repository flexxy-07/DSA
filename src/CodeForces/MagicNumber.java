package CodeForces;
import java.util.*;

public class MagicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pedo = new int[n];
        for (int i = 0; i < n; i++) {
            pedo[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] ax = new int[m];
        for (int i = 0; i < m; i++) {
            ax[i] = sc.nextInt();
        }
        System.out.println(maxGear(pedo,ax,n,m));
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
}
