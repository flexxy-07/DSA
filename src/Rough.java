import java.util.*;
public class Rough {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
     int t = sc.nextInt();
      while(t --  > 0){
            int doors = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[doors];
              for (int i = 0; i < doors; i++) {
                    arr[i] = sc.nextInt();
           }
            int first = -1;
            int last = -1;
            int check = 0;
            int s = 0, e = arr.length -1;
        while (s <= e) {
            if (first == -1 && arr[s] == 1) {
                first = s;
            }
            if (last == -1 && arr[e] == 1) {
                last = e;
            }
            // Break early if both found
            if (first != -1 && last != -1) break;

            if (first == -1) s++;
            if (last == -1) e--;
        }
        if (last - first + 1 <= x) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


        }
    }

