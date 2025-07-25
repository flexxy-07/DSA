import java.util.*;

public class Assignment_2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        float pie = 3.14f;
//
//        float a = pie * n*n;
//        System.out.println(a);

        // SUBTRACTON OF PRODUCT AND SUM OF AN INTEGER

//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    int p = 1;
//    int s = 0;
//    int temp = n;
//
//        while(n>0){
//        int l = n%10;
//        p = p*l;
//        n = n/10;
//    }
//        while(temp>0){
//            int l = temp%10;
//            s = s + l;
//            temp = temp/10;}
//        System.out.println(p-s);

        // FACTORS OF A NUMBER


//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        for (int i =1; i<=n; i++){
//            if (n%i==0){
//                System.out.println(i);
//            }
//        }

//        Scanner st = new Scanner(System.in);
//        int s = 0;
//         while(true){
//
//             int n = st.nextInt();
//             if (n!=0){
//                 s=s+n;
//             } else if (n==0) {
//                 break;
//
//             }
//         }
//        System.out.println(s);
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n=69;
        int max=0;
        while(n!=0)
        {
            n = sc.nextInt();
            max= Math.max(max, n);
        }
        System.out.println(max);
    }
}
