public class StocksBuy {
    public static void main(String[] args) {
        int[] arr =  {7,1,5,3,6,4};
        System.out.println(maxPro(arr));

    }
    // Multiple Transactions are allowed
    static int maxProfit(int arr[]){
       int pro =0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]){
                pro+= arr[i] - arr[i-1];
            }

        }
        return pro;

    }
    //If only one transaction is Allowed
    static int maxPro(int[] arr){
        int maxpro = 0;
        int minprice = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] < minprice){
                minprice = arr[i];
            }else{
                int currpro = arr[i] - minprice;
                if (currpro > maxpro){
                    maxpro = currpro;
                }
            }

        }
        return maxpro;
    }
}
