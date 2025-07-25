package staticExample;

public class StaticBlock {
    static int a = 5;
    static int b;
// tht below static will run once, when the first obj is created i.e, when the class is loaded
    static {
        System.out.println("I am in the static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        StaticBlock obj = new StaticBlock();
        System.out.println(StaticBlock.a +" " + StaticBlock.b);

        StaticBlock.b += 3;

        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
    }
}
