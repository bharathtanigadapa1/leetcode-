class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        long ans = 0;
        
        int prefixSum = 0;
        int evenCount = 1; 
        int oddCount = 0;
        
        for (int num : arr) {
            prefixSum += num;
            
            if (prefixSum % 2 == 1) {
                ans = (ans + evenCount) % MOD;
                oddCount++;
            } else {
                ans = (ans + oddCount) % MOD;
                evenCount++;
            }
        }
        
        return (int) ans;
    }
}