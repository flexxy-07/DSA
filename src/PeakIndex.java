public class PeakIndex {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2};
        int peak = peakIndexInMountainArray(arr);
        System.out.println(peak);



    }
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start + (end -start)/2;
            if(arr[mid]>arr[mid+ 1]){ // this means we are in the decreasing part of the array
                end = mid;
            }
            else{
                start = mid +1;
            }


        }
        return start;


    }


}
