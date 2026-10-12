class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007L;
        int[] bitCount = new int[31];

        // 1. Count total set bits at each position
        for (int num : nums) {
            for (int i = 0; i <= 30; i++) {
                if (((num >> i) & 1) == 1) {
                    bitCount[i]++;
                }
            }
        }

        long totalSum = 0;

        // 2. Greedily form the k largest numbers
        for (int step = 0; step < k; step++) {
            long currentNum = 0;
            for (int i = 0; i <= 30; i++) {
                if (bitCount[i] > 0) {
                    currentNum |= (1L << i);
                    bitCount[i]--;
                }
            }
            // 3. Accumulate square modulo 10^9 + 7
            long squared = (currentNum * currentNum) % MOD;
            totalSum = (totalSum + squared) % MOD;
        }

        return (int) totalSum;
    }
}