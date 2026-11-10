class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[]= new int[n+1];
        dp[0]=0;
        for(int j=1;j<=n;j++){
            int minCost=Integer.MAX_VALUE;
            for(int jump=1;jump<=3;jump++){
                int i=j-jump;
                if(i>=0){
                    int stepCost=dp[i]+costs[j-1]+(jump*jump);
                    minCost=Math.min(minCost,stepCost);
                }
               
            }
            dp[j]=minCost;
        }
        return dp[n];
    }
}