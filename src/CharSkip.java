public class CharSkip {
    public static void main(String[] args) {
        String s1 = "baccadaaaeaaaxyz";
//       StringBuilder s = new StringBuilder();
//        for (int i = 0; i < s1.length(); i++) {
//            if(s1.charAt(i) != 'a'){
//                s.append(s1.charAt(i));
//            }
//
//        }
//        System.out.println(s);
//        skip("",s1);
        System.out.println(skipp(s1));

    }
    static void skip(String og,String ng){
        if (ng.isEmpty()){
            System.out.println(og);
            return ;

        }
        char ch = ng.charAt(0);
        if(ch == 'a'){
            skip(og,ng.substring(1));
        }else {
            skip(og + ch,ng.substring(1));
        }

    }
    static String skipp(String str){
        if(str.isEmpty()){
            return "";
        }
        char ch = str.charAt(0);
        if (ch == 'a'){
            return skipp(str.substring(1));
        }else{
            return ch + skipp(str.substring(1));
        }
    }

}
