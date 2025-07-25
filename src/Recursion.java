public class Recursion {
    public static void main(String[] args) {
       // print(1);
      //  nums(5);
     //   System.out.println(Fact(7));
        System.out.println(11 / 10);

    }
    static void print(int n){
        if(n == 5){                     // Base Case
            System.out.println(5);
             return;}

        System.out.println(n);          //Body of the Function

        print(n + 1);                   // Recursive Call

    }
    static void nums(int n){
        if (n ==1) {System.out.print(1);
        return;
        }
        System.out.print(n + " ");
        nums(n-1);


    }
    static int Fact(int n){
        if (n == 1)
             return 1;

        return n * Fact(n-1);
    }

}
