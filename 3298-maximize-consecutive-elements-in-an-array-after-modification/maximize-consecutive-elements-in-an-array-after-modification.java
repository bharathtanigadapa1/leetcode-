import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 1;

        for (int x : nums) {
            int len1 = dp.getOrDefault(x - 1, 0) + 1;
            int len2 = dp.getOrDefault(x, 0) + 1;

            dp.put(x, Math.max(dp.getOrDefault(x, 0), len1));
            dp.put(x + 1, Math.max(dp.getOrDefault(x + 1, 0), len2));

            ans = Math.max(ans, dp.get(x));
            ans = Math.max(ans, dp.get(x + 1));
        }

        return ans;
    }
}