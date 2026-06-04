package BinarySearch.Answers;

public class ShipCapacity {
    public static void main(String[] args) {
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weights, 5));
    }
    static public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int weight: weights){
            low = Math.max(low, weight);
            high += weight;
        }

        while(low<high){
            int cap = low + (high - low)/2;
            if(ableToShipInTime(weights, days, cap)){
                high = cap;
            }else{
                low = cap+1;
            }
        }

        return high;
    }
    static boolean ableToShipInTime(int weights[], int d, int c){
        int timeTake = 0;
        int weightSum = 0;
        for(int w: weights){
            if(w + weightSum <= c){
                weightSum += w;
            }else{
                timeTake++;
                weightSum = w;
            }
        }

        if(weightSum!=0) timeTake++;
        return timeTake<=d;
    }
}
