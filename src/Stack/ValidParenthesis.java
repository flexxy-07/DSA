package Stack;
import java.util.*;
public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "(((";
        System.out.println(minAddToMakeValid(s));

    }

    public static boolean isValid(String s) {
        Stack<Character> stk  = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                stk.push(ch);
            }else{
                if (ch == ')'){
                    if (stk.isEmpty() || stk.pop() != '('){
                        return false;
                    }
                }
                if (ch == ']'){
                    if (stk.isEmpty() || stk.pop() != '['){
                        return false;
                    }
                }
                if (ch == '}'){
                    if (stk.isEmpty() || stk.pop() != '{'){
                        return false;
                    }
                }
            }
        }
        return stk.isEmpty();
    }
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == ')'){
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
