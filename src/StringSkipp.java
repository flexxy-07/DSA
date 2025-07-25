public class StringSkipp {
    public static void main(String[] args) {
        System.out.println(skipAppNotApple("appDevIsWhatYouShouldDOAfterEatingAnApple"));

    }
    static String skippStr(String str){
        if(str.isEmpty()){
            return "";
        }
        char ch = str.charAt(0);

        if (str.startsWith("apple")){
            return skippStr(str.substring(5));
        }else{
            return ch + skippStr(str.substring(1));
        }
    }
    static String skipAppNotApple(String str){
        if(str.isEmpty()){
            return "";
        }
        char ch = str.charAt(0);

        if (str.startsWith("app") && !str.startsWith("apple")){
            return skipAppNotApple(str.substring(3));
        }else{
            return ch + skipAppNotApple(str.substring(1));
        }
    }
}
