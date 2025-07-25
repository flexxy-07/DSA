public class MaxProd {
    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};
        System.out.println(maxPro(arr));

    }
    static int maxPro(int[] arr){
        int currPro = 1;
        int maxProd = 1;
        for (int i = 0; i < arr.length; i++) {
            currPro = Math.max(arr[i], currPro*arr[i]);
            maxProd = Math.max(currPro,maxProd);
        }
        return maxProd;

    }

}
