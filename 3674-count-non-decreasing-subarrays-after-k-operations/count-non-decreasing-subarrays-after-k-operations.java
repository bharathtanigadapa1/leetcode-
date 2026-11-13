import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;
        int r = n - 1;
        
        // Monotonic deque storing indices of strictly increasing values from l to r
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int l = n - 1; l >= 0; l--) {
            // Merge all elements at the front of the deque that are <= nums[l]
            while (!dq.isEmpty() && nums[dq.peekFirst()] <= nums[l]) {
                int idx = dq.pollFirst();
                int nextIdx = dq.isEmpty() ? r + 1 : dq.peekFirst();
                long count = nextIdx - idx;
                cost += (long) (nums[l] - nums[idx]) * count;
            }
            dq.offerFirst(l);
            
            // Shrink the right pointer while the operations required exceed k
            while (cost > k) {
                int maxIdx = dq.peekLast();
                cost -= (nums[maxIdx] - nums[r]);
                if (maxIdx == r) {
                    dq.pollLast();
                }
                r--;
            }
            
            // All subarrays starting at l and ending between l and r are valid
            ans += (r - l + 1);
        }
        
        return ans;
    }
}