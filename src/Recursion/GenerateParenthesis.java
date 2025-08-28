package Recursion;
import java.util.*;
public class GenerateParenthesis {
    public static void main(String[] args) {

        System.out.println(generateParenthesis(5));

    }
    public static List<String> generateParenthesis(int n) {
        int leftCurves = n;
        int rightCurves = n;
        ArrayList<String> ans = new ArrayList<>();
        solver(leftCurves,rightCurves,ans,new StringBuilder());
        return ans;
    }
    private static void solver(int left, int right, ArrayList<String> list,StringBuilder str){
        if(left == 0 && right == 0){
            list.add(new String(str));
            return;
        }
        if(left != 0){
            str.append('(');
            solver(left - 1,right,list,str);
            str.deleteCharAt(str.length() - 1);
        }
        if (right > left) {
            str.append(')');
            solver(left,right - 1,list,str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
