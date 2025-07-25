import java.util.ArrayList;
import java.util.Scanner;

public class MultidimArraylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            arr.add(new ArrayList<>());}
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr.get(i).add(sc.nextInt());

            }

        }
        System.out.println(arr);

    }
}
