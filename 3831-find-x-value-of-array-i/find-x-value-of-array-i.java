class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k]; // Frequencies of remainders ending at current element

        for (int num : nums) {
            long[] nextDp = new long[k];
            int modVal = num % k;

            // 1. Single-element subarray starting at current num
            nextDp[modVal] += 1;

            // 2. Extend all subarrays ending at the previous index
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRem = (r * modVal) % k;
                    nextDp[newRem] += dp[r];
                }
            }

            // 3. Accumulate counts into the global result
            for (int r = 0; r < k; r++) {
                result[r] += nextDp[r];
            }

            dp = nextDp;
        }

        return result;
    }
}