import java.util.*;
public class HashingTry {
    public static void main(String[] args) {
        int[] arr = {2,2,2,3,3};


    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<Coupon> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String cCode = code[i];
            String line = businessLine[i];
            boolean active = isActive[i];

            boolean c1 = cCode.length() > 0;
            for (char ch : cCode.toCharArray()){
                if (!((ch >= 'a' && ch <= 'z') ||
                        (ch >= 'A' && ch <= 'Z') ||
                        (ch >= '0' && ch <= '9') ||
                        ch == '_')) {
                    c1 = false;
                    break;
                }
            }
            boolean c2 = line.equals("electronics") || line.equals("grocery") || line.equals("pharmacy") || line.equals("restaurant");

            boolean c3 = active;
            if (c3 && c2 && c1){
                list.add(new Coupon(cCode,line));
            }
        }
        Collections.sort(list,(a,b) -> {
            int p1 = getPriority(a.bLine);
            int p2 = getPriority(b.bLine);
            if (p1 != p2) return p1 - p2;
            return a.code.compareTo(b.code);
        });
        List<String> ans = new ArrayList<>();
        for (Coupon c : list){
            ans.add(c.code);
        }
        return ans;
    }
    private int getPriority(String bl){
        switch (bl) {
            case "electronics" : return 1;
            case "grocery": return 2;
            case "pharmacy": return 3;
            case "restaurant": return 4;
            default: return 5;
        }
    }
    class Coupon {
        String code;
        String bLine;
        Coupon(String code, String bLine){
            this.code = code;
            this.bLine = bLine;
        }
    }


}
