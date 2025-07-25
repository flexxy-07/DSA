import java.util.*;

public class NestedSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int EmpNo = sc.nextInt();
        String kaam = sc.next();

        switch (EmpNo){

            case 1 :
                System.out.println("Bihari");
                break;
            case 2 :
                System.out.println("Pahadi");
                break;
            case 3 :
                switch (kaam){
                    case "kabadiwala" :
                        System.out.println("Kabadi");
                        break;
                    case "Jhaaduwala" :
                        System.out.println("Jamadar");
                        break;
                    default:
                        System.out.println("Enter a Valid Work");

                }
                break;
            default:
                System.out.println("Enter a Valid Emp No");
        }
    }
}
