import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        System.out.println(padlist("","2"));

    }
    static void pad(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = (up.charAt(0) - '0'); // This will convert '2' into 2.
        for (int i = (digit-1) *3 ; i < digit*3 ; i++) {
            char ch = (char)('a' + i);
            pad(p+ch,up.substring(1));

        }}
        static ArrayList<String> padlist(String p, String up){
            if (up.isEmpty()){
                ArrayList<String> list = new ArrayList<>();
                list.add(p);
                return list;
            }
            int digit = up.charAt(0) - '0'; // This will convert '2' into 2.
            ArrayList<String> ans = new ArrayList<>();
            for (int i = (digit-1) *3 ; i < digit*3 ; i++) {
                char ch = (char)('a' + i-3);
                ans.addAll(padlist(p+ch,up.substring(1)));

            }
            return ans;


        }
}


