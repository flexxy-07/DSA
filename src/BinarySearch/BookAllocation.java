package BinarySearch;
import java.util.*;

public class BookAllocation {
    public static void main(String[] args) {
        int[] books = {1,2,3,4,5};
        int students = 2;
        System.out.println(allocateBooks(books, students));
    }
    public static int allocateBooks(int[] books, int students){
        if (students > books.length) return -1;
        int[] arr = maxElemAndSum(books);
        int min = arr[0];
        int max = arr[1];

        int start = min;
        int end = max;

        while (start < end){
            int mid = start + (end - start) / 2;
            if (pages(books, mid) > students){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
    private static int pages(int[] books, int Pages){
        int student = 1;
        int currPage = 0;
        for (int page : books){
            if (currPage + page <= Pages){
                currPage += page;
            }
            else {
                student++;
                currPage = page;
            }
        }
        return student;
    }
    private static int[] maxElemAndSum(int[] arr){
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int val : arr){
            if (val > max) max = val;
            sum += val;
        }
        return new int[]{max,sum};
    }
}
