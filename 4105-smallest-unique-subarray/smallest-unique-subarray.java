import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;
    private static final long BASE1 = 100_003L;
    private static final long BASE2 = 100_019L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }

        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];
        long[] pref1 = new long[n + 1];
        long[] pref2 = new long[n + 1];

        pow1[0] = 1L;
        pow2[0] = 1L;

        for (int i = 0; i < n; i++) {
            long val = nums[i];
            pow1[i + 1] = (pow1[i] * BASE1) % MOD1;
            pow2[i + 1] = (pow2[i] * BASE2) % MOD2;
            pref1[i + 1] = (pref1[i] * BASE1 + val) % MOD1;
            pref2[i + 1] = (pref2[i] * BASE2 + val) % MOD2;
        }

        int lo = 1;
        int hi = n;
        int ans = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasUniqueOfLength(nums, mid, pow1, pow2, pref1, pref2)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    private boolean hasUniqueOfLength(
            int[] nums,
            int length,
            long[] pow1,
            long[] pow2,
            long[] pref1,
            long[] pref2
    ) {
        int n = nums.length;
        Map<Long, Integer> freq = new HashMap<>(n * 2);

        for (int l = 0; l + length <= n; l++) {
            int r = l + length;
            long h1 = (pref1[r] - (pref1[l] * pow1[length]) % MOD1 + MOD1) % MOD1;
            long h2 = (pref2[r] - (pref2[l] * pow2[length]) % MOD2 + MOD2) % MOD2;
            long combinedHash = (h1 << 32) ^ (h2 & 0xffffffffL);
            freq.put(combinedHash, freq.getOrDefault(combinedHash, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}