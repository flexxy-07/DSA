package Greedy;

public class LemonadeExchange {
// Url : https://leetcode.com/problems/lemonade-change/
    public boolean lemonadeChange(int[] bills) {
        int fcount = 0;
        int tcount = 0;
        for(int val : bills){
            if(5 == val){
                fcount++;
            }
            else if(10 == val){
                if(fcount > 0){
                    fcount--;
                    tcount++;
                }else{
                    return false;
                }
            }
            else{
                if(fcount > 0 && tcount > 0){
                    fcount--;
                    tcount--;
                }
                else if(fcount >= 3){
                    fcount -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
