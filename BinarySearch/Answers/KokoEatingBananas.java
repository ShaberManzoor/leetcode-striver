package BinarySearch.Answers;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int piles[] = {30,11,23,4,20};
        int h = 5;
        int minSpeed = minEatingSpeed(piles, h);
        System.out.println(minSpeed);
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1, maxSpeed = 0;

        //since the max speed will the pile with the max speed
        for(int pile:piles){
            maxSpeed = Math.max(maxSpeed, pile);
        }
        
        while(minSpeed<maxSpeed){
            int mid = minSpeed + (maxSpeed-minSpeed)/2;
            if(isAbleToEat(piles,h,mid)){
                maxSpeed = mid;
            }else{
                minSpeed = mid+1;
            }
        }

        return maxSpeed;
    }

    //whether she is able to eat all the bananas in h hours with speed s
    static boolean isAbleToEat(int piles[], int h, int s){
        int n = piles.length;
        int hoursTaken = 0; //hours taken to eat h
        for(int i=0;i<n;i++){
            hoursTaken += (piles[i] + s-1)/s;
        }

        return hoursTaken<=h;
    }
}
