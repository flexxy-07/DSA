import java.util.*;
public class SubSeq {
    public static void main(String[] args) {
      //  subseq("","abc");
        System.out.println(subseqRet("","abc"));


    }
    static void subseq(String processed,String unprocessed){
        if (unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        subseq(processed + ch,unprocessed.substring(1));
        subseq(processed,unprocessed.substring(1));
    }
    static ArrayList<String> subseqRet(String p, String unp){
        if(unp.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = unp.charAt(0);
        ArrayList<String> left = subseqRet(p + ch,unp.substring(1));
        ArrayList<String> right = subseqRet(p,unp.substring(1));
        left.addAll(right);
        return left;

    }
}
