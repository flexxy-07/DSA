package staticExample;

public class InnerClass {
   static class Test{
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Rahul");
        Test b = new Test("Ram");
    }
}
