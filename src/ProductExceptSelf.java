

    import java.util.*;

    public class ProductExceptSelf {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] arr = {1,2,3,4};
            System.out.println(Arrays.toString(productExceptSelf(arr)));




        }
            static int[] productExceptSelf(int[] arr) {
                int[] pre = new int[arr.length];
                int[] post = new int[arr.length];
                int[] ans = new int[arr.length];
                pre[0] = 1;
                for (int i = 1; i < arr.length; i++) {
                    pre[i] = pre[i -1] * arr[i - 1];
                }
                post[arr.length-1] = 1;
                for (int i = arr.length - 2; i >= 0; i--) {
                        post[i] = post[i +1] * arr[i+1];
                }
                for (int i = 0; i < ans.length; i++) {
                    ans[i] = post[i] * pre[i];
                }
                return ans;


            }

    }