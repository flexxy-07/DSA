public class MountainArrayHard {
    public static void main(String[] args) {
        int [] arr = {0,1,2,4,2,1};
        int peakInd= PeakIndx(arr);
        int target = 3;
        int start =0;

        int s1 = binarySearch(arr,target,start,peakInd);
        if(s1 == -1){
             s1 = binarySearch(arr,target,peakInd, arr.length-1);
        }
        System.out.println(s1);
    }

    static int PeakIndx(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while (start<end){
            int mid = start + (end - start)/2;
            if(arr[mid]>arr[mid+1]){
                end = mid;
            }
            else
                start = mid+1;
        }
        return start;
    }
    static int binarySearch(int[] arr,int target,int start,int end ){

        while(start<=end){
            int mid  = start + (end - start)/2;
            if(target<arr[mid])
                end = mid-1;
            else if(target>arr[mid])
                start = mid +1;
            else
                return mid;

        }
        return -1;
    }

}
