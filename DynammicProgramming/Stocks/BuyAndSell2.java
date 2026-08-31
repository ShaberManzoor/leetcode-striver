package DynammicProgramming.Stocks;

public class BuyAndSell2 {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buy = 1_000_000_000;

        for(int price: prices) {
            if(buy<=price) {
                profit += price - buy;
                buy = price;
            } else {
                buy = price;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 4, 3, 5};

        System.out.println(maxProfit(prices));
    }
}
