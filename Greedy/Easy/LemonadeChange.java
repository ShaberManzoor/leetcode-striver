package Greedy.Easy;

public class LemonadeChange {
    public boolean lemonadeChange(int bills[]){
        if(bills[0]!=5) return false;

        boolean poss = true;

        int five = 0, ten = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) {
                five++;
            }else if(bills[i]==10){
                if(five>0){
                    five--;
                    ten++;
                }else{
                    poss = false;
                    break;
                }
            }else{
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }else if(five>=3) {
                    five -= 3;
                }else{
                    poss = false;
                    break;
                }
            }
        }

        return poss;
    }
}
