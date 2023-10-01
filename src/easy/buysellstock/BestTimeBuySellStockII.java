package easy.buysellstock;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BestTimeBuySellStockII {

    public static void main(String[] args) {
        BestTimeBuySellStockII main = new BestTimeBuySellStockII();
        int[] prices = new int[]{7, 2, 8, 1, 2, 3};
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//        int[] prices = new int[]{7, 6, 4, 3, 1};
        int result = main.maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] maxProfit = new int[n][2];  // maxProfit[i][0] represents the maximum profit on day i when not holding a stock
                                            // maxProfit[i][1] represents the maximum profit on day i when holding a stock

        maxProfit[0][0] = 0;                // Initial profit on the first day when not holding a stock is 0
        maxProfit[0][1] = -prices[0];       // Initial profit on the first day when holding a stock is the negative of its price

        for (int i = 1; i < n; i++) {
            int currentPrice = prices[i];
            // Update the maximum profit on day i when not holding a stock
            maxProfit[i][0] = Math.max(maxProfit[i - 1][0], maxProfit[i - 1][1] + currentPrice);

            // Update the maximum profit on day i when holding a stock
            maxProfit[i][1] = Math.max(maxProfit[i - 1][1], maxProfit[i - 1][0] - currentPrice);
        }
        System.out.println(Arrays.deepToString(maxProfit));

        return maxProfit[n - 1][0];  // Return the maximum profit on the last day when not holding a stock
    }
}
