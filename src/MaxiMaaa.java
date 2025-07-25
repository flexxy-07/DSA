import java.util.Scanner;

public class MaxiMaaa {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int small = 1;
            int large = n;
            int[] per = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0){
                    per[i] = large--;
                }else{
                    per[i] = small++;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(per[i] + "");
            }
            System.out.println();
        }
   }
}
