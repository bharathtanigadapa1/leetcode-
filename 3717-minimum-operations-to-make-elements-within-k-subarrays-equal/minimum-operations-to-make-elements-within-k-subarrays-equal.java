class Solution {

    private static final long INF = (long) 1e18;

    public long minOperations(int[] nums, int x, int k) {
        long[] cost = getCosts(nums, x);

        int n = nums.length;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {

                dp[i][j] = dp[i + 1][j];

                if (i + x <= n) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        cost[i] + dp[i + x][j - 1]
                    );
                }
            }
        }

        return dp[0][k];
    }

    private long[] getCosts(int[] nums, int x) {

        int n = nums.length;
        long[] res = new long[n];

        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        long lowSum = 0;
        long highSum = 0;
        int lowSize = 0;
        int highSize = 0;

        for (int i = 0; i < n; i++) {

            int val = nums[i];

            if (lowSize == 0 || val <= low.lastKey()) {
                add(low, val);
                lowSum += val;
                lowSize++;
            } else {
                add(high, val);
                highSum += val;
                highSize++;
            }

            if (i >= x) {
                int rem = nums[i - x];

                if (low.containsKey(rem)) {
                    remove(low, rem);
                    lowSum -= rem;
                    lowSize--;
                } else {
                    remove(high, rem);
                    highSum -= rem;
                    highSize--;
                }
            }

            while (lowSize < highSize) {
                int move = high.firstKey();

                remove(high, move);
                highSum -= move;
                highSize--;

                add(low, move);
                lowSum += move;
                lowSize++;
            }

            while (lowSize > highSize + 1) {
                int move = low.lastKey();

                remove(low, move);
                lowSum -= move;
                lowSize--;

                add(high, move);
                highSum += move;
                highSize++;
            }

            if (i >= x - 1) {
                long median = low.lastKey();

                long cost =
                        median * lowSize - lowSum
                      + highSum - median * highSize;

                res[i - x + 1] = cost;
            }
        }

        return res;
    }

    private void add(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int x) {
        int cnt = map.get(x);
        if (cnt == 1) map.remove(x);
        else map.put(x, cnt - 1);
    }
}