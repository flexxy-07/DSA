import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {

            String greeting = Greet("Sumit");
        System.out.println(greeting);

    }

    static String Greet(String name) {
        String message = "Hello "+ name;
        return message;
    }

}