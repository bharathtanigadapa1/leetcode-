class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freeGain = new int[n];

        for (int i = 0; i < n; i++) {
            int f1 = items[i][0];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % f1 == 0) {
                    cnt++;
                }
            }
            freeGain[i] = cnt;
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int firstCopyGain = 1 + freeGain[i];

            // 1. First copy of item i (at most once for this item)
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + firstCopyGain);
            }

            // 2. Additional copies of item i (unlimited within remaining budget)
            for (int b = price; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1);
            }
        }

        return dp[budget];
    }
}