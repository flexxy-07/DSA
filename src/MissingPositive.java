import java.util.Arrays;

public class MissingPositive {
    public static void main(String[] args) {
        int[] arr = {2, 6, 2, -8, -7, 8};
        System.out.println(missed(arr));

    }
    static int missed(int[] arr){
        Arrays.sort(arr);
        int miss = 1;
        int check =0;
        for (int i = 0; i < arr.length - 1; i++) {
            check++;
            if (arr[i] >= 0){
                if (arr[i] != arr[i+1] && arr[i+1] != arr[i] + 1){
                    miss = arr[i] + 1;
                    break;
                }
            }
        }
        if (++check == arr.length && miss ==1){
            return arr[arr.length -1] + 1;
        }
        return miss;

    }
}
