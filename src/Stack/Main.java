package Stack;

public class Main {
    public static void main(String[] args) {
        CustomStacks stk = new CustomStacks();
        stk.push(1);
        stk.push(5);
        stk.push(8);
        stk.push(9);
        stk.push(4);

        System.out.println(stk.pop());
    }
}
