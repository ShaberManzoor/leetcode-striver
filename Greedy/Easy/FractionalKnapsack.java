package Greedy.Easy;

import java.util.Arrays;

class Items {
    int val,  wt;
    Items(int val, int wt) {
        this.val = val;
        this.wt = wt;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int cap = 50;
        
        System.out.println(fractionalKnapsack(val, wt, cap));
    }

    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        Items[] items = new Items[val.length];

        for(int i=0;i<val.length;i++){
            items[i] = new Items(val[i], wt[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare((double) b.val/b.wt, (double) a.val/a.wt));

        double maxVal = 0.0;
        for(Items item: items){
            if(capacity>=item.wt){
                maxVal += item.val;
                capacity -= item.wt;
            }else{
                maxVal += ((double) item.val/item.wt) * capacity;
            }
        }

        return maxVal;
    }
}
