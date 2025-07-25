import java.util.ArrayList;

public class FindingIndexRecursion {
    public static void main(String[] args) {
        int[] arr  = {1,2,3,4,4,8};
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println(listt(arr,4,0,nums));

    }
    static ArrayList<Integer> listt(int[] nums,int target,int index, ArrayList<Integer> arr){
        if(index == nums.length)
            return arr;
        if (nums[index] == target)
            arr.add(index);
        return listt(nums,target,index +1,arr);

    }
}
