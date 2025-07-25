import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int [] arr = {4,4,4,3,3,3,5,5,5,5,1};
        System.out.println(Major(arr));

    }
    static List<Integer> majorElement(int[] arr){ // this method is not Optimised...

        int counter =0 ;
        List<Integer> list = new ArrayList<>();
        int check = arr.length / 3;
        for (int i = 0; i <arr.length ; i++) {
            counter = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] ){
                    counter++;
                }
            }
            if (counter >= check){
                if (!list.contains(arr[i]))
                list.add(arr[i]);
            }


        }
        Collections.sort(list);
        return list;


    }
    // Optimised Code : Boyer Moore Voting Algorithm
    // Majority Element without using HashMap
    static List<Integer> Major(int[] arr){
        int num1 = -1, num2 = -1;
        int count1 =0, count2 = 0;

        for(int num : arr){
            if (num == num1){
                count1++;
            }else if(num == num2){
                count2++;
            } else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            }else if(count2 == 0){
                num2 = num;
                count2 =1;
            }else{
                count1--;
                count2--;

            }
        }
        count1 = 0;
        count2 =0;
        for (int num : arr){
            if (num == num1) count1++;
            else if (num == num2) {
                count2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        int check = arr.length / 3;
        if (count1 > check) list.add(num1);
        if (count2 > check) list.add(num2);

        Collections.sort(list);
        return list;

    }

}
