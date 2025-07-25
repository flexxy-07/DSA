import java.util.*;

public class Assignment_1 {
    public static void main(String[] args) {
        // Q1.PRIME NUMBER


//        Scanner inp = new Scanner(System.in);
//        int n = inp.nextInt();
//        int count=0;
//
//        for (int i =1; i<n; i++){
//            if (n%i==0){
//                count++;
//            }
//
//
//        }
//        if (count==1){
//            System.out.println("It a Prime Number");
//
//        }
//        else
//            System.out.println("Not a Prime Number");

//        QUESTION 2.

//        Scanner sc = new Scanner(System.in);
//       String n=sc.nextLine();
//        System.out.println("Hello "+n+", we cordially invite you to our tech event.");

        //   QUESTION 3.
//        Scanner sc = new Scanner(System.in);
//        int r=sc.nextInt();
//        int p = sc.nextInt();
//        int t = sc.nextInt();
//
//        int SI = (p*r*t)/100;
//        System.out.println(SI);

        //   QUESTION 4.


//        int num1 = st.nextInt();
//        int num2 = st.nextInt();
//       char o = sc.nextLine().charAt(0);
//
//       if (o=='+') {
//           System.out.println("Sum= "+(num1+num2));
//       }
//       else if (o=='-') {
//           System.out.println("Diff= "+(num1-num2));
//       } else if (o=='*') {
//           System.out.println("Prod= "+(num1*num2));
//
//       } else if (o=='/') {
//           System.out.println("Div= "+(num1/num2));
//
//       }
//       else
//           System.out.println("Invalid Operation");
//
//


//        QUESTION.4

//        System.out.print("Enter Num1: ");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.print("Enter Num2: ");
//        int m = sc.nextInt();
//
//        if (n>m){
//            System.out.println("n");
//        } else if (m>n) {
//            System.out.println("m");
//
//
//        }
//        else
//            System.out.println("m=n");

//        QUESTION 5
//        System.out.print("Enter Rupee= ");
//       Scanner pwd = new Scanner(System.in);
//       float r = pwd.nextFloat();
//       float u = (float) (r/1.5);
//        System.out.println("In USD = "+u);
//
//        QUESTION 7.FIBBONACI SERIES


//        int a=0,b=1;
//        System.out.print("Enter Number: ");
//        //System.out.print("0 1");
//        Scanner st = new Scanner(System.in);
//        int n = st.nextInt();
//        for (int i =1; i<=n; i++){
//            System.out.print(a+" ");
//
//            int c = a+b;
//            a=b;
//            b=c;

//        System.out.println("Enter Number= ");
//        Scanner st = new Scanner(System.in);
//        int n = st.nextInt();
//        int count= 0;
//        int temp = n;
//
//
//        while (n!=0){
//            n = n/10;
//            count++;
//
//        }
//        int sum =0;
//        for (int i=1; i<=count; i++){
//            int d = temp%10;
//            sum = sum + (int)Math.pow(d,count);
//
//             temp = temp/10;
//
//
//        }
//
//       if()
//

        System.out.println("Enter the Nmber: ");
        Scanner st = new Scanner(System.in);
        int n = st.nextInt();
        int r = 0;
        int temp = n;



        while (n > 0) {
            int l = n % 10;
            r = (r * 10) + l;
            n = n / 10;
        }
        System.out.println(r);

        if (temp== r) {
            System.out.println("The Number is Palindrome");
        }
        else
            System.out.println("Fuck You");

    }
}






