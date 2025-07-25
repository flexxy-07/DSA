import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        System.out.println(PairList("", 4));

    }

    static void Pair(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            Pair(p + i, target - i);


        }
    }


    static ArrayList<String> PairList(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= target; i++) {
            ans.addAll(PairList(p + i, target - i));


        }
        return ans;
    }
}

