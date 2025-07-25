package Stack;
import java.util.*;

 class CustomStack {
     public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
   //      System.out.println(validateStackSequences(pushed,popped));
            int[] temp = {73,74,75,71,69,72,76,73};
         System.out.println(Arrays.toString(dailyTemperatures(temp)));
     }
     public static int[] dailyTemperatures(int[] temp) {                        // An example of Monotonic Stack
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temp.length];
         for (int i = 0; i < temp.length; i++) {
             while (!stack.isEmpty() && temp[i] > temp[stack.peek()]){
                 int prev = stack.pop();
                 ans[prev] = i - prev;
             }
             stack.push(i);
         }
         return ans;
     }

     public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ptr = 0;
        for (int number : pushed){
            stack.push(number);

            while (!stack.isEmpty() && stack.peek() == popped[ptr]){
                stack.pop();
                ptr++;
            }
        }
        return stack.isEmpty();
     }


 }
