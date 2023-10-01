package easy.buysellstock;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BestTimeBuySellStock {

    public static void main(String[] args) {
        BestTimeBuySellStock main = new BestTimeBuySellStock();
        int[] prices = new int[]{7, 2, 8, 1, 2, 3};
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//        int[] prices = new int[]{7, 6, 4, 3, 1};
        int result = main.maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length <= 1) {
            return maxProfit;
        }
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price <= buyPrice) {
                buyPrice = price;
            } else {
                int profit = price - buyPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
