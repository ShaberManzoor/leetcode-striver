package SlidingWindow_TwoPointers.MediumProblems;

public class CardPoints {
    public int maxScore(int cardPoints[], int k){
        int n = cardPoints.length;
        int points = 0;

        for(int i=0;i<k;i++){
            points += cardPoints[i];
        }

        int maxPoints = points;
        for(int i=k-1;i>=0;i--){
            points -= cardPoints[i];
            points += cardPoints[n-k+i];

            maxPoints = Math.max(maxPoints, points);
        }

        return maxPoints;
    }
}
