import java.util.Arrays;

public class Passing_Values_Array {
    public static void main(String[] args) {
        int[] arr = {0,1,65,99,25};
        System.out.println(Arrays.toString(arr));
        changeValue(arr);
        System.out.println(Arrays.toString(arr));


    }
    static void changeValue(int[] bsdk){
        bsdk[2]=69;

    }
}
