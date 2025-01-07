class StockProfit {

    /**
     * Calculates the maximum profit that can be achieved from a single buy-sell transaction.
     *
     * @param prices Array of stock prices where prices[i] is the price on the ith day.
     * @return Maximum profit achievable, or 0 if no profit is possible.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            // If there are fewer than 2 prices, no transaction is possible.
            return 0;
        }

        // Initialize variables for the minimum price so far and the maximum profit.
        int minPrice = prices[0]; // Price on the first day is the initial minimum.
        int maxProfit = 0;       // No profit at the start.

        // Loop through prices to calculate the maximum profit.
        for (int i = 1; i < prices.length; i++) {
            // Update the minimum price if a lower price is found.
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate the profit if selling at the current price.
                int profit = prices[i] - minPrice;
                // Update the maximum profit if the current profit is higher.
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    /**
     * Main method to test the maxProfit function.
     */
    public static void main(String[] args) {
        StockProfit sp = new StockProfit();

        // Test case 1: Prices where profit is possible.
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (Test 1): " + sp.maxProfit(prices1)); // Output: 5

        // Test case 2: Prices where no profit is possible.
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit (Test 2): " + sp.maxProfit(prices2)); // Output: 0

        // Test case 3: Single price (no transaction possible).
        int[] prices3 = {5};
        System.out.println("Max Profit (Test 3): " + sp.maxProfit(prices3)); // Output: 0

        // Test case 4: Empty array (no transaction possible).
        int[] prices4 = {};
        System.out.println("Max Profit (Test 4): " + sp.maxProfit(prices4)); // Output: 0
    }
}
