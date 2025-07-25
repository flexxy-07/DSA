import java.util.Arrays;

public class SearchInStrings {
    public static void main(String[] args) {
        String name= "Sumit";
        char target= 'u';
 //       System.out.println(search(name,target));
        System.out.println(Arrays.toString(name.toCharArray())); // Converting String to Array

    }
    static boolean search(String s,char t){
        if(s.length()==0){
            return false;

        }
        for (int i = 0; i < s.length(); i++) {
            if(t == s.charAt(i)){
                return true;

            }

        }
        return false;
    }

}
