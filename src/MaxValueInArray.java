import java.util.Scanner;

public class MaxValueInArray {
    public static void main(String[] args) {
        int[] arr = new int[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

        }
        System.out.println(max(arr));

    }
    static int max(int[] arr){
        int MaxVal = arr[0];
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] > MaxVal){
                MaxVal = arr[i];
            }




        }
        return MaxVal;



    }
}
