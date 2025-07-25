import java.util.Scanner;

public class Conditionals_and_loops {
    public static void main(String[] args) {
//        Scanner st =  new Scanner(System.in);
//        int a = st.nextInt();
//        int b = st.nextInt();
//        int c = st.nextInt();

//        int max = a;
//
//        if (b>max)
//            max = b;
//        if (c>b)
//            max = c;  http://172.16.16.16:8090/httpclient.html
//
//        System.out.println(max);
//
//        int max = Math.max(56,69);
//        System.out.println(max);


//          Scanner sc = new Scanner(System.in);
//          char z = sc.next().trim().charAt(0);
//
//          if ( z >= 'a' && z<='z')
//          {
//              System.out.println("Lowercase");
//          }
//           else
//              System.out.println("Uppercase");


//        int a =0, b=1;
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int count = 2;
//
//        while (count<=n){
//            int temp = b;
//            b = b+a;
//            a = temp;
//            count++;
//        }
//
//        System.out.println(b);


//        int n = 1385757879;
//        int count = 0;
//
//        for (int i =1; i<=10; i++){
//            int l = n%10;
//            if (l==8){
//                count++;}
//            n = n/10;
//
//        }
//        System.out.println(count);

        int n =28479;
        int ans = 0;
         while (n>0)
         {int r = n%10;
             n = n/10;
             ans = ans *10+ r;
        }
        System.out.println(ans);

    }
}
