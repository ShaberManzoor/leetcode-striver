package DynammicProgramming.Stocks;

public class BuyAndSell1 {
    public static int maxProfit(int[] prices) {
        int buy = 1_000_000_000; //buy price
        int profit = 0;

        for(int price: prices) {
            if(price<buy) {
                buy = price;
            }

            profit = Math.max(profit, price-buy);
        }

        return profit;
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 4, 3, 5};

        System.out.println(maxProfit(prices));
    }
}
